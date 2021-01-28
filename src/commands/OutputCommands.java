package commands;

import error.Error;
import filesystem.FileManager;
import filesystem.FileSystemNode;

/**
 * This Class extends ShellCommands and print Strings in the Shell
 */
public class OutputCommands extends ShellCommands {

  /**
   * This method deals with standard output.
   * Print the String str in the shell.
   * @param str is the content wanted to be printed
   */
  public static void println(String str) {
    System.out.println(str);
    //print the output of the system
  }
  public static void print(String str) {
    System.out.print(str);
    //print the output of the system
  }
  
  public static void directToFile(FileManager fileSys, String str, String outfile, String sign) {
    
    FileSystemNode tarFile = fileSys.findNode(outfile);
    if (tarFile == null) {
      
      if (outfile.contains("/")) {
        int index = outfile.lastIndexOf("/");
        //test the length of outfile
        String parentPath = outfile.substring(0, index);
        String name = outfile.substring(index + 1);
        if (parentPath.equals("")) parentPath = "/";
        if (!Error.validName(name)) return;
        //if error exists, return
        FileSystemNode parentDir = fileSys.findNode(parentPath);
        tarFile = fileSys.createNode(parentDir, name, false);
        //create a target file
      } else {
        if (!Error.validName(outfile)) return;
        tarFile = fileSys.createNode(fileSys.getCurrentDir(), outfile, false);
      }
      tarFile.setContent(str);
      //Change the content of the target file
    } else {
      if (sign.equals(">>")) tarFile.setContent(tarFile.getContent() + str); 
      else if (sign.equals(">")) tarFile.setContent(str); 
    }
  }
}

package commands;

import filesystem.FileManager;
import error.Error;
import filesystem.FileSystemNode;

/**
 * This Class extends OutputCommands. Concatenate display contents of the given
 * file on the console, more than one file can be provided.
 */
public class Concatenate extends OutputCommands {

  /**
   * This method read and parse the user import. If valid file names are
   * provided, display their contents on the console.stop at the first
   * invalid argument and do not process the rest of the arguments.
   * @param fileSys is the mock file system
   * @param parameters is the given file/ a list of files
   */
  public static void cat(FileManager fileSys, String parameters) {
    Boolean redirect = false;
    String output = "";
    String targetFile = "";
    String[] pArray = parameters.split(" ");
    if (pArray.length >= 2 &&
        (pArray[pArray.length - 2].equals(">") || pArray[pArray.length - 2].equals(">>")) ) {
      targetFile = pArray[pArray.length - 1];
      redirect = true;
      String newP = "";
      for (int i = 0; i < pArray.length - 2; i++) newP = newP + pArray[i] + " ";
      parameters = newP.trim();
    }
    
    int i = 0;
    for (String path : parameters.split(" ")) {
      if(!Error.checkFilePath(fileSys,path)){
        break;
        //if error exists, break
      }
      if (i != 0) {
        output = output + "\n\n\n";
      }
      
      //use three lines to separate the files

      FileSystemNode file = fileSys.findNode(path);
      output = output + file.getContent() + "\n";
      i++;
      //else, print the content of the file
    }
    if (redirect) 
      OutputCommands.directToFile(fileSys, output, targetFile, pArray[pArray.length - 2]);
    else OutputCommands.print(output);
  }
}
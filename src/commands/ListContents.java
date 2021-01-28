package commands;

import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
import error.Error;
// number of lines checked!
/**
 * The ListContents class extends OutputCommands which display the contents of
 * a file, or files and directories in a given path. The given paths can be both
 * relative or absolute.
 */
public class ListContents extends OutputCommands {

  /**
   * This method list the contents of specific elements according to the
   * given parameter.
   * If parameter is not given, print the contents (file or directory) of the
   * current directory, with a new line following
   * each of the content
   * Otherwise, for each path parameters, the order listed:
   * If parameters specifies a file print parameter
   * If parameters specifies a directory, print p, a colon,
   * then the contents of that directory, then an extra new line.
   * If p does not exist, print an error message.
   * If -P is included in  parameters, it recursively list all subdirectories.
   * @param fileSys is the mock file system
   * @param parameters is the list of paths given by user
   */

  public static void ls(FileManager fileSys, String parameters) {
    boolean isR = false;
    if (parameters.startsWith("-R")) {
      parameters = parameters.replace("-R", "").trim();
      isR = true;
    }
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
    helper(fileSys, output, parameters, isR, redirect, pArray, targetFile);
  }
  /**
   * This method parses the parameters to call listContentOf
   * @param fileSys is the mock system
   * @param output is the output string
   * @param parameters for parameters
   * @param isR for recursive or not
   * @param redirect for redirect or not
   * @param pArray for the pArray
   * @param targetFile for target file name
   */
  public static void helper(FileManager fileSys, String output, String parameters,
      boolean isR, boolean redirect, String[] pArray, String targetFile){
    // if no paths given
    if (parameters.equals("")) {
      if (isR) output = lsR(fileSys, fileSys.getCurrentDir(), 0);
      else output = listContentOf(fileSys, fileSys.getCurrentDir(), false);
      // if paths are given
    } else {
      for (String path : parameters.split(" ")) { // loop over all arguments
        if(!Error.checkPath(fileSys, path)) return; // if the path DNE, print Error msg and return
        FileSystemNode node = fileSys.findNode(path);
        // if the path exist
        if (node.getType()) { // if it is a Dir
          if (isR) output = output + lsR(fileSys, node, 0);
          else output = output + listContentOf(fileSys, node, true);
        } else {  // if it is a file
          output = output + path + "\n";
        }
        output = output + "\n";
      }
    }
    if (redirect)
      OutputCommands.directToFile(fileSys, output, targetFile, pArray[pArray.length - 2]);
    else OutputCommands.print(output);
  }
  /**
   * This method list the contents of a target, either a file of a dir
   * @param fileSys is the mock system
   * @param tar is the target
   * @param printColon for printing colon
   */
  public static String listContentOf(FileManager fileSys, FileSystemNode tar, boolean printColon) {
    String output = "";
    if (printColon) output = output + tar.getPath() + ":" + "\n";
    ArrayList<FileSystemNode> contentList = fileSys.getChildren(tar);
    for (FileSystemNode content : contentList) {
      output = output + content.toString() + "\n";
    }
    output = output + "\n";
    
    return output;
  }
  
  /**
   * This method recursively list contents of all subdirectories
   * @param fileSys is the mock System
   * @param currDir is the current Directory
   * @param depth is the depth
   */
  public static String lsR(FileManager fileSys,  FileSystemNode currDir, int depth) {
    String output = "";
    if (depth == 0) {
      output = output + currDir.getGetName() + ":" + "\n";
      depth++;
    }
    ArrayList<FileSystemNode> childrenList =fileSys.getChildren(currDir);
    for (FileSystemNode node : childrenList) {
      output = output + "\t".repeat(depth) + node.getGetName();
      if (node.isDir) {
        output = output + ":\n";
        output = output + lsR(fileSys, node, depth+1);
      } else output = output + "\n";
    }
    return output;
  }

  

}
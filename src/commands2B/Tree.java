package commands2B;

import static commands.OutputCommands.println;

import commands.ShellCommands;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
// number of lines checked!

/**
 * This is the class handles displaying the system with the format of binary
 * Tree
 */

public class Tree extends ShellCommands {

  /**
   * This method print the content of the file system in binary tree format on
   * the shell.
   * @param fileSys is the mock file system
   * @param currPath is the current path
   * @param depth is the recursion depth
   */
  public static void tree(FileManager fileSys, FileSystemNode currPath, int depth){
    if(depth == 0) {
      println("/");
      depth++;
    }
    ArrayList<FileSystemNode> childrenList =fileSys.getChildren(currPath);
    for (FileSystemNode node : childrenList) {
      println("\t".repeat(depth) + node.getGetName());
      if (node.isDir) {
        tree(fileSys, node, depth+1);
      }
    }
  }
}


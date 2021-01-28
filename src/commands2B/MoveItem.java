package commands2B;

import commands.ShellCommands;
import error.Error;
import filesystem.FileManager;
import filesystem.FileSystemNode;
// number of lines checked!
/**
 * This Class extends ShellCommands, Since users might frequently move item from
 *  one directory to another directory. This class is designed for this purpose
 */

public class MoveItem extends ShellCommands {

  /**
   * This method parse the input parameters and seperate it into OLDPATH and
   * NEWPATH. Move item OLDPATH to NEWPATH. Both OLDPATH and NEWPATH may be \
   * relative to the current directory or may be full paths. If NEWPATH is a
   * directory, move the item into the directory.
   * @param fileSys is the mock file system
   * @param parameters is the paths for oldpath and new path
   */
  public static void mv(FileManager fileSys, String parameters) {
    if (!Error.paraNumEqual(parameters, 2, MV_COMMAND)) {
      return;
    }
    String path1 = parameters.split(" ")[0];
    String path2 = parameters.split(" ")[1];
    FileSystemNode node1 = fileSys.findNode(path1);
    FileSystemNode node2 = fileSys.findNode(path2);
    if (node1 != null && node2 != null) { 
      // both paths exist
      // case1: mv existing_file_path existing_dir_path
      // case2: mv existing_dir_path1 existing_dir_path2
      if ( node2.isDir) {
        fileSys.moveNode(node1, node2);
      }
      // case6: mv existing_file_path1 existing_file_path2
      if (!node1.isDir && !node2.isDir) {
        node2.content = node1.content;
        fileSys.removeNode(node1);
      }
    }
    else if (node1 != null && node2 == null) { 
      // node1 exists but node2 DNE
      String parPathOfNode2 = pathCutter(path2);
      FileSystemNode node2Par = fileSys.findNode(parPathOfNode2);
      String node2Name = path2.split("/")[path2.split("/").length - 1];
      // case3: mv existing_dir_path1 new_dir_path
      // case4 & 5: mv existing_file_path1    new_file_path
      // Note: new_dir_path only has the very last directory in its path that does not exist.
      // You cannot have more than 1 directory in its path that does not exist.
      if (Error.checkPath(fileSys, parPathOfNode2)) {
        fileSys.moveNode(node1, node2Par);
        node1.setGetName(node2Name);
      }
    }
  }

  /**
   * This method takes in a parameter path cut the
   * last part of a path
   * @param path is the path wanted to be operated
   * @return the string of the path with last put cut off
   */
  public static String pathCutter(String path){ // get the path of the parentDir(cut the last part)
    String[] stringArray = path.split("/");
    if (stringArray.length == 1) return "/"; // root
    StringBuffer sb = new StringBuffer();
    for(int i = 0; i < stringArray.length - 1; i++) {
      sb.append("/" + stringArray[i]);
    }
    return sb.toString();
  }

}

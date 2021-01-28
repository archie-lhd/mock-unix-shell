package commands2B;

import static commands.OutputCommands.println;

import commands.ShellCommands;
import error.Error;
import filesystem.FileManager;
import filesystem.FileSystemNode;
// number of lines checked!
/**
 * This Class extends ShellCommands, Since users might frequently copy item from
 * one directory to another directory. This class is designed for this purpose
 */
public class CopyItem extends ShellCommands {

  /**
   * This method parse the input passing by parameters. Make a duplication of
   * item OLDPATH at NEWPATH. Both OLDPATH and NEWPATH may be relative to the
   * current directory or may be full paths. If NEWPATH directory, move the
   * item into the directory.
   * @param fileSys is the mock file system
   * @param parameters is the paths of old and new location
   */
  public static void cp(FileManager fileSys, String parameters) {
    if (!Error.paraNumEqual(parameters, 2, CP_COMMAND)) return;
    String path1 = parameters.split(" ")[0];
    String path2 = parameters.split(" ")[1];
    FileSystemNode node1 = fileSys.findNode(path1);
    FileSystemNode node2 = fileSys.findNode(path2);
    if (node1 != null && node2 != null) { 
      // both paths exist
      // case7: cp existing_file_path  existing_dir_path
      // case8: cp existing_dir_path1  existing_dir_path2
      if (node2.isDir) fileSys.moveNode(node1, node2);
      // case9: cp existing_file_path1    existing_file_path2
      if (!node1.isDir && !node2.isDir) node2.content = node1.content;
    } else if (node1 != null && node2 == null) { // node1 exists but node2 DNE
      String parPathOfNode2 = MoveItem.pathCutter(path2);
      FileSystemNode node2Par = fileSys.findNode(parPathOfNode2);
      String node2Name = path2.split("/")[path2.split("/").length - 1];
      // case10: cp existing_file_path   new_file_path
      if (!node1.isDir && Error.checkPath(fileSys, parPathOfNode2)) {
        FileSystemNode node1cp = fileSys.createNode(node2Par, node1.getGetName(),false);
        node1cp.setContent(node1.getContent());
      }
      // case11: cp existing_dir_path   new_file_path
      if (node1.isDir) println("Error: Cannot copy directory to file");
      // Note: new_dir_path only has the very last directory in its path that does not exist.
      // You cannot have more than 1 directory in its path that does not exist.
      if (Error.checkPath(fileSys, parPathOfNode2)) {
        fileSys.moveNode(node1, node2Par);
        node1.setGetName(node2Name);
      }
    }
  }
}

package commands2B;

import commands.OutputCommands;
import commands.ShellCommands;
import error.Error;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
// number of lines checked!
/**
 * This Class extends ShellCommands, Since users might frequently remove item
 * from the file system, this class is designed for this purpose
 */
public class RemoveItem extends ShellCommands {

  /**
   * This method removes all the child node of the node tar
   * @param fileSys
   * @param tar
   */
  private static void clearAllChildren(FileManager fileSys, FileSystemNode tar) {
    ArrayList<FileSystemNode> list = fileSys.getChildren(tar);
    if (list == null) {
      
      //OutputCommands.print("complete!");
      return;
    }
    for (FileSystemNode child : list) {
      //if (child.getClass() != sampleFile.getClass()) { // it is a dir//}
      clearAllChildren(fileSys, child);
      
      fileSys.removeNode(child);
      OutputCommands.println("deleted " + child.getName);
    }

  }

  /**
   * This method removes the directory from the fileSys.
   * @param fileSys
   * @param parameter
   */
  public static void rm(FileManager fileSys, String parameter) {
    if (!Error.paraNumEqual(parameter, 1, RM_COMMAND))
      return;
    if(!Error.checkDirPath(fileSys, parameter)){
      return;
    }
    FileSystemNode tar = fileSys.findNode(parameter);
    clearAllChildren(fileSys, tar);
    fileSys.removeNode(tar);
    OutputCommands.println("deleted " + tar.getName);
  }

}

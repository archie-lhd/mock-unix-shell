package commands;

import filesystem.FileSystemNode;
import filesystem.FileManager;
import error.Error;

/**
 * This Class extends ShellCommands, which handles the Command MakeDirectory,
 * i.e. "mkdir". The method in this class will create new directories in the
 * mock file system
 */
public class MakeDirectory extends ShellCommands{

  /**
   * This is a helper method for mkdir which handles only one directory at
   * a time and return true.
   * The directory expected to be added to the fileSys is passing through
   * String path.
   * If the given path already exists, return false
   * @param fileSys is the mock file system
   * @param path is the directory/ list of directories
   * @return boolean if the creation is valid, i.e. whether the given directory
   * already exists.
   */
  private static boolean mkdirHelper(FileManager fileSys, String path) {
    
    if (Error.dirPathExist(fileSys, path)) {
      return false;
    }
    if (!Error.validParentPath(fileSys, path)) return false;
    else if (path.contains("/")) {
      int index = path.lastIndexOf("/");
      String parentPath = path.substring(0, index);
      String name = path.substring(index + 1);
      if (parentPath.equals("")) parentPath = "/";
      if (!Error.validName(name)) {
        return false;
      }
      FileSystemNode parentDir = fileSys.findNode(parentPath);
      fileSys.createNode(parentDir, name, true);
    } else {
      if (!Error.validName(path)) {
        return false;
        //if error exists, return false
      }
      fileSys.createNode(fileSys.getCurrentDir(), path, true);
      //else create a directory for the path
    }
    return true;
  }

  /**
   * This method create directories in the fileSys, each of parameters
   * may be relative to the current directory or maybe a full path.
   * Continue to create directories based on the
   * arguments until you hit the first invalid argument.
   * @param fileSys
   * @param parameters
   */
  public static void mkdir(FileManager fileSys, String parameters) {
    int i = 0;
    int len = parameters.split(" ").length;
    while(i < len) {
      if(!mkdirHelper(fileSys, parameters.split(" ")[i])){
        break;
      }
      i = i+1;
    }
  }
  
}

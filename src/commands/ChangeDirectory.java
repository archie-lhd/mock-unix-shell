package commands;

import static commands.OutputCommands.println;

import filesystem.FileSystemNode;
import filesystem.FileManager;
import error.Error;

/**
 * This Class extends ShellCommand. It handles the command Change Directory,
 * i.e. "cd". And it can also take in paths such as ".." and "."
 */
public class ChangeDirectory extends ShellCommands{

  /**
   * This method read and pass the user import, and check if the import string is
   * a valid path of a Directory. If so, change directory to DIR, which may be
   * relative to the current directory or maybe a full path.
   * @param fileSys is the mock file System
   * @param path is the directory wanted to change to may be
   *        relative to the current directory or maybe a full path.
   */
  public static void cd(FileManager fileSys, String path) {
    
    if (path.equals("..")) {
      if (fileSys.getCurrentDir().getParentDir() == null) {
        println("this is the root directory!");
        return;
        //test the whether if it is a root directory
      }
      fileSys.updateCurrentDir(fileSys.getCurrentDir().getParentDir());
      //update the file current directory
    }
    else if(path.equals(".")){
      return;
    }
    else if(!Error.checkDirPath(fileSys, path)){
      return;
      //if error exists, return the program
    } else {
      FileSystemNode dir = fileSys.findNode(path);
      fileSys.updateCurrentDir(dir);
    }

  }
}

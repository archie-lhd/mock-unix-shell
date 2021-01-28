package commands;

import filesystem.FileManager;
//import the fileManger

/**
 * This class deals with the popping Directory function of the shell.
 * The current working directory can be changed to the directory in the
 * directory stack of the mock filesystem
 */
public class PopDirectory extends ShellCommands{

  /**
   * This method pop the Directory at the top of Directory Stack and then change
   * the currDir to it
   * @param fileSys is the mock file system
   */
  public static void popd(FileManager fileSys){
    fileSys.popDir();
    //pop the directory through FileManager
  }
}

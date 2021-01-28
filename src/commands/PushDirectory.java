package commands;

import filesystem.FileManager;
import error.Error;

/**
 * This Class extends ShellCommands, for user's convenience to quick access
 * to recent directory the the user worked on, this class is designed to push
 * directoried into the stack in the mock file system.
 */
public class PushDirectory extends  ShellCommands{

  /**
   * This method pushes the currDir to the Directory Stack of the fileSys
   * @param fileSys  is the mock file system
   * @param parameter is the directory wanted to be pushed
   */
  public static void PushDir(FileManager fileSys, String parameter){

    if(parameter.equals(".") | parameter.equals("..") ||
        Error.checkPath(fileSys,parameter)){
      fileSys.pushDir(fileSys.getCurrentDir());
      ChangeDirectory.cd(fileSys,parameter);
    }


    //call the method pushDir


  }
}

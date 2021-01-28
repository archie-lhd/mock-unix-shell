package commands;

import filesystem.FileManager;

/**
 * This Class extends OutputCommands, it handles the print working
 * directory function of the shell
 */
public class PrintWorkingDirectory extends OutputCommands {

  /**
   * This method prints the currDir of the fileSys
   * @param fileSys
   */
  public static void pwd(FileManager fileSys) {
    println(fileSys.getCurrentDir().getPath());
    //print out the path of the current working directory
  }
}

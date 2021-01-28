package commands;

import filesystem.FileManager;
import error.Error;

/**
 * This is the class for Echo commands for printing contens in the Shell
 */
public class EchoCommands extends ShellCommands {

  /**
   * This method print the String user input in the console
   * @param fileSys is the mock file system
   * @param parameters is the string
   */
  public static void echo(FileManager fileSys, String parameters) {       
    
    String[] parameterArray = parameters.split(" ");
    String str = parameterArray[0];
    if (!Error.validString(str)) return;
    str = str.substring(1, str.length()-1);
    
    if (parameterArray.length == 1) {
      OutputCommands.println(str);
    } else if (Error.isValidRedirectSign(parameterArray[1])) {
      String outfile = parameterArray[2];
      if (Error.validParentPath(fileSys, outfile)) {
        OutputCommands.directToFile(fileSys, str, outfile, parameterArray[1]);
      } else return;
    }
    
  }
}

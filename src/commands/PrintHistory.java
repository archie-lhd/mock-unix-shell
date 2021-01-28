package commands;

import filesystem.FileManager;
import java.util.ArrayList;
import java.util.List;
import error.Error;

/**
 * This Class extends Output Commands. It is
 * the class for the command History. It helps with printing the previous
 * command typed by the user for convenience.
 */
public class PrintHistory extends OutputCommands {

  /**
   *
   * @param fileSys is the mock file system
   * @param parameters
   */
  public static void printHistory(FileManager fileSys, String parameters){
    
    Boolean redirect = false;
    String output = "";
    String targetFile = "";
    String[] pArray = parameters.split(" ");
    if (pArray.length >= 2 &&
        (pArray[pArray.length - 2].equals(">") || pArray[pArray.length - 2].equals(">>")) ) {
      targetFile = pArray[pArray.length - 1];
      redirect = true;
      String newP = "";
      for (int i = 0; i < pArray.length - 2; i++) newP = newP + pArray[i] + " ";
      parameters = newP.trim();
    }
    
    if(parameters.equals("")) output = fileSys.printAllCommand();
    else {
      if(Error.isNumber(parameters)){
        int hisnum = Integer.valueOf(parameters);
        output = fileSys.printNumCommand(hisnum);
      }
    }
    if (redirect) 
      OutputCommands.directToFile(fileSys, output, targetFile, pArray[pArray.length - 2]);
    else OutputCommands.print(output);
  }
}

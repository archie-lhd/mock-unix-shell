package error;


import filesystem.FileManager;
import java.util.Arrays;
import commands.OutputCommands;

public class Error {

  public Error (){

  }

  /**
   * Test if the number of parameters equal
   * @param parameters
   * @param num
   * @param cmdName
   * @return
   */
  public static boolean paraNumEqual(String parameters, int num, String... cmdName){
    int actual_num = parameters.split(" ").length;
    if (parameters.equals("")) actual_num = 0;
    if(actual_num == num){
      //test whether the number is equal to actual_num
      return true;
    }
    else{
      if (cmdName.length != 0) System.out.print(cmdName[0] + ": ");
      OutputCommands.println("takes exactly " + num +" arguments (" + actual_num + " entered)");
      return false;
      //test the number of parameters
    }
  }
  
  public static boolean paraNumEqual(String parameters, int[] nums, String... cmdName){
    int actual_num = parameters.split(" ").length;
    if (parameters.equals("")) actual_num = 0;
    for (int num : nums) {     
      if(actual_num == num){
        return true;
      }     
    }
    if (cmdName.length != 0) System.out.print(cmdName[0] + ": ");
    OutputCommands.println("takes exactly " + Arrays.toString(nums) + 
        " arguments (" + actual_num + " entered)");
    return false;
    //test the number of parameters
  }

  /**
   * Test the number of parameters does not exceed the maximum value
   * @param parameters
   * @param max
   * @param cmdName
   * @return
   */
  public static boolean paraNumNotExceedMax(String parameters, int max, String... cmdName){
    int actual_num = parameters.split(" ").length;
    if (parameters.equals("")) actual_num = 0;
    if(actual_num <= max){
      return true;
    }
    else{
      if (cmdName.length != 0) System.out.print(cmdName[0] + ": ");
      OutputCommands.println("too many arguments (max: " + max +")");
      //OutputCommands.print("should only have "+num);
      return false;
    }
  }
  
  public static boolean paraNumAtLeastMin(String parameters, int min, String... cmdName){
    int actual_num = parameters.split(" ").length;
    if (parameters.equals("")) actual_num = 0;
    if(actual_num >= min){
      return true;
    }
    else{
      if (cmdName.length != 0) System.out.print(cmdName[0] + ": ");
      OutputCommands.println("need more arguments (min: " + min +")");
      return false;
    }
  }


  /**
   * Check a given String refers to a Directory
   * @param fileSys
   * @param parameter
   * @return
   */
  public static boolean checkDirPath(FileManager fileSys,String parameter){
    if(fileSys.findNode(parameter) != null && fileSys.findNode(parameter).isDir){
      return true;
    }
    else {
      OutputCommands.println(parameter + ": No such directory");
      //test if the directory path is valid
      return false;
    }
  }

  /**
   * Check if a path exist
   * @param fileSys
   * @param parameter
   * @return
   */
  public static boolean dirPathExist(FileManager fileSys, String parameter){
    if(fileSys.findNode(parameter) != null){
      OutputCommands.println(parameter + ": Directory path exists");
      return true;
      //returns when the directory path already exists
    }
    else {
      return false;
    }
  }

  /**
   * Check if the given path refers to a file
   * @param fileSys
   * @param parameter
   * @return
   */
  public static boolean checkFilePath(FileManager fileSys,String parameter){
    if(fileSys.findNode(parameter) != null){
      return true;
    }
    else {
      OutputCommands.println(parameter + ": No such file");
      // test the file path is valid or not
      return false;
    }
  }

  /**
   * Check the given String is a valid path
   * @param fileSys
   * @param parameter
   * @return
   */
  public static boolean checkPath(FileManager fileSys,String parameter){
    if(fileSys.isPath(parameter)){
      return true;
    }
    else {
      OutputCommands.println(parameter + ": No such file or directory");
      // test the path is valid or not
      return false;
    }
  }

  /**
   * Check is the given String is a valid name for a directory or a file
   * @param name
   * @return
   */
  public static boolean validName(String name) {
    if (name.equals("")) return false;
    
    String invalid = "/. !@#$%^&*(){}~|<>?";
    
    for (int i = 0 ; i < invalid.length() ; i++) {
      if (name.indexOf(invalid.charAt(i)) != -1) {
        OutputCommands.println("This is an invalid name!  " + name);
        //test if the name contains illegal symbols
        return false;
      }
    }
    
    return true;
  }

  /**
   * Check if the given path is a valid parent path
   * @param fileSys
   * @param path
   * @return
   */
  public static boolean validParentPath(FileManager fileSys, String path) {
    if (path.contains("/")) {
      int index = path.lastIndexOf("/");
      String parentPath = path.substring(0, index);
      //String name = path.substring(index + 1);
      
      if (parentPath.equals("")) parentPath = "/";
        
      if (!Error.checkDirPath(fileSys, parentPath)) {
        return false;
      }
    }
    
    return true;
  }

  /**
   * Check the given String is valid content of a file
   * @param str
   * @return
   */
  public static boolean validString(String str) {
    if (str.startsWith("\"") && str.endsWith("\"")) {
      String substr = str.substring(1, str.length()-1);
      if (substr.contains("\"")) {
        OutputCommands.println(str + ": illegal string! Should not have \" inside");
        // test the string is valid or not
        return false;
      }
    } else {
      OutputCommands.println(str + ": illegal string! Should start and end with \"");
      return false;
    }
    return true;
  }

  /**
   * Check if the given command is Valid
   */
  public static void invalidCommand(String cmdName){
    OutputCommands.println("command not found: " + cmdName);
  }//test whether the command is valid or not

  public static boolean isNumber(String str) {
    for (int i = str.length(); --i >= 0; ) {
      if (!Character.isDigit(str.charAt(i))) {
        OutputCommands.println("This is not a valid parameter");
        return false;
      }
    }
    return true;
  }
  
  public static boolean isValidRedirectSign(String s) {
    if (s.equals(">") || s.equals(">>")) return true;
    else {
      OutputCommands.println("Invalid redirect sign: " + s + " (should be > or >>)");
      return false;
    }
  }
}

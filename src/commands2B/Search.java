package commands2B;
import static commands.OutputCommands.println;
import commands.ShellCommands;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
import error.Error;
// number of lines checked!

/**
 * This class extend ShellCommands which help with search a specific item in the
 * given file system
 */
public class Search extends ShellCommands {

  /**
   * This is the main method handles the searching process
   * @param fileSys is the mock file system
   * @param parameters is the target
   */
  
  public static void search(FileManager fileSys, String parameters) {
    int part = 0; String type = "undefined"; String fileName = "";
    ArrayList<FileSystemNode> pathList = new ArrayList<>();
    for (String str: parameters.split(" ")) {
      switch (part) {
        case 0:
          if (!str.startsWith("-type")) { // adding paths to pathList
            if (Error.checkDirPath(fileSys, str)) { pathList.add(fileSys.findNode(str)); part--; }
            else return;  // path DNE then return
          } else part ++; // if -type then move on to next part
          break;
        case 2:
          type = checkType(str);
          if (type == null) return;
          break;
        case 3:
          if (!str.equals("-name")) { println("search: missing option -name"); return; }
          break;
        case 4:
          if (Error.validString(str)) fileName = str.substring(1, str.length() - 1);
          else return;
          break;
        case 5:
          println("search: unexpected argument: " + str);
          return;
        default: throw new IllegalStateException("Unexpected value: " + part);
        } part++; }
    searchInList(fileSys, pathList, fileName, type);
  }

  /**
   * This is the helper method determing the target type
   * @param str is target type
   * @return the type of the target
   */
  public static String checkType(String str){
    if (str.equals("d")) return "directory";
    else if (str.equals("f")) return "file";
    else {
      println("search: illegal option -type " + str +
          "\nusage: search path ... -type [f|d] -name expression");
      return null;
    }
  }

  /**
   * This is a helper method which conduct the actual process in the list
   * @param fileSys is the system
   * @param pathList is the list of paths
   * @param name name of the target
   * @param type type of the taget
   */
  public static void searchInList(FileManager fileSys,
      ArrayList<FileSystemNode> pathList, String name, String type) {
    for (FileSystemNode node: pathList) {
      if (!findNodeIn(fileSys, name, node, type))
        println("The "+ type + " '" + name+ "' does not exist within " + node.getGetName());
    }
  }

  /**
   * This is a helper method
   * @param fileSys is the mock file system
   * @param name name of target
   * @param tar node of target
   * @param type type of target
   * @return whether found the target
   */
  public static boolean findNodeIn(FileManager fileSys, String name,
      FileSystemNode tar, String type) {
    if (fileSys == null || name == null || tar == null || type == null) return false;
    ArrayList<FileSystemNode> childrenList = fileSys.getChildren(tar);
    boolean existence = false;
    for (FileSystemNode node : childrenList) {
      if (type.equals("directory")) {
        if (node.getGetName().equals(name) && node.isDir) {
          println(node.getPath());
          existence = true;
        }
      } else if (type.equals("file")) {
        if (node.getGetName().equals(name) && !node.isDir) {
          println(node.getPath());
          existence = true;
        }
      }
      if (node.isDir) {
        if (findNodeIn(fileSys, name, node, type)) existence = true;
      }
    }
    return existence;
  }
}

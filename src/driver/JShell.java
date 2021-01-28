// **********************************************************
// Assignment2:
// Student1:
// UTORID user_name:yujiale
// UT Student #:1005726715
// Author:Jiale Yu
//
// Student2:
// UTORID user_name: liuhoude
// UT Student #: 1005722158
// Author: Houde Liu
//
// Student3:
// UTORID user_name: zhuzhe28
// UT Student #:1005726788
// Author:Zhenye Zhu
//
// Student4:
// UTORID user_name:shenyif5
// UT Student #:1005723068
// Author:Yifan Shen
//
//
// Honor Code: I pledge that this program represents my own
// program code and that I have coded on my own. I received
// help from no one in designing and debugging my program.
// I have also read the plagiarism section in the course info
// sheet of CSC B07 and understand the consequences.
// *********************************************************
package driver;
import static commands.OutputCommands.println;
import static commands.ShellCommands.*;
import commands.ChangeDirectory;
import commands.Concatenate;
import commands.EchoCommands;
import commands.ExitCommand;
import commands.ListContents;
import commands.MakeDirectory;
import commands.PopDirectory;
import commands.PrintHistory;
import commands.PrintManual;
import commands.PrintWorkingDirectory;
import commands.PushDirectory;
import commands.ShellCommands;
import commands2B.CopyItem;
import commands2B.GetOnlineFile;
import commands2B.LoadJShell;
import commands2B.MoveItem;
import commands2B.RemoveItem;
import commands2B.SaveJShell;
import commands2B.Search;
import commands2B.Tree;
import filesystem.FileManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import error.Error;


public class JShell {

  /**
   *
   * @param args
   * @throws IOException
   */
  public static void main(String[] args) throws IOException {
    String commandLine;
    println("...Activating the Shell");
    println("...Done");
    println("...Close the shell by manually type '" + ShellCommands.EXIT_COMMAND + "'");
    BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
    FileManager fileSys = new FileManager();
    while (true) {
      // read and record the command
      System.out.print("MyShell " + fileSys.getCurrentDir().getPath() + " $ ");
      commandLine = console.readLine().trim();
      fileSys.addCommand(commandLine);
      String cmdCall = commandLine.split("\\s+")[0];
      // get parameters formatted
      StringBuilder sb = new StringBuilder();
      for (int i = 1; i < commandLine.split("\\s+").length; i++) {
        sb.append(" ").append(commandLine.split("\\s+")[i]);
      }
      String parameters = sb.toString().trim();
      switchCases1(fileSys, cmdCall, parameters);
    }
  }
  public static void switchCases1(FileManager fileSys, String cmdCall, String parameters) {
    switch (cmdCall) {
      case EXIT_COMMAND:
        if (Error.paraNumNotExceedMax(parameters, 0, cmdCall)) ExitCommand.exit();
        break;
      case PWD_COMMAND:
        int[] correctNumOfArgument1 = {0,2};
        if (Error.paraNumEqual(parameters, correctNumOfArgument1, cmdCall))
          PrintWorkingDirectory.pwd(fileSys);
        break;
      case POP_COMMAND:
        if (Error.paraNumEqual(parameters, 0, cmdCall)) PopDirectory.popd(fileSys);
        break;
      case MAN_COMMAND:
        int[] correctNumOfArgument5 = {1,3};
        if (Error.paraNumEqual(parameters, correctNumOfArgument5, cmdCall))
          PrintManual.man(fileSys, parameters);
        break;
      case MKDIR_COMMAND:
        if (Error.paraNumAtLeastMin(parameters, 1, cmdCall))
          MakeDirectory.mkdir(fileSys, parameters);
        break;
      default:
        switchCases2(fileSys,cmdCall,parameters);
        break;
    }
  }
  public static void switchCases2(FileManager fileSys, String cmdCall, String parameters){
    switch (cmdCall) {
      case CD_COMMAND:
        if (Error.paraNumEqual(parameters, 1, cmdCall))
          ChangeDirectory.cd(fileSys, parameters);
        break;
      case LS_COMMAND:
        ListContents.ls(fileSys, parameters);
        break;
      case PUSH_COMMAND:
        if (Error.paraNumEqual(parameters, 1, cmdCall))
          PushDirectory.PushDir(fileSys, parameters);
        break;
      case ECHO_COMMAND:
        int[] correctNumOfArgument3 = {1, 3};
        if (Error.paraNumEqual(parameters, correctNumOfArgument3, cmdCall))
          EchoCommands.echo(fileSys, parameters);
        break;
      case HIS_COMMAND:
        int[] correctNumOfArgument4 = {0, 1, 2, 3};
        if (Error.paraNumEqual(parameters, correctNumOfArgument4, cmdCall))
          PrintHistory.printHistory(fileSys, parameters);
        break;
      default:
        switchCases3(fileSys, cmdCall, parameters);
        break;
    }
  }
  public static void switchCases3(FileManager fileSys, String cmdCall, String parameters){
    switch(cmdCall){
      case CAT_COMMAND:
        if (Error.paraNumAtLeastMin(parameters, 1, cmdCall))
          Concatenate.cat(fileSys, parameters);
        break;
      case MV_COMMAND:
        if (Error.paraNumAtLeastMin(parameters, 2, cmdCall)) MoveItem.mv(fileSys, parameters);
        break;
      case RM_COMMAND:
        if (Error.paraNumAtLeastMin(parameters, 1, cmdCall))
          RemoveItem.rm(fileSys, parameters);
        break;
      case  CP_COMMAND:
        if (Error.paraNumAtLeastMin(parameters, 2, cmdCall)) CopyItem.cp(fileSys, parameters);
        break;
      case  CURL_COMMAND:
        if (Error.paraNumAtLeastMin(parameters, 1, cmdCall))
          GetOnlineFile.curl(fileSys, parameters);
        break;
      case TREE_COMMAND:
        if(Error.paraNumNotExceedMax(parameters,0,cmdCall))
          Tree.tree(fileSys, fileSys.getRoot(), 0);
        break;
      default:
        switchCases4(fileSys,cmdCall,parameters);
        break;
    }
  }
  public static void switchCases4(FileManager fileSys, String cmdCall, String parameters){
    switch(cmdCall) {
      case SJ_COMMAND:
        if (Error.paraNumEqual(parameters, 1, cmdCall))
          SaveJShell.save(fileSys, parameters);
        break;
      case LJ_COMMAND:
        if (Error.paraNumEqual(parameters, 1, cmdCall))
          fileSys = LoadJShell.load(fileSys, parameters);
        break;
      case SEARCH_COMMAND:
        Search.search(fileSys, parameters);
        break;
      default:
        Error.invalidCommand(cmdCall);
        break;
    }
  }
}



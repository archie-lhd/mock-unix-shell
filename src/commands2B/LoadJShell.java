package commands2B;

import static commands.OutputCommands.println;
import static commands.ShellCommands.CAT_COMMAND;
import static commands.ShellCommands.CD_COMMAND;
import static commands.ShellCommands.CP_COMMAND;
import static commands.ShellCommands.CURL_COMMAND;
import static commands.ShellCommands.ECHO_COMMAND;
import static commands.ShellCommands.EXIT_COMMAND;
import static commands.ShellCommands.HIS_COMMAND;
import static commands.ShellCommands.LJ_COMMAND;
import static commands.ShellCommands.LS_COMMAND;
import static commands.ShellCommands.MAN_COMMAND;
import static commands.ShellCommands.MKDIR_COMMAND;
import static commands.ShellCommands.MV_COMMAND;
import static commands.ShellCommands.POP_COMMAND;
import static commands.ShellCommands.PUSH_COMMAND;
import static commands.ShellCommands.PWD_COMMAND;
import static commands.ShellCommands.RM_COMMAND;
import static commands.ShellCommands.SEARCH_COMMAND;
import static commands.ShellCommands.SJ_COMMAND;
import static commands.ShellCommands.TREE_COMMAND;

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
import driver.JShell;
import error.Error;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 *
 */
public class LoadJShell {

  /**
   * @param parameters
   * @return
   */

  public static FileManager load(FileManager oldFileSys, String parameters) {
    try {
      FileInputStream fin = new FileInputStream(parameters);
      ObjectInputStream in = new ObjectInputStream(fin);
      FileManager newFileSys = new FileManager();
      newFileSys.loadFileList((LinkedList<FileSystemNode>) in.readObject());
      return newFileSys;
    } catch (IOException | ClassNotFoundException e) {
      println("loadJShell: "+parameters+": no such file or directory");
    }
    return oldFileSys;
  }
}
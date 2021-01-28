package commands2B;

import static commands.OutputCommands.println;

import commands.ShellCommands;
import error.Error;
import filesystem.FileManager;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * This class Save the session of the Shell
 */

public class SaveJShell extends ShellCommands {

  /**
   * @param parameters
   */

  public static void save(FileManager fileSys, String parameters) {
    ObjectOutputStream out;
    try (FileOutputStream fout = new FileOutputStream(parameters)) {
      out = new ObjectOutputStream(fout);
      out.writeObject(fileSys.getFileList());
    } catch (FileNotFoundException e) {
      println("saveJShell: " + parameters + ": parent directory does not exist");
    } catch (IOException e) {
      println("saveJShell: IOException!");
    }
  }
}


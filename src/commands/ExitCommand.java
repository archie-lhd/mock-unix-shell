package commands;

/**
 * This class extends ShellCommands, and ExitCommand helps terminate the Shell.
 */
public class ExitCommand extends ShellCommands{

  /**
   * This method terminate the shell.
   */
  public static void exit() {
    System.out.println("[Process completed]");
    System.exit(0);
    //exit the shell
  }
}

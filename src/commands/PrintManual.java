package commands;

import filesystem.FileManager;

/**
 * This class extends Output Commands, this class helps print the Manual for
 * each command.
 */
public class PrintManual extends OutputCommands {
  static String exitMan = "exit\n\n[DESCRIPTION]\n"
      + "Quit the program";
 
  //command exit quits the program

  static String mkdirMan = "mkdir DIR ...\n\n[DESCRIPTION]\n"
      + "Create directories, each of which may be relative to the current directory or \n"
      + "maybe a full path. mkdir can take in more than one DIR. It stop at the first \n"
      + "invalid argument and do not process the rest of the arguments.";

  static String cdMan = "cd DIR\n\n[DESCRIPTION]\n"
      + "Change directory to DIR, which may be relative to the current directory or may be a \n"
      + "full path. As with Unix, .. means a parent directory and a . means the current \n"
      + "directory. The directory must be /, the forward slash. The foot of the file system \n"
      + "is a single slash: /";

  static String lsMan = "ls [-R] [PATH ...]\n\n[DESCRIPTION]\n"
      + "If –R is present, recursively list all subdirectories.\n"
      + "If no paths are given, print the contents (file or directory) of the current \n"
      + "directory, with a new line following each of the content (file or directory).\n"
      + "Otherwise, for each path p, the order listed:\n"
      + "- If p specifies a file, print p\n"
      + "- If p specifies a directory, print p, a colon, then the contents of that \n"
      + "directory, then an extra new line.\n"
      + "- If p does not exist, print a suitable message.";

  static String pwdMan = "pwd\n\n[DESCRIPTION]\n"
      + "Print the current working directory (including the whole path).";

  static String pushdMan = "pushd DIR\n\n[DESCRIPTION]\n"
      + "Saves the current working directory by pushing onto directory stack and then \n"
      + "changes the new current working directory to DIR. The push must be consistent \n"
      + "as per the LIFO behavior of a stack. The pushd command saves the old current \n"
      + "working directory in directory stack so that it can be returned to at any time \n"
      + "(via the popd command). The size of the directory stack is dynamic and dependent \n"
      + "on the pushd and the popd commands.";
  static String popdMan = "popd\n\n[DESCRIPTION]\n"
      + "Remove the top entry from the directory stack, and cd into it. The removal must \n"
      + "be consistent as per the LIFO behavior of a stack. The popd command removes the \n"
      + "top most directory from the directory stack and makes it the current working \n"
      + "directory. If there is no directory onto the stack, then give appropriate error \n"
      + "message.";

  static String hisMan = "history [number]\n\n[DESCRIPTION]\n"
      + "This command will print out recent commands, one command per line. i.e.\n"
      + "1.cd ..\n"
      + "2. mkdir textFolder\n"
      + "3. echo \"Hello World\"\n"
      + "4. fsjhdfks\n"
      + "5. history\n\n"
      + "The above output from history has two columns. The first column is numbered \n"
      + "such that the line with the highest number is the most recent command. The \n"
      + "most recent command is history. The second column contains the actual command. \n"
      + "Note: Your output should also contain as output any syntactical errors typed \n"
      + "by the user as seen on line 4.\n"
      + "We can truncate the output by specifying a number (>=0) after the command. \n"
      + "For instance, if we want to only see the last 3 commands typed, we can type \n"
      + "the following on the command line:\n"
      + "history 3\n"
      + "And the output will be as follows:\n"
      + "4. fsjhdfks \n"
      + "5. history \n"
      + "6. history 3";

  static String catMan = "cat FILE1 [FILE2 ...]\n\n[DESCRIPTION]\n"
      + "Display the contents of FILE1 and other files (i.e. File2 ....) concatenated \n"
      + "in the shell. You may want to use three line breaks to separate the contents \n"
      + "of one file from the other file.";

  static String echoMan = "echo String\n\n[DESCRIPTION]\nPrint String";

  static String manMan = "man CMD\n\n[DESCRIPTION]\n"
      + "Print documentation for CMD. The man command now only takes one argument.\n";

  static String rmMan = "rm DIR\n\n[DESCRIPTION]\n"
      + "Removes the DIR from the file system. This also removes all the children\n"
      + "of DIR (i.e. it acts recursively).";
  static String mvMan = "mv OLDPATH NEWPATH\n\n[DESCRIPTION]\n"
      + "Move item OLDPATH to NEWPATH. Both OLD- PATH and NEWPATH may be relative \n"
      + "to the current directory or may be full paths. If NEWPATH is a directory, \n"
      + "move the item into the directory.\n";
  static String cpMan = "cp OLDPATH NEWPATH\n\n[DESCRIPTION]\n"
      + "Like mv, but don’t remove OLDPATH. If OLDPATH is a directory, recursively \n"
      + "copy the contents.\n";
  static String curlMan = "curl URL\n\n[DESCRIPTION]\n"
      + "Retrieve the file at that URL and add it to the current working directory.\n"
      + "Example1:\n"
      + "curl http://www.cs.cmu.edu/ spok/grimmtmp/073.txt\n"
      + "Will get the contents of the file, i.e. 073.txt and create a file called 073.txt \n"
      + "with the contents in the current working directory.\n"
      + "Example2:\n"
      + "curl http://www.ub.edu/gilcub/SIMPLE/simple.html\n"
      + "Will get the contents of the file, i.e. simple.html (raw HTML) and create a file \n"
      + "called simple.html with the contents in the current working directory.";
  static String sjMan = "saveJShell FileName\n\n[DESCRIPTION]\n"
      + "The above command will interact with your real file system on your computer.\n"
      + " When the above command is typed, you must ensure that the entire state of the \n"
      + "program is written to the file FileName. The file FileName is some file that is \n"
      + "stored on the actual filesystem of your computer. The purpose of this command is \n"
      + "to save the session of the JShell before the user closes it down.";
  static String ljMan = "loadJShell FileName\n\n[DESCRIPTION]\n"
      + "When the user types in the above command, your JShell must load the contents of \n"
      + "the FileName and reinitialize everything that was saved previously into the FileName.\n"
      + "This allows the user to start a new JShell session, type in load FileName and resume\n"
      + "activity from where they left off previously.";
  static String searchMan = "search path ... -type [f|d] -name expression\n\n[DESCRIPTION]\n"
      + "• search /users/Desktop -type f -name \"xyz\". \n"
      + "This command will search the directory Desktop and search \n"
      + "all files (indicated by type f) that have the name exactly xyz.\n"
      + "• search /users/Desktop -type d -name \"abc\". \n"
      + "This command will search the directory Desktop and search \n"
      + "all directories (indicated by type d) that have the name exactly abc.\n"
      + "• search /users/Desktop. \n"
      + "This command will result in an error because it has missing arguments. \n"
      + "• search /users/Desktop /users/Desktop1 -type d -name \"abc\". \n"
      + "This command will search the directory Desktop and Desktop1 and search \n"
      + "all directories (indicated by type d) that have the name exactly abc.\n"
      + "• search /users/Desktop /users/Desktop1 -type f -name \"abc\". \n"
      + "This command will search the directory Desktop and Desktop1 and search all \n"
      + "directories (indicated by type f) that have the name exactly abc.";
  static String treeMan = "tree\n\n[DESCRIPTION]\n"
      + "The the tree command takes in no input parameter. It prints out the file structure"
      + "in a tree structure\n";

  /**
   * This method prints the manual for the command which is given by parameters
   * @param parameters is the command user input
   */
  public static void man(FileManager fileSys, String parameters) {
    
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
    
    for (String cmdName : parameters.split(" ")) {
      String temp = "----------------------------------\n[NAME]\n" + cmdName + "\n\n[SYNOPSIS]\n";
      switch (cmdName) {
        case EXIT_COMMAND: output = temp + exitMan + "\n"; break;
        case MKDIR_COMMAND: output = temp + mkdirMan + "\n"; break;
        case CD_COMMAND: output = temp + cdMan + "\n"; break;
        case LS_COMMAND: output = temp + lsMan + "\n"; break;
        case PWD_COMMAND: output = temp + pwdMan + "\n"; break;
        case PUSH_COMMAND: output = temp + pushdMan + "\n"; break;
        case POP_COMMAND: output = temp + popdMan + "\n"; break;
        case HIS_COMMAND: output = temp + hisMan + "\n"; break;
        case CAT_COMMAND: output = temp + catMan + "\n"; break;
        case ECHO_COMMAND: output = temp + echoMan + "\n"; break;
        case MAN_COMMAND: output = temp + manMan + "\n"; break;
        case MV_COMMAND: output = temp + mvMan + "\n"; break;
        case RM_COMMAND: output = temp + rmMan + "\n"; break;
        case CP_COMMAND: output = temp + cpMan + "\n"; break;
        case CURL_COMMAND: output = temp + curlMan + "\n"; break;
        case TREE_COMMAND: output = temp + treeMan + "\n"; break;
        case SEARCH_COMMAND: output = temp + searchMan + "\n"; break;
        case LJ_COMMAND: output = temp + ljMan + "\n"; break;
        case SJ_COMMAND: output = temp + sjMan + "\n"; break;
        default: output = output + "man: unknown command '"+cmdName+"'\n"; return;
      }
    }
    output = output + "----------------------------------\n";
    if (redirect) 
      OutputCommands.directToFile(fileSys, output, targetFile, pArray[pArray.length - 2]);
    else OutputCommands.print(output);
  }
}

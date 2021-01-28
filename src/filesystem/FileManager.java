package filesystem;

import commands.OutputCommands;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the class for the mock file system. The methods do operations on the
 * file system. Most of the method in this class is used as helper method
 * in classes of Commands.
 * And the values stored in the objects is the basic feature of a file system
 */
public class FileManager {
  /**
   * This is the root Directory
   */
  private FileSystemNode root = new FileSystemNode("/", null, true);

  /**
   * This is the current working directory
   */
  private FileSystemNode currDir;

  /**
   * This is the list of FileSystemNode storing all the files
   */
  private LinkedList<FileSystemNode> fileList = new LinkedList<>();

  /**
   * This is the List of FileSystemNode storing all the directory
   */
  private LinkedList<FileSystemNode> directoryStack = new LinkedList<>();

  /**
   *This is the List of String Storing all the Commandline
   */
  private List<String> CommandList = new ArrayList<>();
  /**
   * The constructor
   */
  public FileManager() {
    fileList.add(root);
    currDir = root;
  }
  /**
   * This method gets the root directory of the fileSys
   * @return root
   */
  public FileSystemNode getRoot() {
    return root;
    //get the root of the FileSystemNode
  }

  /**
   * This method gets the current working directory of the fileSys
   * @return currDir
   */
  public FileSystemNode getCurrentDir() {
    return currDir;
    //get the current working directory
  }


  /**
   * This method will get the child directory of currDir
   * @param currDir
   * @return
   */
  public ArrayList<FileSystemNode> getChildren(FileSystemNode currDir){
    ArrayList<FileSystemNode> list = new ArrayList<>();
    for (FileSystemNode dir : this.fileList) {
      if (dir.getParentDir() != null && dir.getParentDir().getPath().equals(currDir.getPath())) {
        list.add(dir);
      }
    }

    return list;
  }

  /**
   * This method will update the CurrDir of fileSys to dir
   * @param dir
   */
  public void updateCurrentDir(FileSystemNode dir) {
    currDir = dir;
    //update current directory
  }

  /**
   * This method will create either a file or a Directory in the parentDir
   * @param parentDir
   * @param name
   * @param isDir
   * @return
   */
  public FileSystemNode createNode(FileSystemNode parentDir, String name, Boolean isDir) {
    FileSystemNode newFile = new FileSystemNode(name, parentDir, isDir);
    this.fileList.add(newFile);
    return newFile;
    //create a new file then return to it
  }

  /**
   * This method remove a file from the System
   * @param tar
   */
  public void removeNode(FileSystemNode tar) {
    this.fileList.remove(tar);
  }


  /**
   * This method find if a path exists in the System
   * @param path
   * @return
   */
  public FileSystemNode findNode(String path) {

    //path may be relative or full path

    if (!path.startsWith("/")) {
      if (this.getCurrentDir() == root) {
        path = this.getCurrentDir().getPath() + path;
      } else {
        path = this.getCurrentDir().getPath() + "/" + path;
      }
    }

    if (!path.equals("/") && path.endsWith("/")) {

      path = path.substring(0, path.length()-1);
    }

    for (FileSystemNode dir : this.fileList) {
      if (dir.getPath().equals(path)) {
        return dir;
        //find the target directory
      }
    }
    return null;
  }

  // Determining if a given string is Path

  /**
   * This method find if a path is valid
   * @param path
   * @return
   */
  public boolean isPath(String path) {
    if ((this.findNode(path) == null) && (this.findNode(path) == null)) {
      return false;
      //test whether it is a valid path
    }
    return true;
  }

  /**
   * This method move the tar Node to the destDir
   * @param tar
   * @param destDir
   */
  public void moveNode(FileSystemNode tar, FileSystemNode destDir) {
    tar.setParentDir(destDir);
  }

  // Push the current Directory into Directory Stack

  /**
   * This method push the directory in to the stack
   * @param currDir
   */
  public void pushDir(FileSystemNode currDir){
    this.directoryStack.add(currDir);
    //call the push directory methods
  }

  //Get the first Directory in the Directory Stack

  /**
   * This is a helper method for popDir
   * @return
   */
  public FileSystemNode getStackItem(){
    return this.directoryStack.getFirst();
  }

  // Remove the Last item in the Directory Stack and cd into it

  /**
   * This method get the item at the top of the stack
   */
  public void popDir(){

    if(directoryStack.size() == 0){
      System.out.println("No Dir in the stack");
      //print out "no directory in the stack"when the size of directoryStack equal to 0;
    }
    else{
      this.updateCurrentDir(directoryStack.getLast());
      this.directoryStack.removeLast();
    }
  }

  /**
   * This method add the CommandLine to the List of Commands
   * @param CommandLine
   */
  public void addCommand(String CommandLine){
    this.CommandList.add(CommandLine);
    //add Commandlines to te cmmand list
  }

  /**
   * This method prints all the Commands in the History Stack
   */
  public String printAllCommand(){
    String output = "";
    for(String CommandLine:this.CommandList){
      output = output + CommandLine + "\n";
      //print all the history commands
    }
    return output;
  }

  public void getAllCommand(ArrayList<String> list){
    for(String CommandLine: this.CommandList){
      list.add(CommandLine);
    }
  }

  /**
   * This method prints hisnum Commands in the Command Stack
   * @param hisNum
   */
  public String printNumCommand(int hisNum){
    String output = "";
    if(hisNum > this.CommandList.size()){
      output = output + printAllCommand();
    }
    else{
      List<String> sub = new ArrayList<>();
      int size = this.CommandList.size();
      sub = this.CommandList.subList(size-hisNum,size);
      for(String CommandLine:sub) output = output + CommandLine + "\n";
    }
    return output;
  }
  public LinkedList<FileSystemNode> getFileList() {
    return fileList;
  }
  public void loadFileList(LinkedList<FileSystemNode> lst) {
    fileList = lst;
  }


 }



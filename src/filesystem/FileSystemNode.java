package filesystem;

import java.io.Serializable;

/**
 * This is the class of FileSystemNode, which is the contents of the mock
 * file system, i.e. the object of this class
 * is regard as either file or directory in the
 * real file System. And the methods in this class are used for modifying the
 * feature of a file or a directory
 */
public class FileSystemNode implements Serializable {


  /**
   * This stores the name of the file/directory
   */
  public String getName;

  /**
   * This stores the parent directory of the file/directory
   */
   public FileSystemNode parentDir = null;    // the parent directory of the file/directory

  /**
   * If the node represent a directory, the value would be true
   */
  public Boolean isDir;

  /**
   * This value store the content of a file
   */
  public String content = "";

  /**
   * This method set the content of a file
   * @param str
   */
  public void setContent(String str) {
    this.content = str;
    //set the content with the string parameters
  }


  /**
   * This method gets the content of a file
   * @return
   */
  public String getContent() {
    return this.content;
    //set the content with the string parameters
  }

  /**
   * This is the constructor
   * @param name
   * @param currDir
   * @param isDir
   */
  public FileSystemNode(String name, FileSystemNode currDir, Boolean isDir){
    this.getName =name;
    this.parentDir=currDir;
    this.isDir = isDir;
  }

  /**
   * This method gets the name of a file
   * @return
   */
  public String getGetName() {
    return this.getName;
    //get name
  }

  /**
   * This method sets the name of a file
   * @param getName
   */
  public void setGetName(String getName) {
    this.getName = getName;
  }


  /**
   * This method gets the parentDir of a file and return to it
   * @return
   */
  public FileSystemNode getParentDir() {
    return parentDir;
    //get the parent directory
  }

  /**
   * This method gets the type of the Node
   * @return true if the node is a directory
   */
  public Boolean getType(){
    return this.isDir;
  }
  /**
   * This method sets the parentDir of a file
   * @param parentDir
   */
  public void setParentDir(FileSystemNode parentDir) {
    this.parentDir = parentDir;
    //set parent directory
  }

  /**
   * This method get the path of the file
   * @return
   */
  public String getPath() {
    // if it is root then return "/"
    if (this.parentDir == null) return "/";
    // if it is under root then return /name
    if (this.parentDir.getGetName().equals("/")) return "/" + this.getGetName();
    // else
    return this.parentDir.getPath() + "/" + this.getName;
  }

  /**
   * This method add content to a file
   * @param content
   */
  public void addContent(String content){this.content = this.content+content;}

  /**
   * This method returns the name of a file
   * @return
   */
  public String toString() {
    return getName;
  }


}
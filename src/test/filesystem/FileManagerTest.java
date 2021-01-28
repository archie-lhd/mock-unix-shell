package test.filesystem;

import static org.junit.Assert.*;

import commands.OutputCommands;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
import org.junit.Test;

public class FileManagerTest {
  FileManager sampleFM = new FileManager();;

  @Test
  public void getRoot() {
    FileSystemNode root = sampleFM.getRoot();
    FileSystemNode exp = sampleFM.getCurrentDir();
    assertEquals(exp, root);
  }

  @Test
  public void getCurrentDir() {
    FileSystemNode exp = sampleFM.getRoot();
    FileSystemNode currDir = sampleFM.getCurrentDir();
    assertEquals(exp, currDir);
  }

  @Test
  public void updateCurrentDir() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir", true);
    sampleFM.updateCurrentDir(newDir);
    FileSystemNode exp = sampleFM.getCurrentDir();
    assertEquals(exp, newDir);
  }

  @Test
  public void createNode() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir", true);
    String exp = sampleFM.getChildren(sampleFM.getRoot()).get(0).toString();
    assertEquals(exp, newDir.getGetName());
  }

  @Test
  public void getChildren() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir", true);
    FileSystemNode newFile = sampleFM.createNode(sampleFM.getRoot(), "sampleFile", false);
    ArrayList<FileSystemNode> exp = new ArrayList<>();
    ArrayList<FileSystemNode> res = sampleFM.getChildren(sampleFM.getRoot());

    exp.add(newDir);
    exp.add(newFile);
    boolean same = true;
    for (FileSystemNode node : res) {
      if(exp.contains(node) == false) same = false;
    }
    for (FileSystemNode node : exp) {
      if(res.contains(node) == false) same = false;
    }

    assertEquals(same, true);
  }

  @Test
  public void findFileTestCase1() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1", true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2", true);
    FileSystemNode exp = sampleFM.createNode(sampleDir2, "sampleFile",false);
    FileSystemNode tar = sampleFM.findNode("/sampleDir1/sampleDir2/sampleFile"); // full path
    assertEquals(exp, tar);
  }

  @Test
  public void findFileTestCase2() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    FileSystemNode exp = sampleFM.createNode(sampleDir2, "sampleFile",false);
    sampleFM.updateCurrentDir(sampleDir1);
    FileSystemNode tar = sampleFM.findNode("sampleDir2/sampleFile"); // relative path
    assertEquals(exp, tar);
  }

  @Test
  public void findDirTestCase1() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    FileSystemNode exp = sampleFM.createNode(sampleDir2, "sampleDir3",true);
    FileSystemNode tar = sampleFM.findNode("/sampleDir1/sampleDir2/sampleDir3"); // full path
    assertEquals(exp, tar);
  }

  @Test
  public void findDirTestCase2() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    FileSystemNode exp = sampleFM.createNode(sampleDir2, "sampleDir3",true);
    sampleFM.updateCurrentDir(sampleDir1);
    FileSystemNode tar = sampleFM.findNode("sampleDir2/sampleDir3"); // relative path
    assertEquals(exp, tar);
  }
  @Test
  public void isPathTestCase1() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    String path = "/sampleDir1/sampleDir2";
    boolean exp = true;
    assertEquals(exp, sampleFM.isPath(path));
  }

  @Test
  public void isPathTestCase2() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    String path = "notExistingDir";
    boolean exp = false;
    assertEquals(exp, sampleFM.isPath(path));
  }

  @Test
  public void pushDirTestCase() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir",true);
    sampleFM.updateCurrentDir(newDir);
    sampleFM.pushDir(sampleFM.getCurrentDir());
    assertEquals(sampleFM.getCurrentDir(),sampleFM.getStackItem());
  }


  @Test
  public void popDirTestCase1() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir", true);
    FileSystemNode newDir2 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir2", true);
    sampleFM.updateCurrentDir(newDir);
    sampleFM.pushDir(sampleFM.getCurrentDir());
    sampleFM.updateCurrentDir(newDir2);
    sampleFM.pushDir(sampleFM.getCurrentDir());
    sampleFM.popDir();
    assertEquals(newDir,sampleFM.getStackItem());
  }
  @Test
  public void popDirTestCase2() {
    sampleFM.popDir();
    System.out.println("No Dir in the stack");
  }

  @Test
  public void getstackitemTest() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir", true);
    sampleFM.updateCurrentDir(newDir);
    sampleFM.pushDir(sampleFM.getCurrentDir());
    assertEquals(sampleFM.getCurrentDir(),sampleFM.getStackItem());
  }

  @Test
  public void addCommand(){
    sampleFM.addCommand("123");
    OutputCommands.println("Successfully added");
  }

  @Test
  public void printAllCommand(){
    sampleFM.addCommand("123");
    sampleFM.printAllCommand();
  }

  @Test
  public void printNumCommand(){
    sampleFM.addCommand("123");
    sampleFM.printNumCommand(2);
  }
}
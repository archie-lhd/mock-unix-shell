package test.commands;

import static org.junit.Assert.*;

import filesystem.FileManager;
import filesystem.FileSystemNode;
import org.junit.Test;

public class PopDirectoryTest {
  FileManager sampleFM = new FileManager();
  @Test
  public void testPopdCase1() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir",true);
    FileSystemNode newDir2 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir2",true);
    sampleFM.updateCurrentDir(newDir);
    sampleFM.pushDir(sampleFM.getCurrentDir());
    sampleFM.updateCurrentDir(newDir2);
    sampleFM.pushDir(sampleFM.getCurrentDir());
    sampleFM.popDir();
    assertEquals(newDir,sampleFM.getStackItem());
    //test whether sampleDir is been crroectly poped or not
  }
  @Test
  public void testPopdCase2() {
    sampleFM.popDir();
    System.out.println("No Dir in the stack");
  }
}
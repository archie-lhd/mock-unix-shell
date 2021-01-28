package test.commands;

import static org.junit.Assert.*;

import commands.ChangeDirectory;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import org.junit.Test;

public class ChangeDirectoryTest {
  FileManager sampleFM = new FileManager();
  @Test
  public void testCdCase1() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    ChangeDirectory.cd(sampleFM, "/sampleDir1/sampleDir2");
    FileSystemNode exp = sampleDir2;
    assertEquals(exp, sampleFM.getCurrentDir());
    //test whether the shell able to change sampleDir2 from sampleDir1
  }
  @Test
  public void testCdCase2() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    ChangeDirectory.cd(sampleFM, "sampleDir1");
    ChangeDirectory.cd(sampleFM, "sampleDir2");
    FileSystemNode exp = sampleDir2;
    assertEquals(exp, sampleFM.getCurrentDir());
    //test first change to sampleDir1 then change to sampleDir2
  }
}
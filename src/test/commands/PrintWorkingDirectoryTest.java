package test.commands;

import static org.junit.Assert.*;

import commands.ChangeDirectory;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import org.junit.Test;

public class PrintWorkingDirectoryTest {
  FileManager sampleFM = new FileManager();
  @Test
  public void testPwd() {
    FileSystemNode sampleDir1 = sampleFM.createNode(sampleFM.getRoot(), "sampleDir1",true);
    FileSystemNode sampleDir2 = sampleFM.createNode(sampleDir1, "sampleDir2",true);
    ChangeDirectory.cd(sampleFM, "/sampleDir1/sampleDir2");
    FileSystemNode exp = sampleDir2;
    assertEquals(exp, sampleFM.getCurrentDir());
    //test whether the current working directory is been printed correctly
  }
}
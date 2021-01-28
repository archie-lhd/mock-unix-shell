package test.commands;

import static org.junit.Assert.*;

import commands.PushDirectory;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.nio.file.FileSystem;
import org.junit.Test;

public class PushDirectoryTest {
  FileManager sampleFM = new FileManager();
  @Test
  public void testPushDirCase1() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir",true);
    FileSystemNode Directory_before = sampleFM.getCurrentDir();
    PushDirectory.PushDir(sampleFM,"sampleDir2");
    assertEquals(sampleFM.getCurrentDir(),Directory_before);
    //test whether current directory is equal to the directory before
  }
  @Test
  public void testPushDirCase2() {
    FileSystemNode newDir = sampleFM.createNode(sampleFM.getRoot(), "sampleDir",true);
    sampleFM.createNode(sampleFM.getCurrentDir(),"sampleDir2",true);
    PushDirectory.PushDir(sampleFM,"sampleDir2");
    assertEquals(sampleFM.getCurrentDir().getName,"sampleDir2");
  }
}
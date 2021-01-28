package test.filesystem;

import static org.junit.Assert.*;

import filesystem.FileSystemNode;
import org.junit.Test;

public class FileSystemNodeTest {

  FileSystemNode sampleFN;
  FileSystemNode sampleFN2;

  @Test
  public void getName() {
    sampleFN = new FileSystemNode("Samplename",sampleFN.parentDir, true);
    assertEquals("Samplename",sampleFN.getName);
  }

  @Test
  public void setName() {
    sampleFN = new FileSystemNode("Samplename",sampleFN.parentDir, true);
    sampleFN.setGetName("name");
    assertEquals("name",sampleFN.getName);
  }

  @Test
  public void getParentDir() {
    sampleFN = new FileSystemNode("Samplename",sampleFN.parentDir, true);
    assertEquals(null,sampleFN.parentDir);
  }

  @Test
  public void setParentDir() {
    sampleFN = new FileSystemNode("Samplename",sampleFN.parentDir, true);
    sampleFN2 = new FileSystemNode("Samplename",sampleFN2.parentDir, true);
    sampleFN.setParentDir(sampleFN);
    assertEquals(null,sampleFN2.parentDir);
  }

  @Test
  public void getPath() {
    sampleFN = new FileSystemNode("Samplename",sampleFN.parentDir, true);
    assertEquals("Samplename",sampleFN.getPath());
  }
}
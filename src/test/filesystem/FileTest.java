package test.filesystem;

import static org.junit.Assert.assertEquals;

import filesystem.FileSystemNode;
import org.junit.Test;

public class FileTest {
  FileSystemNode sampleFile;
  FileSystemNode sampleDir;

  @Test
  public void setContentTestCase1() {
    sampleFile = new FileSystemNode("sampleName", null, false);
    sampleFile.setContent("test content");
    String exp = "test content";
    assertEquals(exp, sampleFile.content);
  }

  @Test
  public void setContentTestCase2() {
    sampleFile = new FileSystemNode("sampleName", sampleDir, false); // created under sampleDir
    sampleFile.setContent("test content");
    sampleFile.setContent("This the updated content");
    String exp = "This the updated content";
    assertEquals(exp, sampleFile.content);
  }


  @Test
  public void getContentTestCase1() {
    sampleFile = new FileSystemNode("sampleName", null, false);
    sampleFile.setContent("test content");
    String exp = "test content";
    assertEquals(exp, sampleFile.getContent());
  }
}
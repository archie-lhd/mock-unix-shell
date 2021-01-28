package test.commands;

import static junit.framework.Assert.assertEquals;

import commands.EchoCommands;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import org.junit.Test;

public class EchoCommandsTest {
  FileManager fileSys = new FileManager();
  @Test
  public void testEchoCase1() {
    FileSystemNode sampleFile = fileSys.createNode(fileSys.getRoot(), "sampleFile", false);
    sampleFile.setContent("original content");
    EchoCommands.echo(fileSys, "\"sample content\" > sampleFile");
    String exp = "sample content";
    assertEquals(exp, sampleFile.getContent());
  }
  @Test
  public void testEchoCase2() {
    FileSystemNode sampleFile = fileSys.createNode(fileSys.getRoot(), "sampleFile", false);
    sampleFile.setContent("original content");
    EchoCommands.echo(fileSys, "\"sample content\" >> sampleFile");
    String exp = "original contentsample content";
    assertEquals(exp, sampleFile.getContent());
    //test whether sample file after echo commands process is equal to original contentsample 
    //content
  }
}
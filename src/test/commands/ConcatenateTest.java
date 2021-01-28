package test.commands;

import commands.Concatenate;
import commands.OutputCommands;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import org.junit.Test;

public class ConcatenateTest {
  FileManager fileSys = new FileManager();
  @Test
  public void testCatCase1() {
    FileSystemNode newFile = fileSys.createNode(fileSys.getRoot(), "newFile",false);
    newFile.setContent("This is the content of newFile");
    OutputCommands.println("result:");
    Concatenate.cat(fileSys, "/newFile");   // full path
    OutputCommands.println("exp:\nThis is the content of newFile");

  }
  public void testCatCase2() {
    FileSystemNode newFile1 = fileSys.createNode(fileSys.getRoot(), "newFile1",false);
    newFile1.setContent("This is the content of newFile1");
    FileSystemNode newFile2 = fileSys.createNode(fileSys.getRoot(), "newFile2",false);
    newFile2.setContent("This is the content of newFile2");

    OutputCommands.println("result:");
    Concatenate.cat(fileSys, "/newFile1 /newFile2");   // full path
    OutputCommands.println("exp:\nThis is the content of newFile1\n\n\nThis is the content of newFile2");
    //test showing several files' content
  }
}
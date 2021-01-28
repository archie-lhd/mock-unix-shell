package test.commands;

import static org.junit.Assert.*;

import commands.MakeDirectory;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
import org.junit.Test;

public class MakeDirectoryTest {
  FileManager fileSys = new FileManager();

  @Test
  public void testMkdir() {
    MakeDirectory.mkdir(fileSys, "newDir1 newDir2");
    ArrayList<FileSystemNode> list = fileSys.getChildren(fileSys.getRoot());
    ArrayList<String> exp = new ArrayList<>();
    exp.add("newDir1");
    exp.add("newDir2");
    ArrayList<String> act = new ArrayList<>();
    for( FileSystemNode dir : list){
      act.add(dir.getGetName());
    }
    assertEquals(exp, act);
    //test whether the directory is been correctly created
  }


}
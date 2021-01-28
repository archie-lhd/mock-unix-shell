package test.commands2B;

import static org.junit.Assert.*;

import commands.MakeDirectory;
import commands2B.CopyItem;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
import org.junit.Test;

public class CopyItemTest {
  FileManager sampleFM = new FileManager();
  @Test
  public void cp() {
    MakeDirectory.mkdir(sampleFM,"folder_1");
    MakeDirectory.mkdir(sampleFM,"folder_2");
    MakeDirectory.mkdir(sampleFM,"/folder_1/folder_3");
    CopyItem.cp(sampleFM,"folder_1 folder_2");
    ArrayList<String> exp = new ArrayList<>();
    exp.add("folder_1");
    ArrayList<String> act = new ArrayList<>();
    ArrayList<FileSystemNode> list =
        sampleFM.getChildren(sampleFM.findNode("folder_2"));
    for( FileSystemNode dir : list){
      act.add(dir.getGetName());
    }
    assertEquals(exp, act);
  }
}
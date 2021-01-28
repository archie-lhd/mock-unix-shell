package test.commands2B;

import static org.junit.Assert.*;

import commands.MakeDirectory;
import commands2B.MoveItem;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.util.ArrayList;
import org.junit.Test;

public class MoveItemTest {
  FileManager sampleFM = new FileManager();

  @Test
  public void mv() {
    MakeDirectory.mkdir(sampleFM,"folder_1");
    MakeDirectory.mkdir(sampleFM,"folder_2");
    MakeDirectory.mkdir(sampleFM,"/folder_1/folder_3");
    //make directory of folders
    MoveItem.mv(sampleFM,"folder_1 folder_2");
    ArrayList<String> exp = new ArrayList<>();
    //create a new array list
    exp.add("folder_1");
    ArrayList<String> act = new ArrayList<>();
    ArrayList<FileSystemNode> list =
        sampleFM.getChildren(sampleFM.findNode("folder_2"));
    for( FileSystemNode dir : list){
      act.add(dir.getGetName());
    }
    assertEquals(exp, act);
  }

  @Test
  public void pathCutter() {
    String str = "1/2/3";
    assertEquals("/1/2",MoveItem.pathCutter(str));
  }
}
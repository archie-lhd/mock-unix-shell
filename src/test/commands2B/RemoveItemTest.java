package test.commands2B;

import static org.junit.Assert.*;

import commands.MakeDirectory;
import commands2B.RemoveItem;
import filesystem.FileManager;
import org.junit.Test;

public class RemoveItemTest {

  FileManager sampleFM = new FileManager();
  @Test
  public void rmCase1() {
    MakeDirectory.mkdir(sampleFM,"1 2");
    RemoveItem.rm(sampleFM,"1");
    assertEquals(null,sampleFM.findNode("1"));
  }
  @Test
  public void rmCase2() {
    MakeDirectory.mkdir(sampleFM,"1 2");
    MakeDirectory.mkdir(sampleFM,"/1/3 2");
    RemoveItem.rm(sampleFM,"1");
    assertEquals(null,sampleFM.findNode("3"));
  }
}
package test.commands2B;

import static org.junit.Assert.*;

import commands.MakeDirectory;
import commands2B.Search;
import filesystem.FileManager;
import java.util.ArrayList;
import org.junit.Test;

public class SearchTest {
  FileManager sampleFM = new FileManager();
  @Test
  public void search() {
    MakeDirectory.mkdir(sampleFM,"1 2");
    Search.search(sampleFM,"1");
  }

  @Test
  public void checkType() {
    String str = "d";
    assertEquals(Search.checkType(str),"directory");
  }
  @Test
  public void checkType2() {
    String str = "f";
    assertEquals(Search.checkType(str),"file");
  }

  @Test
  public void searchInList() {
    MakeDirectory.mkdir(sampleFM,"1 2");
    Search.search(sampleFM,"1");
  }

  @Test
  public void findNodeIn() {
    MakeDirectory.mkdir(sampleFM,"1 2");
    Search.search(sampleFM,"");
  }
}
package test.commands2B;

import static org.junit.Assert.*;

import commands2B.GetOnlineFile;
import filesystem.FileManager;
import org.junit.Test;

public class GetOnlineFileTest {

  FileManager sampleFM = new FileManager();

  @Test
  public void curl() {
    GetOnlineFile.curl(sampleFM,
        "http://www.cs.cmu.edu/~spok/grimmtmp/073.txt");
    // choose a website 
    assertEquals("073txt",sampleFM.findNode("073txt").getName);
  }
}
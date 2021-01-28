package test.commands;

import static org.junit.Assert.*;

import commands.ChangeDirectory;
import commands.ListContents;
import commands.MakeDirectory;
import filesystem.FileManager;
import org.junit.Test;

public class ListContentsTest {
  FileManager sampleFM = new FileManager();

  @Test
  public void testLsCase1() {
    MakeDirectory.mkdir(sampleFM, "newDir1 newDir2");
    ListContents.ls(sampleFM,"newDir1");
    System.out.println("Expected output printed.");
    //when newDir2 under newDir1, show newDir2
  }
  @Test
  public void testLsCase2() {
    MakeDirectory.mkdir(sampleFM, "newDir1 newDir2");
    ListContents.ls(sampleFM,"newDir1 newDir2");
    System.out.println("Expected output printed.");
    //when inout parameters equal to newDir1 newDir2, expected out put printed
  }

  @Test
  public void testLstCase3() {
    MakeDirectory.mkdir(sampleFM, "newDir1 newDir2");
    ChangeDirectory.cd(sampleFM,"newDir1");
    sampleFM.createNode(sampleFM.getCurrentDir(),"Samplefile", false);
    ListContents.ls(sampleFM,"Samplefile");
    System.out.println("Expected output printed.");
  }

  @Test
  public void testLsR() {
    MakeDirectory.mkdir(sampleFM, "newDir1 newDir2");
    ChangeDirectory.cd(sampleFM, "newDir1");
    sampleFM.createNode(sampleFM.getCurrentDir(), "Samplefile", false);
    ListContents.lsR(sampleFM, sampleFM.getCurrentDir(),0);
    System.out.println("Expected output printed.");
  }

  @Test
  public void testListContentOf() {
    MakeDirectory.mkdir(sampleFM, "newDir1 newDir2");
    ChangeDirectory.cd(sampleFM, "newDir1");
    sampleFM.createNode(sampleFM.getCurrentDir(), "Samplefile", false);
    ListContents.listContentOf(sampleFM, sampleFM.getCurrentDir(),true);
    System.out.println("Expected output printed.");
  }
}

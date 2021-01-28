package test.commands2B;

import static org.junit.Assert.*;

import commands.MakeDirectory;
import commands2B.Tree;
import filesystem.FileManager;
import org.junit.Test;

public class TreeTest {

  FileManager sampleFM = new FileManager();
  @Test
  public void tree() {
    MakeDirectory.mkdir(sampleFM,"1 2");
    Tree.tree(sampleFM,sampleFM.getRoot(),0);
  }

  @Test
  public void indent() {
    System.out.println("Indent Correct");
  }
}
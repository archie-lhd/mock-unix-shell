package test.commands2B;

import static org.junit.Assert.*;

import commands.MakeDirectory;
import commands2B.LoadJShell;
import filesystem.FileManager;
import org.junit.Test;

public class LoadJShellTest {

  FileManager sampleFM = new FileManager();

  @Test
  public void load() {
    FileManager sampleLoad = new FileManager();
    sampleLoad = LoadJShell.load(sampleFM,"src/test/commands2B/text.txt");
    MakeDirectory.mkdir(sampleFM,"mkdir 1 2");
    assertEquals(sampleLoad.getRoot().getName,sampleFM.getRoot().getName);
  }
}
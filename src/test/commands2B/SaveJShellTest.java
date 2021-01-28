package test.commands2B;

import static org.junit.Assert.*;

import commands2B.SaveJShell;
import filesystem.FileManager;
import org.junit.Test;

public class SaveJShellTest {
  FileManager sampleFM = new FileManager();

  @Test
  public void save() {
    SaveJShell.save(sampleFM,"src/test/commands2B/2.txt");
    System.out.println("Shell Saved");
  }
}
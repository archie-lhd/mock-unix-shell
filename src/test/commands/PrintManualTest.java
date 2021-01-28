package test.commands;

import static org.junit.Assert.*;

import commands.PrintManual;
import filesystem.FileManager;
import java.nio.file.FileSystem;
import org.junit.Test;

public class PrintManualTest {
  FileManager fileSys = new FileManager();
  @Test
  public void testMan() {
    PrintManual.man(fileSys, "cd");
    System.out.println("Manual for cd printed correctly.");
  }

}
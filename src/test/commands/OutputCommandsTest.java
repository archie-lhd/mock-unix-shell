package test.commands;

import commands.OutputCommands;
import org.junit.Test;

public class OutputCommandsTest {

  @Test
  public void testPrint() {
    String str = "This is the sample Message";
    OutputCommands.println(str);
    System.out.println("Sample Message printed.");
  }
}
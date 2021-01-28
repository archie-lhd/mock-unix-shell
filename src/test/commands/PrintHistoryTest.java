package test.commands;

import commands.PrintHistory;
import filesystem.FileManager;
import org.junit.Test;

public class PrintHistoryTest {
  FileManager sampleFM = new FileManager();
  @Test
  public void printHistoryCase1(){
    sampleFM.addCommand("Command1");
    sampleFM.addCommand("Command2");
    sampleFM.addCommand("Command3");
    PrintHistory.printHistory(sampleFM,"");
  }
  @Test
  public void printHistoryCase2(){
    sampleFM.addCommand("Command1");
    sampleFM.addCommand("Command2");
    sampleFM.addCommand("Command3");
    PrintHistory.printHistory(sampleFM,"2");
  }
  @Test
  public void printHistoryCase3(){
    sampleFM.addCommand("Command1");
    sampleFM.addCommand("Command2");
    sampleFM.addCommand("Command3");
    PrintHistory.printHistory(sampleFM,"5");
  }
}
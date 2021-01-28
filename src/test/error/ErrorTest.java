package test.error;

import static org.junit.Assert.*;

import error.Error;
import org.junit.Test;
import filesystem.FileManager;
public class ErrorTest {
  FileManager sampleFM = new FileManager();
  
  @Test
  public void testParaNumEqual() {
    String parameters = "123 234";
    assertEquals(Error.paraNumEqual(parameters,2),true);
  }
  @Test
  public void testParaNumExceedMax() {
    String parameters = "123 234";
    assertEquals(Error.paraNumNotExceedMax(parameters,1),false);
  }

  @Test
  public void testCheckDirPath() {
    sampleFM = new FileManager();
    assertEquals(Error.checkDirPath(sampleFM,"Dir"),false);
  }

  @Test
  public void testDirPathExist() {
    sampleFM = new FileManager();
    assertEquals(Error.dirPathExist(sampleFM,"Dir"),false);
  }

  @Test
  public void testCheckFilePath() {
    sampleFM = new FileManager();
    assertEquals(Error.checkFilePath(sampleFM,"file"),false);
  }

  @Test
  public void testCheckPath() {
    sampleFM = new FileManager();
    assertEquals(Error.checkPath(sampleFM,"path"),false);
  }

  @Test
  public void testvalidName() {
    String name = "$%^%^^&";
    assertEquals(Error.validName(name),false);
  }

  @Test
  public void validParentPath() {
    sampleFM = new FileManager();
    assertEquals(Error.validParentPath(sampleFM,"parent path"),true);
  }

  @Test
  public void validString() {
    System.out.println("Not a valid String");
  }

  @Test
  public void invalidCommand() {
    System.out.println("Not a valid Command");
  }

  @Test
  public void isNumber() {
    assertEquals(Error.isNumber("erw"),false);
  }

  @Test
  public void isValidRedirectSign() {
    assertEquals(true,Error.isValidRedirectSign(">"));
  }
}
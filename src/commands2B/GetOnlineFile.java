package commands2B;

import commands.ShellCommands;
import filesystem.FileManager;
import filesystem.FileSystemNode;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is designed for get expected contents online
 */
public class GetOnlineFile extends ShellCommands {

  /**
   * This file get contents of the file online given by the URL parameters, and
   * make a local file with same name and same cotent at the currDir
   * @param fileSys is the mock system
   * @param parameters is the URL
   */
  public static void curl(FileManager fileSys, String parameters){
    String[] name = parameters.split("/");
    String fileName = name[name.length-1];
    fileName = fileName.replaceAll("[^\\w\\s]","");
    try {
      StringBuffer html = new StringBuffer();
      URL url = new URL(parameters);
      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      InputStreamReader isr = new InputStreamReader(conn.getInputStream());
      BufferedReader br = new BufferedReader(isr);
      FileSystemNode newFile = fileSys.createNode(fileSys.getCurrentDir(),fileName,false);
      newFile.setContent("");
      String temp;
      while ((temp = br.readLine()) != null) {
        newFile.addContent(temp+"\n");
      }
      br.close();
      isr.close();
    } catch (Exception e) {
      System.out.println("The link is not accessible");
      return;
    }

  }
}


package com.example.autobot.utils;

import java.io.*;

/**
 * @author akshay on 12/01/19
 */
public class FileReader {

    public static String readFile(String fileName) throws IOException  {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        File file=new File(classLoader.getResource(fileName).getFile()).getAbsoluteFile();
        StringBuilder lines = new StringBuilder();
        try(BufferedReader br=new BufferedReader(new java.io.FileReader(file))) {
            String currentLine = br.readLine();
            while (null != currentLine) {
                lines.append(currentLine);
                lines.append("\n");
                currentLine = br.readLine();
            }
        }
        return lines.toString();
    }

    public static void main(String[] args) throws IOException {
      String s= FileReader.readFile("input");
      System.out.println(s);
    }
}

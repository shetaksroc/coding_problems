package com.example.autobot.utils;

import org.apache.commons.lang.Validate;

import java.io.*;

/**
 * @author akshay on 12/01/19
 */
public class FileReader {

    public static String readFile(String fileName) throws IOException  {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        Validate.notNull(fileName,"File name cannot be null");
        Validate.notNull(classLoader.getResource(fileName),"File not found");
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
}

package com.example.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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

    public static List<String> readFileAsList(String fileName) throws IOException  {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        File file=new File(classLoader.getResource(fileName).getFile()).getAbsoluteFile();
        List<String> lines=new ArrayList<>();
        try(BufferedReader br=new BufferedReader(new java.io.FileReader(file))) {
            String currentLine = br.readLine();
            while (null != currentLine) {
                lines.add(currentLine);
                currentLine = br.readLine();
            }
        }
        return lines;
    }
}

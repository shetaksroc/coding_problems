package com.example.autobot;

import com.example.autobot.entity.Context;
import com.example.autobot.entity.impl.WikiContext;
import com.example.autobot.utils.FileReader;
import lombok.Getter;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author akshay on 12/01/19
 */
@Getter
public class App {

    private String fileName;
    private String content;

    public App(String fileName) throws IOException {
        this.fileName=fileName;
        this.content= FileReader.readFile(fileName);
    }

    public static void main(String[] args) throws IOException {
//        App app=new App(System.getProperty("file_name"));
        App app=new App("input");
        Context context=new WikiContext(app.getContent());
        context.process();
    }
}

package com.example.autobot;

import com.example.autobot.service.Processor;
import com.example.autobot.service.impl.WikiProcessor;
import com.example.autobot.utils.FileReader;
import lombok.Getter;
import org.apache.commons.lang.Validate;

import java.io.IOException;

/**
 * @author akshay on 12/01/19
 */
@Getter
public class App {

    private String fileName;
    private String content;

    public App(String fileName) throws IOException {
        Validate.notEmpty(fileName, "File name cannot be null");
        this.fileName=fileName;
        this.content= FileReader.readFile(fileName);
    }

    public static void main(String[] args) throws IOException {
        String file = System.getProperties().contains("file_name")?System.getProperty("file_name"):"input";
        App app=new App(file);
        /**
         * When there are multiple processors we can have factory method which can return the appropriate object
         */
        Processor processor =new WikiProcessor(app.getContent());
        processor.process();
    }
}

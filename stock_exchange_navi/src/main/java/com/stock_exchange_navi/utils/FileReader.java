package com.stock_exchange_navi.utils;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Objects;

public class FileReader {
    public static List<String> readLines(String fileName) throws IOException  {
        ClassLoader classLoader = FileReader.class.getClassLoader();
        URL url = classLoader.getResource(fileName);
        if(Objects.nonNull(url)){
            File file=new File(url.getFile());
            return FileUtils.readLines(file.getAbsoluteFile(), Charset.defaultCharset());
        }
        throw new InvalidObjectException("File does not exists");
    }
}

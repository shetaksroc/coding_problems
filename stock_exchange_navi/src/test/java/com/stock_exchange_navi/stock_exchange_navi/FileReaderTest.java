package com.stock_exchange_navi.stock_exchange_navi;

import com.stock_exchange_navi.utils.FileReader;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author akshay on 21/04/21
 */
@Slf4j
public class FileReaderTest {
    public static final String FILE_NAME = "stock_exchange";

    @Test
    public void testReadLines_WhenValidFileIsGiven() throws IOException {
        List<String> readFiles= FileReader.readLines(FILE_NAME);
        Assert.assertTrue(readFiles.size()==1);
    }

    @Test(expected = java.io.InvalidObjectException.class)
    public void testReadLines_WhenInValidFileIsGiven() throws IOException {
        List<String> readFiles= FileReader.readLines("Invalid");
    }
}

package com.example.autobot;

import com.example.autobot.utils.FileReader;
import com.example.autobot.utils.GenericUtils;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/**
 * @author akshay on 12/01/19
 */
public class TestUtils {

    @Test
    public void testFileUtils() throws IOException {
        String data = FileReader.readFile("test");
        Assert.assertTrue(StringUtils.isNotBlank(data));
    }

    @Test(expected = FileNotFoundException.class)
    public void testEmptyFiles() throws IOException {
        String data = FileReader.readFile("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullFileName() throws IOException {
        String data = FileReader.readFile(null);
    }

    @Test
    public void testGenericUtils() {
        Assert.assertEquals("correct", GenericUtils.removeNoiseWords(" is that correct"));
        Assert.assertEquals("doing", GenericUtils.removeNoiseWords("What are you doing"));
        Assert.assertEquals("name", GenericUtils.removeNoiseWords("What is your name"));
    }

    @Test
    public void testCommonWords_negativecases() {
        Assert.assertEquals(Collections.EMPTY_LIST, GenericUtils.findCommonWords(Arrays.asList("J", "K"),null));
        Assert.assertEquals(Collections.EMPTY_LIST, GenericUtils.findCommonWords(null,Arrays.asList("J", "K")));
        Assert.assertEquals(Collections.EMPTY_LIST, GenericUtils.findCommonWords(Arrays.asList("F"),Arrays.asList("J", "K")));
    }

    @Test
    public void testCommonWords_positivecases() {
        Assert.assertEquals(Arrays.asList("J", "K"), GenericUtils.findCommonWords(Arrays.asList("J", "K"),Arrays.asList("J", "K")));
        Assert.assertEquals(Arrays.asList("K"), GenericUtils.findCommonWords(Arrays.asList("K"),Arrays.asList("J", "K")));
    }

    @Test
    public void testCommonWordsRatio_positivecases() {
        Assert.assertEquals(1, GenericUtils.getCommonWordsRatioBetweenTwoLists(Arrays.asList("J", "K"),Arrays.asList("J", "K")),0.01);
        Assert.assertEquals(0.25, GenericUtils.getCommonWordsRatioBetweenTwoLists(Arrays.asList("K"),Arrays.asList("J", "K", "va","fr")),0.01);
    }


}

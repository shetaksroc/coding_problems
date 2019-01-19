package com.example.autobot;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

/**
 * @author akshay on 12/01/19
 */
public class TestApp {
    @Test
    public void testAppCreationWithDefaultFile() throws IOException {
        App app=new App("input");
        Assert.assertNotNull(app);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppCreationWithEmptyFile() throws IOException {
        App app=new App("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAppCreationWithNullFile() throws IOException {
        App app=new App(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithInvalidFile() throws IOException {
        App app=new App("in");
    }

    @Test
    public void testFileName() throws IOException {
        App app=new App("test");
        Assert.assertEquals("test",app.getFileName());
    }

    @Test
    public void testContent() throws IOException {
        App app=new App("test");
        Assert.assertFalse(app.getContent().isEmpty());
    }

}

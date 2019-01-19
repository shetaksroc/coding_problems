package com.example.autobot;

import com.example.autobot.service.Processor;
import com.example.autobot.service.impl.WikiProcessor;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

/**
 * @author akshay on 12/01/19
 */
public class TestProcessor {

    private App app;
    @Before
    public void setup() throws IOException {
        app=new App("test");
    }

    @Test
    public void testProcessor() {
        Processor processor = new Processor(app.getContent()) {
            @Override
            public void deriveAttributesFromRawData() {

            }

            @Override
            public void process() {

            }
        };
        Assert.assertNotNull(processor);
        Assert.assertNotNull(processor.getRawData());
    }

    @Test
    public void testCommonWordsPercentage() {
        Processor processor = new WikiProcessor(app.getContent());
        double percent=processor.findCommonWordsPercentage("hello i am doing good","How are you doing","doing good");
        Assert.assertEquals( 0.25,percent,0.001);
    }

    @Test
    public void testCommonWordsPercentage_NoMatch() {
        Processor processor = new WikiProcessor(app.getContent());
        double percent=processor.findCommonWordsPercentage("I fear no man","what are you doing","nothing");
        Assert.assertEquals( 0,percent,0.001);
    }

    // TODO: 12/01/19 Add more test cases

}

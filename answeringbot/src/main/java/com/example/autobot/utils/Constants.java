package com.example.autobot.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author akshay on 12/01/19
 */
public class Constants {

    /**
     *  Common string patters used
     */
    public static class Pattern{
        public static final String SINGLE_SPACE = " ";
        public static final String EMPTY = "";
        public static final String NEW_LINE = "\n";
        public static final String FULL_STOP = "\\.";
        public static final String QUESTION_MARK = "?";
        public static final String SEMICOLON = ";";
    }

    // todo can be populated through a Larger dictionary. For now keeping it a static list
    public static List<String> NOISE_WORDS=new ArrayList<>(Arrays.asList("you","your","with","it","do","their","they","which","what","which","why","how","when","are","is","the","of","and","to","for","a","an","that","in","while"));


    public static int DEFAULT_MATCH_PERCENT=0;

}

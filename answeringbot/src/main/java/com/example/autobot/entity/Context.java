package com.example.autobot.entity;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author akshay on 12/01/19
 */
@Getter
public abstract class Context {

    private List<String> noise=new ArrayList<String>(
            Arrays.asList("with","it","do","their","they","which","what","which","why","how","when","are","is","the","of","and","to","for","a","an","that","in","while"));

    private String rawData;

    public Context(String rawData) {
        this.rawData = rawData;
    }

    public abstract void deriveAttributesFromRawData();

    public abstract void process();

    public String removeNoiseWords(String data){
        StringBuilder builder=new StringBuilder();
        for(String word:data.split(" ")){
            if(!noise.contains(word.toLowerCase())){
                builder.append(word.toLowerCase()).append(" ");
            }
        }
        return builder.toString().trim();
    }

    protected List<String> findCommonWords(List<String> ar1, List<String> ar2){
        List<String> common=new ArrayList<>();
        for(String word: ar1){
            if(ar2.contains(word)){
                common.add(word);
            }
        }
        return common;
    }
}

package com.example.autobot.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.example.autobot.utils.Constants.NOISE_WORDS;
import static com.example.autobot.utils.Constants.Pattern.SINGLE_SPACE;

/**
 * @author akshay on 12/01/19
 * All helper/util methods can be found here
 */
public class GenericUtils {

    /**
     * Util method to give the common words between two lists
     * @param list1
     * @param list2
     * @return
     */
    public static List<String> findCommonWords(List<String> list1, List<String> list2){
        if(null==list1 || null==list2){
            return Collections.EMPTY_LIST;
        }
        List<String> common=new ArrayList<>();
        for(String word: list1){
            if(list2.contains(word)){
                common.add(word);
            }
        }
        return common;
    }

    /**
     * Generic method which finds the common words ratio between two lists
     * @param list1
     * @param list2
     * @return
     */

    public static double getCommonWordsRatioBetweenTwoLists(List<String> list1, List<String> list2){
        if(null==list1 || null==list2){
            return 0;
        }
        List<String> commonWordsBetweenList1andList2= GenericUtils.findCommonWords(list1, list2);
        return (commonWordsBetweenList1andList2.size()*1.0/list2.size());
    }

    /**
     *  Common method that can be used for reducing the data noise
     */
    public static String removeNoiseWords(String data){
        StringBuilder builder=new StringBuilder();
        for(String word:data.split(SINGLE_SPACE)){
            if(!NOISE_WORDS.contains(word.toLowerCase())){
                builder.append(word.toLowerCase()).append(SINGLE_SPACE);
            }
        }
        return builder.toString().trim();
    }
}

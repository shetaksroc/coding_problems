package com.example.autobot;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author akshay on 12/01/19
 */
public class Entity {


    Map<String,Integer> map;

    public Entity() {
        this.map= new HashMap<String, Integer>();
    }

    void populateFrequency(String s){
        if(map.containsKey(s)){
            map.put(s,map.get(s)+1);
        }else{
            map.put(s,1);
        }
    }

}

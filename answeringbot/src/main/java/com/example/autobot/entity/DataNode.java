package com.example.autobot.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author akshay on 12/01/19
 */
@Getter
@Setter
public class DataNode {
    private List<String> paragraphLines;
    private List<String> questions;
    private List<String> originalAnswers;

    public DataNode() {
        paragraphLines=new ArrayList<>();
        questions=new ArrayList<>();
        originalAnswers=new ArrayList<>();
    }
}

package com.example.autobot.service.impl;

import com.example.autobot.entity.DataNode;
import com.example.autobot.service.Processor;
import com.example.autobot.utils.GenericUtils;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.example.autobot.utils.Constants.DEFAULT_MATCH_PERCENT;
import static com.example.autobot.utils.Constants.Pattern.*;

/**
 * @author akshay on 12/01/19
 */
public class WikiProcessor extends Processor {

    /**
     *  Creating datanode object
     */
    private DataNode dataNode;
    private String[] answers;

    public WikiProcessor(String rawData) {
        super(rawData);
        dataNode=new DataNode();
        deriveAttributesFromRawData();
        answers=new String[dataNode.getOriginalAnswers().size()];
    }

    @Override
    public void deriveAttributesFromRawData(){
        /**
         * Doing data cleanup, removing noise data and replacing special characters.
         *
         */
        String[] lines=getRawData().split(NEW_LINE);
        dataNode.setParagraphLines(
                Arrays.asList(lines[0].split(FULL_STOP)).stream()
                        .map(s -> GenericUtils.removeNoiseWords(s))
                        .collect(Collectors.toList()));
        dataNode.setQuestions(
                IntStream.range(1,lines.length-1)
                        .mapToObj(i -> GenericUtils.removeNoiseWords(lines[i]).replace(QUESTION_MARK,EMPTY))
                        .collect(Collectors.toList()));
        dataNode.setOriginalAnswers(
                Arrays.asList(lines[lines.length - 1].split(SEMICOLON)).stream()
                        .map(s -> GenericUtils.removeNoiseWords(s)).collect(Collectors.toList()));
    }

    @Override
    public void process() {
        int i=0;
        for(String question: dataNode.getQuestions()){
            /**
             * Trying to find the answer for each questions, initial match percent = 0
             */
            analyzeQuestion(question,DEFAULT_MATCH_PERCENT,i++);
        }
        printAnswers();
    }

    private void printAnswers() {
        Arrays.asList(answers).forEach(answer->System.out.println(answer));
    }

    private void analyzeQuestion(String question, double maxMatchPercent, int answersIndex) {
        for(String line: dataNode.getParagraphLines()){
            maxMatchPercent = analyzeAnswers(question, maxMatchPercent, answersIndex, line);
        }
    }

    private double analyzeAnswers(String question, double maxMatchPercent, int answersIndex, String line) {
        for(String currentAnswer: dataNode.getOriginalAnswers()){
            if(!Arrays.asList(answers).contains(currentAnswer)){
                double currentMatchPercent= findCommonWordsPercentage(line,question,currentAnswer);
                if(maxMatchPercent<currentMatchPercent){
                    answers[answersIndex]=currentAnswer;
                    maxMatchPercent=currentMatchPercent;
                }
            }
        }
        return maxMatchPercent;
    }

}

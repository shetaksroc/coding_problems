package com.example.autobot.entity.impl;

import com.example.autobot.entity.Context;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author akshay on 12/01/19
 */
public class WikiContext extends Context {

    private List<String> paragraphLines;
    private List<String> questions;
    private List<String> originalAnswers;
    private String[] answers;

    public WikiContext(String rawData) {
        super(rawData);
        paragraphLines=new ArrayList<>();
        questions=new ArrayList<>();
        originalAnswers=new ArrayList<>();
        deriveAttributesFromRawData();
        answers=new String[originalAnswers.size()];
    }

    @Override
    public void process() {
        int i=0;
        for(String question: questions){
            analyzeQuestion(question,0,i++);
        }
        System.out.println(paragraphLines);
        System.out.println(questions);
        System.out.println(originalAnswers);
        System.out.println(Arrays.asList(answers));
    }

    private void analyzeQuestion(String quest, double maxPercent, int i) {
        for(String line: paragraphLines){
            maxPercent = analyzeAnswers(quest, maxPercent, i, line);
        }
    }

    private double analyzeAnswers(String quest, double maxPercent, int i, String line) {
        for(String ans: originalAnswers){
            if(!Arrays.asList(answers).contains(ans)){
                double per=findPercent(line,quest,ans);
                if(maxPercent<per){
                    answers[i]=ans;
                    maxPercent=per;
                }
            }
        }
        return maxPercent;
    }

    private double findPercent(String line, String quest, String answer) {
        List<String> lineWords=Arrays.asList(line.split(" "));
        List<String> questWords=Arrays.asList(quest.split(" "));
        List<String> answerWords=Arrays.asList(answer.split(" "));
        List<String> lineQuest= findCommonWords(lineWords, questWords);
        List<String> lineAnswer= findCommonWords(lineWords, answerWords);
        return (lineAnswer.size()*1.0/answerWords.size())*(lineQuest.size()*1.0/questWords.size());
    }

    @Override
    public void deriveAttributesFromRawData(){
        String[] lines=getRawData().split("\n");
        paragraphLines= Arrays.asList(lines[0].split("\\.")).stream().map(s -> removeNoiseWords(s)).collect(Collectors.toList());
        questions=IntStream.range(1,lines.length-1).mapToObj(i -> removeNoiseWords(lines[i]).replace("?","")).collect(Collectors.toList());
        originalAnswers = Arrays.asList(lines[lines.length - 1].split(";")).stream().map(s -> removeNoiseWords(s)).collect(Collectors.toList());
    }
}

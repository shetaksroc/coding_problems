package com.example.autobot.service;

import com.example.autobot.utils.GenericUtils;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

import static com.example.autobot.utils.Constants.NOISE_WORDS;
import static com.example.autobot.utils.Constants.Pattern.SINGLE_SPACE;

/**
 * @author akshay on 12/01/19
 */
@Getter
public abstract class Processor {


    /**
     * Field which contains the raw data from the sources
     */
    private String rawData;

    public Processor(String rawData) {
        this.rawData = rawData;
    }

    /**
     *  This method is used to parse the raw data and extract the require fields based on the processor
     *  Keeping it abstract for future extensibility.
     *  Because today we answer for wiki questions.
     *  Next we might want to answer questions for other sources like twitter, fb etc
     */
    protected abstract void deriveAttributesFromRawData();

    /**
     *  Answering logic for different sources will be local to it.
     */
    public abstract void process();


    /**
     * Find the percentage of the overlapping words between the line, current question and answer
     * @param line
     * @param question
     * @param answer
     * @return
     */
    public double findCommonWordsPercentage(String line, String question, String answer) {
        List<String> wordsInParagraphLine= Arrays.asList(line.split(SINGLE_SPACE));
        List<String> wordsInQuestion=Arrays.asList(question.split(SINGLE_SPACE));
        List<String> wordsInAnswer=Arrays.asList(answer.split(SINGLE_SPACE));

        double percentMatchForQuestion= GenericUtils.getCommonWordsRatioBetweenTwoLists(wordsInParagraphLine,wordsInQuestion);
        double percentMatchForAnswer= GenericUtils.getCommonWordsRatioBetweenTwoLists(wordsInParagraphLine,wordsInAnswer);

        return percentMatchForQuestion*percentMatchForAnswer;
    }


}

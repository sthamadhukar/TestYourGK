package com.testyourgk.service;

import com.testyourgk.model.questions.Questions;

import java.util.Collections;
import java.util.List;


/**
 * Created by Madhukar on 5/26/2016.
 */
public class PlayService {
    QuestionService questionService = new QuestionService();
    public Questions getNext(List<Integer> questionPlayed){
        int maxId, minId;
        maxId =questionService.maxId();
        minId = questionService.minId();
        System.out.println(maxId+"  "+ minId);
        int nextId =randomWithRange(minId,maxId);
        while (questionPlayed.contains(nextId)){
             nextId = randomWithRange(minId,maxId);
        }

        Questions nextQuestion = new QuestionService().listQuestions(nextId);
        while(nextQuestion==null){
            nextId =randomWithRange(minId,maxId);
            while (questionPlayed.contains(nextId)){
                nextId = randomWithRange(minId,maxId);
            }
            nextQuestion = new QuestionService().listQuestions(nextId);
        }
        return nextQuestion;
    }

    //get random id for question
    int randomWithRange(int min, int max)
    {
        int range = (max - min) + 1;
        return (int)(Math.random() * range) + min;
    }
    // function to shuffle the options since correct answer can be at any place
    //Argument required: List of options
    public List<String> shuffleOptions(List<String> options){
        Collections.shuffle(options);
        return options;
    }
}

package com.testyourgk.model.questions;

import com.testyourgk.service.QuestionService;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Madhukar on 5/21/2016.
 */
public class Test {
    public static void  main(String[] ar){
        //bootstraping some questions
        new QuestionService().save(new Questions("What is the height of Mt. Everest?", null, "75675m", "7546m", "6758m", "8848m"));
        new QuestionService().save(new Questions("Where was Buddha born?","Lord Gautam Buddha, Buddhism, Peace","America","China","Japan","Nepal"));

//// test for update
        /*Questions update =new Questions("What is the height of Mt. Everest?","Test for update" ,"7546m","6758m","7877m" ,"8848m");
        update.setId(1);
        new QuestionService().updateQuestion(update);*/

// test check
        List<Questions> questionsList = new QuestionService().listQuestions();
        for(Questions question: questionsList){

            System.out.println(question.getQuestion());

            //shuffle through the option with new list
            List<String> options= new ArrayList<String>();
            options.add(question.getCorrectAnswer());
            options.add(question.getOption1());
            options.add(question.getOption2( ));
            options.add(question.getOption3());
            Collections.shuffle(options);
            for(String option:options){
                System.out.println(option);
            }

        }

    }

}

package com.testyourgk.model.play;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Madhukar on 5/26/2016.
 */
public class PlaySession {
    List<Integer> questionPlayed = new ArrayList<Integer>();
    int numberOfQuestionPlayed;
    int score;
    int totalQuestions;
    int minId; // minimum id in db
    int maxId; // max id in db

    public List<Integer> getQuestionPlayed() {
        return questionPlayed;
    }

    public void setQuestionPlayed(List<Integer> questionPlayed) {
        this.questionPlayed = questionPlayed;
    }

    public int getNumberOfQuestionPlayed() {
        return numberOfQuestionPlayed;
    }

    public void setNumberOfQuestionPlayed(int numberOfQuestionPlayed) {
        this.numberOfQuestionPlayed = numberOfQuestionPlayed;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public int getMinId() {
        return minId;
    }

    public void setMinId(int minId) {
        this.minId = minId;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }
}

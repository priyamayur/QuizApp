package com.example.android.quizapp;

import android.media.Image;
import android.widget.ImageView;

public class QuizSolution {

       private int mQuestion;
       private int mAnswer;
       private int mOption1;
       private int mOption2;
       private int mOption3;
       private int mOption4;
       private int mImage;
       private int mHint;


    public QuizSolution(int question, int image,int hint, int answer, int option1, int option2, int option3, int option4) {
        mQuestion = question;
        mAnswer = answer;
        mOption1 = option1;
        mOption2 = option2;
        mOption3= option3;
        mOption4 = option4;
        mImage = image;
        mHint = hint;
    }


    public int getQuestion() {
        return mQuestion;
    }


    public int getAnswer() {
        return mAnswer;
    }

    public int getOption1() {
        return mOption1;
    }
    public int getOption2() {
        return mOption2;
    }
    public int getOption3() {
        return mOption3;
    }
    public int getOption4() {
        return mOption4;
    }
    public int getImage(){return mImage;}
    public int getHint() {
        return mHint;
    }
}
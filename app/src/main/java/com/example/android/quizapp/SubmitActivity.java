package com.example.android.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.EditText;

import com.budiyev.android.circularprogressbar.CircularProgressBar;

public class SubmitActivity extends AppCompatActivity {


    String name2;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);


        TextView score_text = (TextView) findViewById(R.id.score);
        score_text.setText(((String.valueOf(Math.round(QuizActivity.score))) + "%"));

        TextView name_display = (TextView) findViewById(R.id.name);
        name_display.setText(String.valueOf("Hi " + MainActivity.text));

        CircularProgressBar prog = (CircularProgressBar) findViewById(R.id.progress_bar);
        prog.setProgress(Math.round(QuizActivity.score));

        TextView comment = (TextView) findViewById(R.id.display);

        if (Math.round(QuizActivity.score) >= 80) {

            comment.setText("Well done!\nyou really know your world");


        }

        else if (Math.round(QuizActivity.score) >= 50 && Math.round(QuizActivity.score)<= 79)
        {
            comment.setText("Don't loose hope\nYou will get there!");
        }
        else
        {
            comment.setText("Oops\nYou still need to know your World!");
        }

    }
}

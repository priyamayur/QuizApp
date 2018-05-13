package com.example.android.quizapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    static String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edit = (EditText) findViewById(R.id.edit_text);


        edit.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (!s.equals("")) {
                    text = edit.getText().toString();


                }
            }


            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if (!s.equals("")) {
                    text = edit.getText().toString();


                }
            }

            public void afterTextChanged(Editable s) {

                if (!s.equals("")) {
                    text = edit.getText().toString();

                }

            }
        });


        // Find the View that shows the numbers category
        CircleImageView startButton = (CircleImageView) findViewById(R.id.start_button);
        startButton.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                // Create a new intent to open the {@link to QuizActivity
                Intent startIntent = new Intent(MainActivity.this, QuizActivity.class);
                startIntent.putExtra("name_entered", text);

                // Start the new activity
                startActivity(startIntent);
            }
        });
    }
}







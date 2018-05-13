package com.example.android.quizapp;


import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import de.hdodenhof.circleimageview.CircleImageView;

public class QuizActivity extends AppCompatActivity {
    static int count = 0, correct =0, hintCount=0,c=0;
    QuizSolution[] quiz = new QuizSolution[10];
    int[] radioId = new int[10];
    static double score,f,d,e;
    String name;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);




        quiz[0] = new QuizSolution(R.string.question1,R.drawable.machu_pichu,R.string.hint1,R.string.answer1, R.string.option11,R.string.option12, R.string.option13, R.string.option14);
        quiz[1] = new QuizSolution(R.string.question2,R.drawable.dead_sea,R.string.hint2,R.string.answer2, R.string.option21,R.string.option22, R.string.option23, R.string.option24);
        quiz[2] = new QuizSolution(R.string.question3,R.drawable.mariana_trench,R.string.hint3,R.string.answer3, R.string.option31,R.string.option32, R.string.option33, R.string.option34);
        quiz[3] = new QuizSolution(R.string.question4,R.drawable.vatican_city,R.string.hint4,R.string.answer4, R.string.option41,R.string.option42, R.string.option43, R.string.option44);
        quiz[4] = new QuizSolution(R.string.question5,R.drawable.instanbul,R.string.hint5,R.string.answer51, R.string.option51,R.string.option52, R.string.option53, R.string.option54);
        quiz[5] = new QuizSolution(R.string.question6,R.drawable.giants_causeway,R.string.hint6,R.string.answer6, R.string.option61,R.string.option62, R.string.option63, R.string.option64);
        quiz[6] = new QuizSolution(R.string.question7,R.drawable.congo_river,R.string.hint7,R.string.answer7, R.string.option71,R.string.option72, R.string.option73, R.string.option74);
        quiz[7] = new QuizSolution(R.string.question8,R.drawable.chocolate_hills,R.string.hint8,R.string.answer8, R.string.option81,R.string.option82, R.string.option83, R.string.option84);
        quiz[8] = new QuizSolution(R.string.question9,R.drawable.indus_valley,R.string.hint9,R.string.answer9, R.string.option91,R.string.option92, R.string.option93, R.string.option94);
        quiz[9] = new QuizSolution(R.string.question10,R.drawable.antarctic_desert,R.string.hint10,R.string.answer10, R.string.option101,R.string.option102, R.string.option103, R.string.option104);

        final EditText edit =(EditText) findViewById(R.id.edit_text);
       // String text= edit.getText().toString();

        edit.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if(!s.equals("") ) {
                    String text= edit.getText().toString();


                }
            }



            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {

                if(!s.equals("") ) {
                    String text= edit.getText().toString();


                }
            }

            public void afterTextChanged(Editable s) {
                String text= edit.getText().toString();
                if (text.equalsIgnoreCase(getResources().getString(quiz[count].getAnswer())))
               {
                    correct++;


               }

            }
        });


        name = getIntent().getStringExtra("name_entered");

        Button submitButton = (Button) findViewById(R.id.submit_button);
        submitButton.setOnClickListener(new OnClickListener() {
            // The code in this method will be executed when the submit is clicked on.
            @Override
            public void onClick(View view) {
                 d= correct*2;
                 e= d-hintCount;
                 f=(e/20.0)*100.0 ;
                score = (double)(((((correct)*2)-(hintCount))/20.0)*100.0);
                //TextView tx =(TextView) findViewById(R.id.test);
                //tx.setText((String.valueOf(score)));
                // Create a new intent to open the {@link to QuizActivity
                Intent startIntent = new Intent(QuizActivity.this, SubmitActivity.class);

               // Bundle bundle=new Bundle();
                //bundle.putInt("score_total",score);


                //startIntent.putExtra("score_total",score);

                //startIntent.putExtras(bundle);


                // Start the new activity
                startActivity(startIntent);
            }
        });
    }


    public void onRadioButtonClicked(View view) {


        boolean checked = ((RadioButton) view).isChecked();
        RadioGroup rg = (RadioGroup) findViewById(R.id.option_group);
        String answer_value = ((RadioButton) findViewById(rg.getCheckedRadioButtonId())).getText().toString();
        radioId[count] = rg.getCheckedRadioButtonId();

        if (answer_value.equalsIgnoreCase(getResources().getString(quiz[count].getAnswer()))){

          correct++;

        }
    }


    public void onCheckBoxClicked(View view) {

        CheckBox check1 = (CheckBox) findViewById(R.id.checkbox1);
        CheckBox check2 = (CheckBox) findViewById(R.id.checkbox2);
        CheckBox check3 = (CheckBox) findViewById(R.id.checkbox3);
        CheckBox check4 = (CheckBox) findViewById(R.id.checkbox4);
        if (check1.isChecked() && check3.isChecked() && !check2.isChecked() && !check4.isChecked() ) {
             correct++;

        }

    }

   /* public void onEditTextClicked(View view) {

        EditText edit =(EditText) findViewById(R.id.edit_text);
        String text= edit.getText().toString();
        if (text.equalsIgnoreCase(getResources().getString(quiz[count].getAnswer())))
        {
            //correct++;

            TextView tx =(TextView) findViewById(R.id.test);
            tx.setText(text);
        }
    }*/

    public void onHintClicked(View view)
    {

        TextView text =(TextView) findViewById(R.id.hint_text);
        text.setVisibility(View.VISIBLE);
        text.setText(getResources().getString(quiz[count].getHint()));
        hintCount++;

    }

    public void onPreviousButtonClicked(View view) {

        count--;


        if (count >= 0 && count < 10) {

            RadioGroup rg = (RadioGroup) findViewById(R.id.option_group);
            rg.check(radioId[count]);

            TextView hintText =(TextView) findViewById(R.id.hint_text);
            hintText.setVisibility(View.GONE);
            ProgressBar bar = (ProgressBar) findViewById(R.id.progress_bar);
            bar.setProgress(count + 1);
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setEnabled(true);
            Button previousButton = (Button) findViewById(R.id.previous_button);
            previousButton.setEnabled(true);

            if (count == 4) {

                rg.setVisibility(View.GONE);


                LinearLayout lin = (LinearLayout) findViewById(R.id.checkbox);
                lin.setVisibility(View.VISIBLE);

                EditText text = (EditText) findViewById(R.id.edit_text);
                text.setVisibility(View.GONE);

                TextView question = (TextView) findViewById(R.id.title_text_view);
                question.setText(quiz[count].getQuestion());

                ImageView img = (ImageView) findViewById(R.id.image);
                img.setImageResource(quiz[count].getImage());

                CheckBox option1 = (CheckBox) findViewById(R.id.checkbox1);
                option1.setText(quiz[count].getOption1());

                CheckBox option2 = (CheckBox) findViewById(R.id.checkbox2);
                option2.setText(quiz[count].getOption2());

                CheckBox option3 = (CheckBox) findViewById(R.id.checkbox3);
                option3.setText(quiz[count].getOption3());

                CheckBox option4 = (CheckBox) findViewById(R.id.checkbox4);
                option4.setText(quiz[count].getOption4());


            } else if (count == 5) {
                TextView question = (TextView) findViewById(R.id.title_text_view);
                question.setText(quiz[count].getQuestion());

                ImageView img = (ImageView) findViewById(R.id.image);
                img.setImageResource(quiz[count].getImage());


                rg.setVisibility(View.GONE);

                LinearLayout lin = (LinearLayout) findViewById(R.id.checkbox);
                lin.setVisibility(View.GONE);
                EditText text = (EditText) findViewById(R.id.edit_text);
                text.setVisibility(View.VISIBLE);
            } else {


                LinearLayout lin = (LinearLayout) findViewById(R.id.checkbox);
                lin.setVisibility(View.GONE);

                EditText text  = (EditText) findViewById(R.id.edit_text);
                text.setVisibility(View.GONE);


                rg.setVisibility(View.VISIBLE);

                TextView question = (TextView) findViewById(R.id.title_text_view);
                question.setText(quiz[count].getQuestion());

                ImageView img = (ImageView) findViewById(R.id.image);
                img.setImageResource(quiz[count].getImage());

                RadioButton option1 = (RadioButton) findViewById(R.id.option1);
                option1.setText(quiz[count].getOption1());

                RadioButton option2 = (RadioButton) findViewById(R.id.option2);
                option2.setText(quiz[count].getOption2());

                RadioButton option3 = (RadioButton) findViewById(R.id.option3);
                option3.setText(quiz[count].getOption3());

                RadioButton option4 = (RadioButton) findViewById(R.id.option4);
                option4.setText(quiz[count].getOption4());


            }
        }
        else
            {
                Button previousButton = (Button) findViewById(R.id.previous_button);
                previousButton.setEnabled(false);
            }

        }


    public void onNextButtonClicked(View view) {

        count++;

        if (count<10) {
            RadioGroup rg = (RadioGroup) findViewById(R.id.option_group);
            rg.check(radioId[count]);
            TextView hintText =(TextView) findViewById(R.id.hint_text);
            hintText.setVisibility(View.GONE);
            ProgressBar bar = (ProgressBar)findViewById(R.id.progress_bar);
            bar.setProgress(count+1);
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setEnabled(true);
            Button previousButton = (Button) findViewById(R.id.previous_button);
            previousButton.setEnabled(true);

            if (count==4)
            {

                rg.setVisibility(View.GONE);

                LinearLayout lin = (LinearLayout) findViewById(R.id.checkbox);
                lin.setVisibility(View.VISIBLE);

                EditText text  = (EditText) findViewById(R.id.edit_text);
                text.setVisibility(View.GONE);

                TextView question = (TextView) findViewById(R.id.title_text_view);
                question.setText(quiz[count].getQuestion());

                ImageView img = (ImageView) findViewById(R.id.image);
                img.setImageResource(quiz[count].getImage());

                CheckBox option1 = (CheckBox) findViewById(R.id.checkbox1);
                option1.setText(quiz[count].getOption1());

                CheckBox option2 = (CheckBox) findViewById(R.id.checkbox2);
                option2.setText(quiz[count].getOption2());

                CheckBox option3 = (CheckBox) findViewById(R.id.checkbox3);
                option3.setText(quiz[count].getOption3());

                CheckBox option4 = (CheckBox) findViewById(R.id.checkbox4);
                option4.setText(quiz[count].getOption4());


            }
            else if (count==5)
            {
                TextView question = (TextView) findViewById(R.id.title_text_view);
                question.setText(quiz[count].getQuestion());

                ImageView img = (ImageView) findViewById(R.id.image);
                img.setImageResource(quiz[count].getImage());


                rg.setVisibility(View.GONE);

                LinearLayout lin = (LinearLayout) findViewById(R.id.checkbox);
                lin.setVisibility(View.GONE);

                EditText text  = (EditText) findViewById(R.id.edit_text);
                text.setVisibility(View.VISIBLE);
            }
            else
            {
                LinearLayout lin = (LinearLayout) findViewById(R.id.checkbox);
                lin.setVisibility(View.GONE);

                EditText text  = (EditText) findViewById(R.id.edit_text);
                text.setVisibility(View.GONE);


                rg.setVisibility(View.VISIBLE);


            TextView question = (TextView) findViewById(R.id.title_text_view);
            question.setText(quiz[count].getQuestion());

            ImageView img = (ImageView) findViewById(R.id.image);
            img.setImageResource(quiz[count].getImage());

            RadioButton option1 = (RadioButton) findViewById(R.id.option1);
            option1.setText(quiz[count].getOption1());

            RadioButton option2 = (RadioButton) findViewById(R.id.option2);
            option2.setText(quiz[count].getOption2());

            RadioButton option3 = (RadioButton) findViewById(R.id.option3);
            option3.setText(quiz[count].getOption3());

            RadioButton option4 = (RadioButton) findViewById(R.id.option4);
            option4.setText(quiz[count].getOption4());
             }
        }
        else
        {
            Button nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setEnabled(false);
        }

    }



}
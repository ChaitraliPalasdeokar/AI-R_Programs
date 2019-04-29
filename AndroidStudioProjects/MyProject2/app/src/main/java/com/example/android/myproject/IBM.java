package com.example.android.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Locale;


public class IBM extends AppCompatActivity {

    private QuestionIBM questionlibrary=new QuestionIBM();
    private static final long START_TIME=1200000;
    private TextView mtextviewcountdown;
    private CountDownTimer mcountdowntimer;
    private boolean mtimerrunning;
    private long mtimeleft=START_TIME;
    private TextView mscoreview;
    private TextView questview;
    private RadioButton bchoice1;
    private RadioButton bchoice2;
    private RadioButton bchoice3;
    private Button submittest;
    private Button next;
    private String mAns;
    private int mScore=0;
    private int mQuestionNumb=0;
    RadioGroup radioGroup;
    int right=0;
    int wrong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibm);
        radioGroup=(RadioGroup)findViewById(R.id.radiogrp);
        getSupportActionBar().setTitle("IBM PRACTICE TEST");

        mscoreview=(TextView)findViewById(R.id.sco);
        questview=(TextView)findViewById(R.id.que);
        bchoice1=(RadioButton)findViewById(R.id.rb1);
        bchoice2=(RadioButton)findViewById(R.id.rb2);
        bchoice3=(RadioButton)findViewById(R.id.rb3);
        next=(Button)findViewById(R.id.bt);
        submittest=(Button)findViewById(R.id.submit);
        mtextviewcountdown=findViewById(R.id.Time);

        startTimer();
        updateQuestion();
        submittest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestionNumb==20&&bchoice3.isChecked()){
                    mScore=mScore+1;
                }
                TextView textView=findViewById(R.id.sco);
//String mess=textView.getText().toString();
                Intent sa=new Intent(IBM.this,IBMScoreCard.class);
                sa.putExtra("mScore",mScore);
                sa.putExtra("right",right);
                sa.putExtra("wrong",wrong);
                startActivity(sa);
                finish();
            }
        });
        bchoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bchoice1.getText()==mAns){
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mQuestionNumb==19)
                            {
                                next.setVisibility(View.INVISIBLE);
                            }
                            else {
                                if (bchoice1.isChecked()) {
                                    mScore = mScore + 1;
                                    right++;
                                    updateScore(mScore);
                                    updateQuestion();
                                } else {
                                    Toast.makeText(IBM.this, "please tick the answer", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
                else{
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mQuestionNumb==19)
                            {
                                next.setVisibility(View.INVISIBLE);
                            }
                            if( bchoice1.isChecked()) {

                                updateQuestion();
                                wrong++;
                            }
                        }
                    });
                }
            }
        });
        bchoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(bchoice2.getText()==mAns){
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mQuestionNumb==19)
                            {
                                next.setVisibility(View.INVISIBLE);
                            }
                            if (bchoice2.isChecked()) {
                                mScore = mScore + 1;
                                right++;
                                updateScore(mScore);
                                updateQuestion();
                            } else {
                                Toast.makeText(IBM.this, "please tick the answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
                else{
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mQuestionNumb==19)
                            {
                                next.setVisibility(View.INVISIBLE);
                            }
                            if( bchoice2.isChecked()) {
                                wrong++;

                                updateQuestion();
                            }else{
                                Toast.makeText(IBM.this, "please tick the answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
        bchoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mQuestionNumb==19){
                    mScore++;
                }
                if(bchoice3.getText()==mAns){
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mQuestionNumb==19)
                            {
                                next.setVisibility(View.INVISIBLE);
// mScore=mScore+1;
                            }
                            else {
                                if (bchoice3.isChecked()) {
                                    mScore = mScore + 1;
                                    right++;
                                    updateScore(mScore);

                                    updateQuestion();
                                } else {
                                    Toast.makeText(IBM.this, "please tick the answer", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    });
                }
                else{
                    next.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            if (mQuestionNumb==19)
                            {
                                next.setVisibility(View.INVISIBLE);
                            }

                            if( bchoice3.isChecked()) {
                                wrong++;

                                updateQuestion();
                            }else{
                                Toast.makeText(IBM.this, "please tick the answer", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
                }
            }
        });
    }
    private  void startTimer(){
        mcountdowntimer=new CountDownTimer(mtimeleft,1000) {
            @Override
            public void onTick(long l) {
                mtimeleft=l;
                updateCountdown();
            }
            @Override
            public void onFinish() {
            }
        }.start();
    }
    private void updateCountdown(){
        int minutes=(int)(mtimeleft/1000)/60;
        int seconds=(int)(mtimeleft/1000)%60;
        String timeleftfor=String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        mtextviewcountdown.setText(timeleftfor);
    }
    private void updateQuestion() {
        questview.setText(questionlibrary.getQuestions(mQuestionNumb));
        bchoice1.setText(questionlibrary.getchoices1(mQuestionNumb));
        bchoice2.setText(questionlibrary.getchoices2(mQuestionNumb));
        bchoice3.setText(questionlibrary.getchoices3(mQuestionNumb));
        radioGroup.clearCheck();
        mAns = questionlibrary.getCorrectAnswer(mQuestionNumb);
        mQuestionNumb++;
        if (bchoice1.isChecked() || bchoice2.isChecked() || bchoice3.isChecked()) {
            bchoice1.setChecked(false);
            bchoice2.setChecked(false);
            bchoice3.setChecked(false);
        }
    }
    private void updateScore(int point){
        mscoreview.setText(""+mScore);
    }

}
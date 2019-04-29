package com.example.android.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FinalQuiz extends AppCompatActivity {

    List<Question> questionList;
    int score = 0;
    int quid = 0;


    int right=0;
    int wrong=0;
    Question currentQuestion;

    TextView txtQuestion;
    RadioButton rda,rdb,rdc;
    Button butNext,butSubmit;
    RadioGroup rbgroup;


    CountDownTimer mCountDownTimer;
    static final long START_TIME_IN_MILLIS=1200000;
    long mTimeLeftInMillis=START_TIME_IN_MILLIS;
    TextView mTextViewCountDown;

@Override
public  void onBackPressed(){
    final AlertDialog.Builder builder=new AlertDialog.Builder(FinalQuiz.this);
    builder.setMessage("Do you want to exit?");
    builder.setCancelable(true);
    builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            dialogInterface.cancel();
        }
    });

    builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
        @Override
        public void onClick(DialogInterface dialogInterface, int i) {
            Intent intent=new Intent(FinalQuiz.this,Main2Activity.class);
            startActivity(intent);
       finish();
        }
    });
    AlertDialog alertDialog=builder.create();
    alertDialog.show();
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_quiz);
        getSupportActionBar().setTitle("TEST");

        DbHelper dbHelper = new DbHelper(this);
        questionList = dbHelper.getAllQuestions();
        Collections.shuffle(questionList);
        currentQuestion = questionList.get(quid);
        mTextViewCountDown=findViewById(R.id.timer);

        txtQuestion = (TextView)findViewById(R.id.question);
        rda = (RadioButton)findViewById(R.id.radio0);
        rdb = (RadioButton)findViewById(R.id.radio1);
        rdc = (RadioButton)findViewById(R.id.radio2);
        rbgroup=(RadioGroup)findViewById(R.id.radioGroup1);
        butNext = (Button)findViewById(R.id.button1);
        butSubmit=(Button)findViewById(R.id.button2);
        setQuestionView();

        startTimer();



    }

    private void setQuestionView() {

        txtQuestion.setText(currentQuestion.getQuestion());
        rda.setText(currentQuestion.getOptA());
        rdb.setText(currentQuestion.getOptB());
        rdc.setText(currentQuestion.getOptC());
        rbgroup.clearCheck();
        quid++;
    }


    public void SubmitClick(View view){

        int leftquestions=15-quid;

        AlertDialog.Builder builder;

            builder = new AlertDialog.Builder(this);

        builder.setTitle("Submit Test")
                .setMessage("Are you sure you want to submit the test ?"+leftquestions+" questions are remaining")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(FinalQuiz.this, FinalResult.class);
                        Bundle b = new Bundle();
                        b.putInt("score", score);
                        intent.putExtras(b);
                        b.putInt("right",right);
                        intent.putExtras(b);
                        b.putInt("wrong",wrong);
                        intent.putExtras(b);
                        startActivity(intent);
                        finish();
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();





    }


    public void btClick(View view){
        RadioGroup grp = (RadioGroup)findViewById(R.id.radioGroup1);
        RadioButton answer = (RadioButton)findViewById(grp.getCheckedRadioButtonId());
        if(rda.isChecked()||rdb.isChecked()||rdc.isChecked()) {

            if (currentQuestion.getAnswer().equals(answer.getText())) {
                score++;
                right++;
                //Log.d("Score", "Your score: "+score);
            }
            else{
                wrong++;
            }


            if(quid==14){
                butNext.setText("Submit");

                butSubmit.setVisibility(View.INVISIBLE);
            }
            if (quid < 15) {
                currentQuestion = questionList.get(quid);
                setQuestionView();
            } else {

                Intent intent = new Intent(FinalQuiz.this, FinalResult.class);
                Bundle b = new Bundle();
                b.putInt("score", score);
                intent.putExtras(b);
                b.putInt("right",right);
                intent.putExtras(b);
                b.putInt("wrong",wrong);
                intent.putExtras(b);
                startActivity(intent);
                finish();
            }
        }

        else{
            Toast.makeText(FinalQuiz.this,"Please select an answer",Toast.LENGTH_SHORT).show();
        }

    }

    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUnitilFinished) {
                mTimeLeftInMillis = millisUnitilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
            }
        }.start();
    }

    private void updateCountDownText(){
        int minutes=(int) (mTimeLeftInMillis/1000)/60;
        int seconds=(int) (mTimeLeftInMillis/1000)%60;
        String timeLeftFormatted=String.format( Locale.getDefault(),"%02d:%02d",minutes,seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }


}

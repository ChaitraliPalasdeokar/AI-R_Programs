package com.example.android.myproject;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import static android.view.View.*;

public class TCSActivity extends AppCompatActivity {

    TextView question;
    RadioButton option1, option2, option3;
    Button next, endTest;
    String nextQuestion;
    int right,wrong,finalscore;
    int questionNumber;
    int optionPointer1;
    int optionPointer2;
    int optionPointer3;
    int answerPointer;
    CountDownTimer mCountDownTimer;
    static final long START_TIME_IN_MILLIS=1200000;
    long mTimeLeftInMillis=START_TIME_IN_MILLIS;



    TextView mTextViewCountDown;
    String choice1, choice2, choice3;
    public int score;

    final String question_array[] = {"1. A box of 150 packets consists of 1kg packets and 2kg packets. Total weight of box is 264kg. How many 2kg packets are there ?",
            "2. My flight takes of at 2am from a place at 18N 10E and landed 10 Hrs later at a place with coordinates 36N70W. What is the local time when my plane landed?",
            "3.  Y catches 5 times more fishes than X. If total number of fishes caught by X and Y is 42, then number of fishes caught by X?",
            "4.  It is __ absurd story",
            "5. While traveling on a train, you notice a man from the coach behind your fall of the train. You would?",
            "6. fill the blank: 6, 24, 60, 120, 210, ___",
            "7.  One afternoon, Manisha and Madhuri were talking to each other face to face in Bhopal on M.G. Road. If Manisha’s shadow was exactly to the exactly to the left of Madhuri, which direction was Manisha facing?\n" +
                    "\n",
            "8. State the tense:Are you playing tennis?",
            "9.  Odd man out: 1, 2, 4, 8, 16, 32, 64, 96",
            "10. All except one of the following are important strategies that a manager can use to create a more effective decision-making environment, Which one is not?",
            "11.  Four of the following five are alike in a certain way and so form a group. Which is the one that does not belong to that group?",
            "12.The sum of four consecutive even numbers is 292. What would be the smallest number?",
            "13. A fair price shopkeeper takes 10% profit on his goods. He lost 20% goods during theft. His loss percent is?",
            "14. Find the one which does not belong to that group?",
            "15.If the sum and difference of two numbers are 20 and 8 respectively, then the difference of their square is? ",
            "16.The H.C.F and L.C.M of two numbers are 84 and 21 respectively. If the ratio of the two numbers is 1:4, then the larger of the two numbers is?\n" +
                    "\n ",
            "17.Kim can do a work in 3 days while David can do the same work in 2 days. Both of them finish the work together and get Rs. 150. What is the share of Kim? ",
            "18.Excluding stoppages, the speed of a bus is 54 km/hr and including stoppages, it is 45 km/hr. For how many minutes does the bus stop per hour?",
            "19.Salaries of Ravi and Sumit are in the ratio 2:3. If the salary of each is increased by Rs. 4000, the new ratio becomes 40:57. What is Sumit’s present salary?",
            "20. Add questiont tag:  I never drink Coke._______" };

    final String option_array[] = {"114", "100", "115",
            "6.00", "6.40", "7.40",
            "10", "7", "6",
            "an", "a", "the",
            "Jump off the train to assist the falling man.","Shout at the falling man asking him to get quickly and entrain.","Pull the alarm chain so that the train may stop and the man may be helped.",
            "336","322 ","368",
            "east","south","north",
            "simple present","present continuous ","simple present continuous",
            "96", "32", "4",
            "Encourage others to make Decisions ","Relying solely upon himself/herself ","Recognize the importance of quality information",
            "Talent: Education","Air: Suffocation","Leg: Lame",
            "74","70","80",
            "12","14","11",
            "Chess","Boxing","Baseball ",
            "180","160","200",
            "84","108","48",
            "Rs. 40","Rs. 70","Rs. 60",
            "12","10","20",
            "None of these","Rs. 20,000","Rs. 25,500",
            "do I?","don’t I?","did I?",







    };




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_tcs);
        question = findViewById( R.id.question );
        option1 = findViewById( R.id.rd1 );
        option2 = findViewById( R.id.rd2 );
        option3 = findViewById( R.id.rd3 );
        next = findViewById( R.id.next );
        endTest = findViewById( R.id.end );
        mTextViewCountDown=findViewById(R.id.timer);

        getSupportActionBar().setTitle("TCS PRACTICE TEST");
        final RadioGroup rg1=(RadioGroup)findViewById(R.id.rg1);
        right=0;
        wrong=0;
        finalscore=0;
        answerPointer = 0;
        questionNumber = 0;
        score = 0;
        optionPointer1 = 0;
        optionPointer2 = 1;
        optionPointer3 = 2;

        nextQuestion = question_array[questionNumber];
        question.setText( nextQuestion );

        choice1 = option_array[optionPointer1];
        choice2 = option_array[optionPointer2];
        choice3 = option_array[optionPointer3];
        option1.setText( choice1 );
        option2.setText( choice2 );
        option3.setText( choice3 );
        rg1.clearCheck();
        startTimer();

        option1.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View view) {

                next.setOnClickListener( new OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if (option1.isChecked() && questionNumber==0 || questionNumber==3 || questionNumber==5 || questionNumber==8||questionNumber==10 ||questionNumber==12 ||questionNumber==15 ||questionNumber==18) {
                            score=score+5;
                            right++;
                      //      Toast.makeText( TCSActivity.this, "Good ! ", Toast.LENGTH_SHORT ).show();
                        }
                        else
                        {
                            wrong++;
                        }


                        questionNumber = questionNumber + 1;
                        optionPointer1 = optionPointer1 + 3;
                        optionPointer2 = optionPointer2 + 3;
                        optionPointer3 = optionPointer3 + 3;

                        question.setText( question_array[questionNumber] );
                        option1.setText( option_array[optionPointer1] );
                        option2.setText( option_array[optionPointer2] );
                        option3.setText( option_array[optionPointer3] );
                        rg1.clearCheck();

                        if (option1.isChecked() || option2.isChecked() || option3.isChecked()) {
                            option1.setChecked( false );
                            option2.setChecked( false );
                            option3.setChecked( false );
                        }

                        if (questionNumber==19)
                        {
                            next.setVisibility( View.INVISIBLE );
                        }
                    }
                } );


            }
        } );


        option2.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setOnClickListener( new OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (option2.isChecked() &&questionNumber==1|| questionNumber == 2 || questionNumber==7||questionNumber == 11 ||questionNumber == 14 ||questionNumber ==17||questionNumber ==9) {
                            score=score+5;
                            right++;

                        }
                        else{
                            wrong++;
                        }

                        questionNumber = questionNumber + 1;
                        optionPointer1 = optionPointer1 + 3;
                        optionPointer2 = optionPointer2 + 3;
                        optionPointer3 = optionPointer3 + 3;

                        question.setText( question_array[questionNumber] );
                        option1.setText( option_array[optionPointer1] );
                        option2.setText( option_array[optionPointer2] );
                        option3.setText( option_array[optionPointer3] );
                        rg1.clearCheck();

                        if (option1.isChecked() || option2.isChecked() || option3.isChecked()) {
                            option1.setChecked( false );
                            option2.setChecked( false );
                            option3.setChecked( false );
                        }

                        if (questionNumber==19)
                        {
                            next.setVisibility( View.INVISIBLE );
                        }
                    }
                } );

            }
        } );


        option3.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View view) {

                next.setOnClickListener( new OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (option3.isChecked() && questionNumber==4 || questionNumber==6||questionNumber==13 ||questionNumber==16) {
                            score=score+5;
                            right++;
                         //   Toast.makeText( TCSActivity.this, "Good ! ", Toast.LENGTH_SHORT ).show();
                        }
                        else
                        {
                            wrong++;
                        }

                        questionNumber = questionNumber + 1;
                        optionPointer1 = optionPointer1 + 3;
                        optionPointer2 = optionPointer2 + 3;
                        optionPointer3 = optionPointer3 + 3;

                        question.setText( question_array[questionNumber] );
                        option1.setText( option_array[optionPointer1] );
                        option2.setText( option_array[optionPointer2] );
                        option3.setText( option_array[optionPointer3] );

                        rg1.clearCheck();
                        if (option1.isChecked() || option2.isChecked() || option3.isChecked()) {
                            option1.setChecked( false );
                            option2.setChecked( false );
                            option3.setChecked( false );
                        }

                        if (questionNumber==19)
                        {
                            next.setVisibility( View.INVISIBLE );
                        }
                    }
                } );
            }
        } );


       /* previous.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (questionNumber >= 1) {
                    questionNumber = questionNumber - 1;
                    question.setText( question_array[questionNumber] );

                    option1.setText( option_array[optionPointer1 - 3] );
                    option2.setText( option_array[optionPointer2 - 3] );
                    option3.setText( option_array[optionPointer3 - 3] );

                questionNumber = questionNumber + 1;
                optionPointer1 = optionPointer1 + 3;
                optionPointer2 = optionPointer2 + 3;
                optionPointer3 = optionPointer3 + 3;
                }

                if (questionNumber==0)
                {
                    previous.setVisibility( view.INVISIBLE );
                }
            }
        } );*/


        endTest.setOnClickListener( new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option1.isChecked() && questionNumber==19)
                {
                    score=score+5;
                    right++;
                    //Toast.makeText( TCSActivity.this, "Good ! ", Toast.LENGTH_SHORT ).show();
                }
                else {
                    wrong++;
                }
                //Toast.makeText( MainActivity.this, "YOUR SCORE IS : " + score, Toast.LENGTH_SHORT ).show();
                Intent intent=new Intent(TCSActivity.this,TCSScoreCard.class);
                intent.putExtra("score",score);
                intent.putExtra("right",right);
                intent.putExtra("wrong",wrong);
                startActivity(intent);
                finish();

            }
        } );

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
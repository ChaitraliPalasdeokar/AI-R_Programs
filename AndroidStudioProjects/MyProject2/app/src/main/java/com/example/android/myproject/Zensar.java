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

import java.util.Locale;

public class Zensar extends AppCompatActivity {
    TextView question;
    RadioButton option1, option2, option3;
    Button next, endTest;
    String nextQuestion;
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
    public int score,right,wrong;
    final String question_array[] = {"1. Pipe A can fill a tank in 20 minutes and Pipe B in 30 minutes respectively. Pipe C can empty the same in 40 minutes. If all the three pipes are opened together, find the time taken to fill the tank?",
            "2. Find out the Simple Interest paid for a sum of Rs. 4000 at the rate of 8% per annum for 3 months.",
            "3. To 15 liters of water containing 20% alcohol, we add 5 liters of pure water. What is % alcohol?",
            "4. If 10x coins are added to the number of original coins he has (5y + 1) times more coins. Find out how many coins he had originally in terms of x and y.\n",
            "5. Four of the following five options are alike in a certain way and hence form a group. Which one of the following does not belong to that group?",
            "6. The orator was so ______ that the audience became ______",
            "7. We must try to understand his momentary ______ for he has ______ more strain and anxiety than any among us.",
            "8.  ELFA, GLHA, ILJA, _____, MLNA",
            "9.  Arrange the words given below in a meaningful sequence. 1. Protect 2. Pressure 3. Relief 4. Rain 5. Flood",
            "10. If a selection is to be made among them who would be relatively older and also taller, who among them should be chosen?",
            "11. A dishonest dealer professes to sell his goods at the cost price but uses a weight of 800gm instead of 1kg. Find his real gain percent.",
            "12. A sum of money lent out at simple interest amounts to Rs. 720 after 2 years and to Rs. 1,020 after a further period of 5 years. The sum and the rate % are",
            "13. A train with 90 km/h crosses a bridge in 36 seconds. Another train 100 metres shorter crosses the same bridge at 45 km/h. What is the time taken by the second train to cross the bridge ?",
            "14. Ramesh travels 760 km to his home, partly by train and partly by car He takes 8 hours, if he travels 160 km by train and the rest by car. He takes 12 minutes more, if he travels 240 km by train and the rest by car. What are the speeds of the train and of the car?",
            "15. Some students planned a picnic. The budget for food was Rs. 500. But, 5 of them failed to go and thus the cost of food for each member increased by Rs. 5. How many students attended the picnic?",
            "16. B2CD, _____, BCD4, B5CD, BC6D",
            "17. Look at this series: 36 34 30 28 24 ? What number should come next?",
            "18. Look at this series: 201 202 204 207 ... What number should come next?",
            "19. SCD, TEF, UGH, ____, WKL",
            "20. FAG, GAF, HAI, IAH, ____"};

    final String option_array[] = {"17 1/7 minutes", "20 minutes", "None of these",
            "800", "880", "80",
            "10%", "15%", "20%",
            "2x / y", "x / y", "x / y",
            "21","35","49",
            "Soporific, drowsy","Inaudible, elated","Pompous, bombastic",
            "Senility, understood","Vision, forgotten","Aberration, undergone",
            "OLPA","KLLA","KLMA",
            "2, 4, 5, 1, 3", "2, 4, 3, 1, 5", "2, 5, 4, 1, 3",
            "A","B","C",
            "25%","20%","15%",
            "Rs. 500, 5%","Rs. 400, 15%","Rs. 600, 10%",
            "64 seconds","55 seconds","50 seconds",
            "Speed of car = 90 km/h, speed of train = 60 km/h","Speed of car = 100 km/h, speed of train = 80 km/h","Speed of car = 80 km/h, speed of train = 70 km/h",
            "15","25","20",
            "B2C2D","BC3D","B2C3D",
            "20","21","22",
            "14","16","15",
            "211","210","212",
            "CMN","UJI","VIJ",
            "JAK","HAL","HAK"};





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zensar);

        getSupportActionBar().setTitle("ZENSAR PRACTICE TEST");
        question = findViewById( R.id.question );
        option1 = findViewById( R.id.rd1 );
        option2 = findViewById( R.id.rd2 );
        option3 = findViewById( R.id.rd3 );
        next = findViewById( R.id.next );
        endTest = findViewById( R.id.end );
        mTextViewCountDown=findViewById(R.id.timer);
        final RadioGroup rg1=(RadioGroup)findViewById(R.id.rg1);
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

        option1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        if (option1.isChecked() && questionNumber==19 || questionNumber==0 || questionNumber==3 || questionNumber==5 || questionNumber==8 || questionNumber==10 || questionNumber==12) {
                            score=score+5;
                            right++;
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


        option2.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                next.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (option2.isChecked() && questionNumber == 2 || questionNumber==7 || questionNumber==13 || questionNumber==15 ) {
                            score=score+5;
                            right++;

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


        option3.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                next.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        if (option3.isChecked() && questionNumber == 1 || questionNumber==4 || questionNumber==6 || questionNumber==11 || questionNumber==16 || questionNumber==14 || questionNumber==16 || questionNumber==18) {
                            score=score+5;
                            right++;


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

        endTest.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (option2.isChecked() && questionNumber==9)
                {   right++;
                    score=score+5;

                }
                else
                {
                    wrong++;
                }
                //Toast.makeText( MainActivity.this, "YOUR SCORE IS : " + score, Toast.LENGTH_SHORT ).show();
                Intent intent=new Intent(Zensar.this,ZensarScoreCard.class);
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




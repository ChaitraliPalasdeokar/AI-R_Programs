package com.example.android.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class FinalResult extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_result);


        TextView scoreTxtView = (TextView) findViewById(R.id.scores);
        TextView rightTxtView = (TextView) findViewById(R.id.no_of_right_ans);
        TextView wrongTxtView = (TextView) findViewById(R.id.no_of_wrong_ans);
        TextView tipsTxtView = (TextView) findViewById(R.id.tips);
        getSupportActionBar().setTitle("SCORE CARD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        int score = b.getInt("score");
        int finalscore=score*5;
        int right = b.getInt("right");
        int wrong = b.getInt("wrong");
        scoreTxtView.setText(String.valueOf(finalscore));
        rightTxtView.setText(String.valueOf(right));
        wrongTxtView.setText(String.valueOf(wrong));
        if (score < 5) {
            tipsTxtView.setText("You need to work more.Keep on Practising.");
        } else if (score < 10 && score > 5) {
            tipsTxtView.setText("Good.Keep on practising");
        } else if (score < 15 && score > 10) {
            tipsTxtView.setText("Well done!");
        } else if (score == 15) {
            tipsTxtView.setText("Hurray!! You are unstoppable");
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            Intent i=new Intent( FinalResult.this,MainActivity.class );
            startActivity( i );
            //Toast.makeText( this, "Logged out", Toast.LENGTH_SHORT ).show();
        }
        return super.onOptionsItemSelected(item);
    }

}

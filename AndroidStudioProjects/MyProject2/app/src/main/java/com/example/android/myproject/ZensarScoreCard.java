package com.example.android.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ZensarScoreCard extends AppCompatActivity {

    TextView score1,scoreCard1,right,wrong;
    Button solution,retest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zensar_score_card);


        getSupportActionBar().setTitle("SCORE CARD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        right=findViewById(R.id.no_of_right_ans);
        wrong=findViewById(R.id.no_of_wrong_ans);



        solution=findViewById( R.id.zensar_solution );
        score1=findViewById( R.id.scores );
        scoreCard1 =findViewById( R.id.scoreCard );
        retest=findViewById( R.id.button6 );

        retest.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent( ZensarScoreCard.this,ZensarInstructionActivity.class );
                startActivity( intent );
                finish();
            }
        } );

        solution.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent( ZensarScoreCard.this,ZensarSolution.class );
                startActivity( intent );
                finish();
            }
        } );
        Intent i=getIntent();
        int mScore=i.getIntExtra("score",0);
        score1.setText( " "+mScore );
        Intent i2=getIntent();
        int mScore2=i2.getIntExtra("right",0);
        right.setText( " "+mScore2 );
        Intent i3=getIntent();
        int mScore3=i3.getIntExtra("wrong",0);
        wrong.setText( " "+mScore3 );


    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {
            final AlertDialog.Builder builder=new AlertDialog.Builder(ZensarScoreCard.this);
            builder.setMessage("Do you want to Logout?");
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
                    Intent intent=new Intent(ZensarScoreCard.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();

                   }
        return super.onOptionsItemSelected(item);
    }

}

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
import android.widget.TextView;

public class TCSScoreCard extends AppCompatActivity {
    TextView score1,scoreCard1,right,wrong;
    Button solutions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tcsscore_card);
        Button b1=(Button)findViewById(R.id.solution);
        Button b2=(Button)findViewById(R.id.retest);
        right=findViewById(R.id.no_of_right_ans);
        wrong=findViewById(R.id.no_of_wrong_ans);
        score1=findViewById( R.id.scores);
        scoreCard1 =findViewById( R.id.scoreCard );

        getSupportActionBar().setTitle("SCORE CARD");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i=getIntent();
        int mScore=i.getIntExtra("score",0);
        score1.setText( " "+mScore );
        Intent i2=getIntent();
        int mScore2=i2.getIntExtra("right",0);
        right.setText( " "+mScore2 );
        Intent i3=getIntent();
        int mScore3=i3.getIntExtra("wrong",0);
        wrong.setText( " "+mScore3 );

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             Intent intent=new Intent(TCSScoreCard.this,TCSSolutionActivity.class);
             startActivity(intent);
             finish();
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(TCSScoreCard.this,InstructionActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.logout) {

            final AlertDialog.Builder builder=new AlertDialog.Builder(TCSScoreCard.this);
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
                    finish();
                    Intent intent=new Intent(TCSScoreCard.this,MainActivity.class);
                    startActivity(intent);

                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
        }
        return super.onOptionsItemSelected(item);
    }

}

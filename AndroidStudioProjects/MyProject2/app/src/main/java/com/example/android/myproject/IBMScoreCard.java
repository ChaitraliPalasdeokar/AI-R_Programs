package com.example.android.myproject;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.NotificationCompatExtras;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;


public class IBMScoreCard extends AppCompatActivity {
    private Button solu,retest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ibmscore_card);
        getSupportActionBar().setTitle("SCORE CARD");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        solu=findViewById(R.id.sol);
        retest=findViewById( R.id.retest );

        Intent intent=getIntent();
        int score=intent.getIntExtra("mScore",0);
        int right=intent.getIntExtra("right",0);
        int wrong=intent.getIntExtra("wrong",0);
        TextView textView=findViewById(R.id.ysc);
        TextView textView1=findViewById(R.id.right);
        TextView textView2=findViewById(R.id.wrong);
        int fscore=score*5;
        // TextView textView1=findViewById(R.id.textView12);
        textView.setText("SCORE  "+fscore);
        textView1.setText("Right  "+right);
        textView2.setText("Wrong  "+wrong);
       /* if(score<8){
            textView1.setText("Grade : Fail");
        }else if(score>=9&&score<16){
            textView1.setText("Grade : Pass");
        }else
        {
            textView1.setText("Grade : Excellent");
        }*/

        retest.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent=new Intent( IBMScoreCard.this,IBMInstructionActivity.class );
                startActivity( intent );
                finish();
            }
        } );

        solu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i=new Intent(IBMScoreCard.this,IBMSolution.class);
                startActivity(i);
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


            final AlertDialog.Builder builder=new AlertDialog.Builder(IBMScoreCard.this);
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
                    Intent intent=new Intent(IBMScoreCard.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            AlertDialog alertDialog=builder.create();
            alertDialog.show();
            //Toast.makeText( this, "Logged out", Toast.LENGTH_SHORT ).show();
        }
        return super.onOptionsItemSelected(item);
    }

}

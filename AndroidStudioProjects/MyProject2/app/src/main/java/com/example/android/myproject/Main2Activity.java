package com.example.android.myproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.strictmode.IntentReceiverLeakedViolation;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    Button b1,b2,b4,b3,b5;



    @Override
    public  void onBackPressed(){
        final AlertDialog.Builder builder=new AlertDialog.Builder(Main2Activity.this);
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
                //Intent intent=new Intent(Main2Activity.this,MainActivity.class);
                //startActivity(intent);
                finish();
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        b1=(Button)findViewById(R.id.button);
         b1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(Main2Activity.this,InstructionActivity.class);
                 startActivity(intent);
             }
         });


         b2=(Button)findViewById(R.id.button2);
         b2.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(Main2Activity.this,IBMInstructionActivity.class);
                 startActivity(intent);

             }
         });


         b4=(Button)findViewById(R.id.button4);
         b4.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(Main2Activity.this,FinalInstruction.class);
                 startActivity(intent);
             }
         });

         b3=(Button)findViewById(R.id.button3);
         b3.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 Intent intent=new Intent(Main2Activity.this,ZensarInstructionActivity.class);
                 startActivity(intent);
             }
         });

         b5=(Button)findViewById(R.id.button5);
         b5.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                 Intent intent=new Intent(Main2Activity.this,PracticeMaterialActivity.class);
                 startActivity(intent);

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
            Intent i=new Intent( Main2Activity.this,MainActivity.class );
            startActivity( i );
            finish();
            //Toast.makeText( this, "Logged out", Toast.LENGTH_SHORT ).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

package com.example.android.myproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ShowQuestions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_questions);
        getSupportActionBar().setTitle("DATABASE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        DbHelper help=new DbHelper(this);
        SQLiteDatabase db=help.getReadableDatabase();


        String[] columns = {"question","optA","optB","optC"};

        Cursor cursor =db.query("quiztable",columns,null,null,null,null,null);
        TextView displayView = (TextView) findViewById(R.id.text);

        try {
            // Display the number of rows in the Cursor (which reflects the number of rows in the
            // pets table in the database).

            displayView.setText("Total number of questions in Final test: " + cursor.getCount()+"\n\n");


            //displayView.append("question" + " - " + "optionA" + "\n");

            int questionColumnIndex = cursor.getColumnIndex("question");
            int optionAColumnIndex = cursor.getColumnIndex("optA");
            int optionBColumnIndex = cursor.getColumnIndex("optB");
            int optionCColumnIndex = cursor.getColumnIndex("optC");

            while (cursor.moveToNext()){
                String currentquestion=cursor.getString(questionColumnIndex);
                String currentoptionA=cursor.getString(optionAColumnIndex);
                String currentoptionB=cursor.getString(optionBColumnIndex);
                String currentoptionC=cursor.getString(optionCColumnIndex);

                displayView.append(("\n" + currentquestion + " \n " + currentoptionA+ " \n " + currentoptionB+ " \n " + currentoptionC+ " \n\n " ));

            }




















        } finally {
            // Always close the cursor when you're done reading from it. This releases all its
            // resources and makes it invalid.c
            cursor.close();
        }







    }
}

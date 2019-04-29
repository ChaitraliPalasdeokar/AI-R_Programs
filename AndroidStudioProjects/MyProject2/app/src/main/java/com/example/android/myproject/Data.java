package com.example.android.myproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Data extends AppCompatActivity {
TextView displayview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        DatabaseHelper help=new DatabaseHelper(this);
        SQLiteDatabase db=help.getReadableDatabase();
        getSupportActionBar().setTitle("USER'S DATABASE");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String[] columns = {"email","password"};









        Cursor cursor =db.query("user",columns,null,null,null,null,null);
        TextView displayView = (TextView) findViewById(R.id.mytext);

        try {


            displayView.setText("Total number of users: " + cursor.getCount()+"\n\n");


            displayView.append("email" + " - " + "password" + "\n");

            int emailColumnIndex = cursor.getColumnIndex("email");
            int passwordColumnIndex = cursor.getColumnIndex("password");

            while (cursor.moveToNext()){
                String currentemail=cursor.getString(emailColumnIndex);
                String currentpassword=cursor.getString(passwordColumnIndex);


                displayView.append(("\n" + currentemail + " - " + currentpassword));

            }




















        } finally {

            cursor.close();
        }





        /*displayview=(TextView)findViewById(R.id.mytext);
        displayview.setText("The user table contains");*/
    }
}

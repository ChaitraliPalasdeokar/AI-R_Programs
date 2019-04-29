package com.example.android.myproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {
    EditText email, password,cpassword;
    Button submit;
    SQLiteDatabase db;
    DatabaseHelper db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportActionBar().setTitle("REGISTRATION");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        email = (EditText) findViewById(R.id.editText);
        password = (EditText) findViewById(R.id.editText2);
        cpassword=(EditText)findViewById(R.id.editText3);

        submit = (Button) findViewById(R.id.button);
        db1=new DatabaseHelper(this);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=email.getText().toString();
                String s2=password.getText().toString();
                String s3=cpassword.getText().toString();
                if(s1.equals("")||s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext(),"Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else {

                    if(s1.equals("Admin")){
                        email.setError("Already Exists");
                    }

                    else {
                        if (s2.equals(s3)) {
                            Boolean checkmail = db1.checkmail(s1);
                            if (checkmail == true) {
                                Boolean insert = db1.insert(s1, s2);
                                if (insert == true) {
                                    Toast.makeText(getApplicationContext(), "Registered succesfully", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(getApplicationContext(), "Email already exists", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Password doesn't match", Toast.LENGTH_SHORT).show();
                        }
                    }
                }

            }
        });


    }
}

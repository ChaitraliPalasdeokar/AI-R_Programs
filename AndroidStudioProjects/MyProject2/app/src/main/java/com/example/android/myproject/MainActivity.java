package com.example.android.myproject;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity{
    EditText pwd,userid;
    Button login,register;
    DatabaseHelper db;
@Override
public void onBackPressed(){

    finish();

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new DatabaseHelper(this);
        pwd=(EditText)findViewById(R.id.pwd);
        userid=(EditText)findViewById(R.id.userid);
        login=(Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);
        final String s1=new String("Admin");
        final String s2=new String("123"); //done now








        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);//user activity 2 params
                    startActivity(intent);

            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=userid.getText().toString().trim();
                String password=pwd.getText().toString().trim();

                Boolean checkmailpass=db.validation(email,password);

                if(email.equals(s1) && password.equals(s2)) {
                    userid.setText("");
                    pwd.setText("");
                    Intent intent = new Intent(MainActivity.this, AdminLogin.class);//user activity 2 params
                    startActivity(intent);
                }


                else {

                    if(email.equals("")){
                        userid.setError("Field is empty");

                    }


                    if(password.equals("")){
                        pwd.setError("Field is empty");
                    }

                    else {

                        if (checkmailpass == true) {
                            userid.setText("");
                            pwd.setText("");
                            Intent intent = new Intent(MainActivity.this, Main2Activity.class);//user activity 2 params
                            startActivity(intent);
                        } else {
                            Toast.makeText(getApplicationContext(), "Wrong email or password", Toast.LENGTH_SHORT).show();
                        }

                    }



                }



            }
        });
    }
}

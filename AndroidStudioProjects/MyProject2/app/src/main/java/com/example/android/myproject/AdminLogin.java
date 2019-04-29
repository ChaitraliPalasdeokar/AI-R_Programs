package com.example.android.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class AdminLogin extends AppCompatActivity {
    Button b1,add,userdetails,del;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        b1=(Button)findViewById(R.id.button6);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminLogin.this,ShowQuestions.class);
                startActivity(intent);
            }
        });


        userdetails=findViewById(R.id.button7);
        userdetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminLogin.this,Data.class);
                startActivity(intent);
            }
        });


        add=(Button)findViewById(R.id.button8);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(AdminLogin.this,AddQuestions.class);
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
            Intent i=new Intent( AdminLogin.this,MainActivity.class );
            startActivity( i );
            finish();
            //Toast.makeText( this, "Logged out", Toast.LENGTH_SHORT ).show();
        }
        return super.onOptionsItemSelected(item);
    }

}

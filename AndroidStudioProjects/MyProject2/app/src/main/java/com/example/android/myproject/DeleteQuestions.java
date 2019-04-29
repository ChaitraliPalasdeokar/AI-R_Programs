package com.example.android.myproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeleteQuestions extends AppCompatActivity {
Button deletebutton;
EditText delete;
DbHelper db=new DbHelper(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_questions);

    delete=(EditText)findViewById(R.id.delete);
    deletebutton=(Button)findViewById(R.id.deletebutton);

    deletebutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String s1=delete.getText().toString();





           /* boolean result=db.delete(s1);
            if(result){
                Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
            }*/


        }
    });

    }
}

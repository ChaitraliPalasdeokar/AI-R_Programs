package com.example.android.myproject;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddQuestions extends AppCompatActivity {

    EditText addquestion,optA,optB,optC,correct;
    Button add;
    SQLiteDatabase db;
    DbHelper db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);

        getSupportActionBar().setTitle("ADD QUESTIONS");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        addquestion=(EditText)findViewById(R.id.addquestion);
        optA=(EditText)findViewById(R.id.optA);
        optB=(EditText)findViewById(R.id.optB);
        optC=(EditText)findViewById(R.id.optC);
        correct=(EditText)findViewById(R.id.correct);

        add=(Button)findViewById(R.id.add);

        db1=new DbHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1=addquestion.getText().toString();
                String s2=optA.getText().toString();
                String s3=optB.getText().toString();
                String s4=optC.getText().toString();
                String s5=correct.getText().toString();
                //correct.equals(optA)
                if(s1.equals("")||s2.equals("")||s3.equals("")||s4.equals("")||s5.equals("")){
                    addquestion.setError("Field is Empty");
                    optA.setError("Field is empty");
                    optB.setError("Field is empty");
                    optC.setError("Field is empty");
                    correct.setError("Field is empty");

                }

                if(s5.equals(s2)||s5.equals(s3)||s5.equals(s4)){

                    Boolean insert=db1.insert(s1,s2,s3,s4,s5);

                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Question added successfully", Toast.LENGTH_SHORT).show();
                    }

                }


                else{

                    Toast.makeText(getApplicationContext(), "Answer is not matching any of the options", Toast.LENGTH_LONG).show();
                }





            }
        });





    }
}

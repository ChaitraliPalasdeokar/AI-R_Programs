package com.example.android.myproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ZensarInstructionActivity extends AppCompatActivity {
    Button start_zensar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zensar_instruction);

        start_zensar=findViewById( R.id.zensar );
        start_zensar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent( ZensarInstructionActivity.this,Zensar.class );
                startActivity( intent );
                finish();
            }
        } );

    }
}

package com.example.android.myproject;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;

public class PracticeMaterialActivity extends AppCompatActivity {

    TextView aptitude_preparation,video1,read_online,quantitative,basic_grammar,english_grammar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_material);


        aptitude_preparation= findViewById(R.id.website1);
        video1=findViewById( R.id.video );
        quantitative=findViewById( R.id.quantitative_ebook );
        basic_grammar=findViewById( R.id.basic_grammar );
        english_grammar=findViewById( R.id.grammar );
        // read_online=findViewById( R.id.ebooks );


        SpannableString content = new SpannableString("Tips for better preparations !");
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        aptitude_preparation.setText(content);
        aptitude_preparation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.myamcat.com/blog/the-ultimate-preparation-guide-to-clear-aptitude-tests/"));
                startActivity(i);
            }
        });


        SpannableString content1 = new SpannableString("Before you start, have a look for the SECTIONS in APTITUDE TEST !");
        content1.setSpan(new UnderlineSpan(), 0, content1.length(), 0);
        video1.setText(content1);

        video1.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=YxbxSAqUXCs"));
                startActivity(i);
            }
        } );


        SpannableString content2 = new SpannableString("Quantitative Aptitude");
        content2.setSpan(new UnderlineSpan(), 0, content2.length(), 0);
        quantitative.setText(content2);

        quantitative.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://books.google.co.in/books?id=ahpFDwAAQBAJ&printsec=frontcover&dq=rapid+quantitative+aptitude&hl=en&sa=X&ved=0ahUKEwiJ4frhz4LcAhXXWisKHQtGB9MQ6AEIKzAA#v=onepage&q=rapid%20quantitative%20aptitude&f=false"));
                startActivity(i);
            }
        } );

        SpannableString content3 = new SpannableString("Verbal Aptitude- Basics of English Grammar");
        content3.setSpan(new UnderlineSpan(), 0, content3.length(), 0);
        basic_grammar.setText(content3);

        basic_grammar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://books.google.co.in/books?id=12PWRhkbD8QC&printsec=frontcover&dq=English+Grammar+books&hl=en&sa=X&ved=0ahUKEwi039_FsZncAhXRfn0KHcOzDNsQ6AEIMTAB#v=onepage&q=English%20Grammar%20books&f=false"));
                startActivity(i);
            }
        } );

        SpannableString content4 = new SpannableString("Verbal Aptitude- English Grammar");
        content4.setSpan(new UnderlineSpan(), 0, content4.length(), 0);
        english_grammar.setText(content4);

        english_grammar.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Intent.ACTION_VIEW, Uri.parse("https://books.google.co.in/books?id=7ryuRtiasPYC&printsec=frontcover&dq=oxford+english+grammar+book&hl=en&sa=X&ved=0ahUKEwjhkpm-947cAhXRbSsKHR_RCzUQ6AEIQDAE#v=onepage&q=oxford%20english%20grammar%20book&f=false"));
                startActivity(i);
            }
        } );
    }
}

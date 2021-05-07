package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button button2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    public void onClick(View view) {
        Intent i = new Intent(this,interface01.class);
        startActivity(i);
    }

    public void onClick_contatcInfo(View view) {
        Intent i = new Intent(this,ContactInfo.class);
        startActivity(i);
    }

    public void onClick_news(View view) {
        Intent i = new Intent(this,news_csr.class);
        startActivity(i);
    }



}
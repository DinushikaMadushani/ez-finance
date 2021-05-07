package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_home);

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

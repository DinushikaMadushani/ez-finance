package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class interface01 extends AppCompatActivity {
    Button button6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interface01);
        button6 = findViewById(R.id.button6);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(interface01.this,TeamsConditions.class);
                startActivity(i);
            }
        });
    }

    public void OnClick_finace(View view) {
        Intent i = new Intent(this, finance_calculation.class);
        startActivity(i);
    }

}
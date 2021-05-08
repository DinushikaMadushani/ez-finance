package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class TeamsConditions extends AppCompatActivity {
    Button btnNext;
    boolean clicked = false;
    private CheckBox check01;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams_conditions);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        btnNext = findViewById(R.id.btnNext);
        check01 = findViewById(R.id.check01);

         check01.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 clicked = true;
             }
         });


        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clicked == false) {
                    Toast.makeText(TeamsConditions.this,"Please confirm that you have read",Toast.LENGTH_SHORT).show();

                }else{
                    Intent intent = new Intent(TeamsConditions.this, ArrangeFinance.class);
                    startActivity(intent);
                }
            }
        });
    }

}
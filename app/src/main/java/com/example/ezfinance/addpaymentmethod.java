package com.example.ezfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class addpaymentmethod extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addpaymentmethod);
    }

    public void backhome(View view) {

        Intent intent =  new Intent(this,Userprofile.class);
        startActivity(intent);
    }
}
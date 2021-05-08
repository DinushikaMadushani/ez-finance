package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class ArrangeResult extends AppCompatActivity {
    private TextView nicView ;
    private Button nextbtn;
    private DBHelper dbHelper;
    private Context context;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrange_result);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context = this;
        dbHelper = new DBHelper(context);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String nic = intent.getStringExtra("nic");
        String address = intent.getStringExtra("address");
        String con = intent.getStringExtra("con");
        String mail = intent.getStringExtra("mail");
        String job = intent.getStringExtra("job");
        String income = intent.getStringExtra("income");


        TextView nameView = findViewById(R.id.nameView);
        nicView = findViewById(R.id.nicView);
        TextView addressView = findViewById(R.id.addressView);
        TextView conView = findViewById(R.id.conView);
        TextView mailView = findViewById(R.id.mailView);
        TextView jobView = findViewById(R.id.jobView);
        TextView incomeView = findViewById(R.id.incomeView);
        nextbtn = findViewById(R.id.nextbtn);

        nameView.setText("Name : " + name + "\n");
        nicView.setText("NIC Number : " + nic + "\n");
        addressView.setText("Address : " + address + "\n");
        conView.setText("Contact Number : " + con + "\n");
        mailView.setText("E-mail Address : " + mail + "\n");
        jobView.setText("Job : " + job + "\n");
        incomeView.setText("Income : " + income + "\n");




    }


    public void onClickNext(View view) {
        Intent i = new Intent(this,CalcResult.class);
        startActivity(i);
    }

}
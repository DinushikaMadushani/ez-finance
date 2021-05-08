package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class finance_calculation extends AppCompatActivity {
    private EditText amount,downpayment,time;
    Button calculatebtn1;
    private TextView clacAns01,clacAns02,clacAns03;
    double interest,netValue,monthlyPayment;
    int loanAmount,loanPeriod,downPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finance_calculation);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amount = findViewById(R.id.amount);
        downpayment = findViewById(R.id.downpayment);
        time = findViewById(R.id.time);
        calculatebtn1 = findViewById(R.id.calculatebtn1);
        clacAns01=findViewById(R.id.clacAns01);
        clacAns02=findViewById(R.id.clacAns02);
        clacAns03 = findViewById(R.id.clacAns3);

        calculatebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double interestRate = (float) 0.07;
                loanAmount = Integer.parseInt(amount.getText().toString());
                downPayment = Integer.parseInt(downpayment.getText().toString());
                loanPeriod = Integer.parseInt(time.getText().toString());


                netValue = (double) ((loanAmount - downPayment) / (loanPeriod * 12));
                interest = (double) (netValue * interestRate);
                monthlyPayment = (double) (interest + netValue);

                clacAns01.setText(String.valueOf("Rs. "+monthlyPayment));
                clacAns02.setText(String.valueOf("Rs. "+netValue));
                clacAns03.setText(String.valueOf("Rs. "+interest));
            }
        });

    }

    public void onClick_arrangeFinance(View view) {
        Intent i = new Intent (this, TeamsConditions.class);
        startActivity(i);

    }

    public double netValue(int loanAmount, int downPayment, int loanPeriod) {
        return (double) ((loanAmount - downPayment) / (loanPeriod * 12));

    }

    public double interest(double netValue, double interestRate) {
        return (double) (netValue * interestRate);
    }

    public double monthlyPayment(double interest, double netValue) {
        return (double) (interest + netValue);
    }
}

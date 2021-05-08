package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;

public class CalcResult extends AppCompatActivity {
    private EditText amount,downpayment,time;
    Button calculatebtn1,tnkNext;
    private TextView clacAns01,clacAns02,clacAns03;
    double interest,netValue,monthlyPayment;
    int loanAmount,loanPeriod,downPayment;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calc_result);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        amount = findViewById(R.id.amount);
        downpayment = findViewById(R.id.downpayment);
        time = findViewById(R.id.time);
        calculatebtn1 = findViewById(R.id.calculatebtn1);
        clacAns01=findViewById(R.id.clacAns01);
        clacAns02=findViewById(R.id.clacAns02);
        clacAns03 = findViewById(R.id.clacAns3);
        tnkNext = findViewById(R.id.tnkNext);


        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        awesomeValidation.addValidation(this,R.id.time,"[0-7]{1}", R.string.invalid_time);

        calculatebtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(awesomeValidation.validate()) {
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
                else{
                    Toast.makeText(CalcResult.this,"time limit over 7 years",Toast.LENGTH_LONG).show();
                }
            }
        });

        tnkNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CalcResult.this, thankYou.class);
                startActivity(intent);
            }
        });
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
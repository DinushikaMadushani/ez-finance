package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ContactInfo extends AppCompatActivity {
    private Button call,send;
     private EditText name1,email,message;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_info);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        call = findViewById(R.id.call);
        send = findViewById(R.id.send);
        name1 = findViewById(R.id.name1);
        email = findViewById(R.id.email);
        message = findViewById(R.id.message);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!email.getText().toString().isEmpty() && !name1.getText().toString().isEmpty() && !message.getText().toString().isEmpty()){

                    Intent intent = new Intent(Intent.ACTION_SEND);
                    intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email.getText().toString()});
                    intent.putExtra(Intent.EXTRA_SUBJECT, name1.getText().toString());
                    intent.putExtra(Intent.EXTRA_TEXT, message.getText().toString());
                    intent.setType("message/rfc822");

                    if(intent.resolveActivity(getPackageManager())!= null){
                        startActivity(intent);
                    }else{
                        Toast.makeText(ContactInfo.this,"There is no application that Support this action", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(ContactInfo.this, "Please fill details",Toast.LENGTH_LONG).show();
                }
            }
        });


        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //number = callview.getText().toString();
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:0817584896"));
                startActivity(intent);
            }
        });
    }
}
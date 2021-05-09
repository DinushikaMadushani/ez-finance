package com.example.ezfinance;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText eName;
    private EditText ePassword;
    private Button eLogin;
    private TextView eAttemptsInfo;

    private String UserName = "Admin";
    private String Password = "123456789";

    boolean isValid = false;
    private int counter = 5 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eName = findViewById(R.id.etName);
        ePassword = findViewById(R.id.etPassword);
        eLogin = findViewById(R.id.Loginbutton);
        eAttemptsInfo = findViewById(R.id.tvAttempt);

        eLogin.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                String inputName = eName.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputName.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please enter all the details correctly!",Toast.LENGTH_SHORT).show();
                }
                else{

                    isValid = validate(inputName,inputPassword);

                    if(!isValid){

                        counter--;

                        Toast.makeText(MainActivity.this, "Incorrect credentials entered",Toast.LENGTH_SHORT).show();

                        eAttemptsInfo.setText("Number of attempts remaining : "+counter );
                        if (counter == 0){
                            eLogin.setEnabled(false);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Login success",Toast.LENGTH_SHORT).show();

                        // add the code go to new activity
                        Intent intent = new Intent(MainActivity.this,Userprofile.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    private boolean validate(String eName, String ePassword) {

        if (eName.equals(UserName) && ePassword.equals(Password)){

            return true;
        }
        return false;
    }
}
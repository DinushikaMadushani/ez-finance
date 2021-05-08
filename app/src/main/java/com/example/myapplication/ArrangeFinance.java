package com.example.myapplication;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;

public class ArrangeFinance extends AppCompatActivity {

    private EditText name,nic,address ,con,mail,job,income;
    private Button btn1, btn2;
    private Context context;
    private DBHelper dbHelper;
    boolean clicked = false;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arrange_finance);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Assign Variable
        name = findViewById(R.id.name);
        nic = findViewById(R.id.nic);
        address = findViewById(R.id.address);
        con = findViewById(R.id.con);
        mail = findViewById(R.id.mail);
        job = findViewById(R.id.job);
        income = findViewById(R.id.income);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        context = this;
        dbHelper = new DBHelper(context);

        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //add Validations name
        awesomeValidation.addValidation(this,R.id.name, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        //add Validation nic
        awesomeValidation.addValidation(this,R.id.nic,"^([0-9]{9}[x|X|v|V]|[0-9]{12})$",R.string.invalid_nic);
        //add Validation phone number
        awesomeValidation.addValidation(this,R.id.con,"[0-9]{10}",R.string.invalid_mobile);
        //add Validation for mail
        awesomeValidation.addValidation(this,R.id.mail, Patterns.EMAIL_ADDRESS,R.string.invalid_email);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //check Validations
                if(awesomeValidation.validate()) {
                    String username = name.getText().toString();
                    String usernic = nic.getText().toString();
                    String useraddress = address.getText().toString();
                    String usercon = con.getText().toString();
                    String usermail = mail.getText().toString();
                    String userjob = job.getText().toString();
                    String userincome = income.getText().toString();

                    useModelClass usemodelclass = new useModelClass(username, usernic, useraddress, usercon, usermail, userjob, userincome);
                    dbHelper.insertUser(usemodelclass);
                    clicked = true;
                    Toast.makeText(ArrangeFinance.this, "Saved details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(ArrangeFinance.this,"Validation fails",Toast.LENGTH_SHORT).show();
                }
            }

        });




        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(ArrangeFinance.this);
                builder.setTitle("Message");
                builder.setMessage(" Save your details and confirm your arrangement ");

                builder.setPositiveButton("next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String username = name.getText().toString();
                        String usernic = nic.getText().toString();
                        String useraddress = address.getText().toString();
                        String usercon = con.getText().toString();
                        String usermail = mail.getText().toString();
                        String userjob = job.getText().toString();
                        String userincome = income.getText().toString();

                        //check All the details are completed
                        if ((username.isEmpty()) || (usernic.isEmpty()) || (useraddress.isEmpty()) || (usercon.isEmpty()) || usermail.isEmpty() || (userjob.isEmpty()) || (userincome.isEmpty())) {
                            AlertDialog dlg = new AlertDialog.Builder(ArrangeFinance.this)
                                    .setTitle("message")
                                    .setMessage("Please fill the details correctly")
                                    .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            dialog.dismiss();
                                        }
                                    })
                                    .create();
                            dlg.show();
                        } else {
                            if (clicked == false) {

                                Toast.makeText(ArrangeFinance.this, "Please save the details", Toast.LENGTH_SHORT).show();
                            } else {

                                //pass values ArrangeResult class
                                Intent intent = new Intent(ArrangeFinance.this, ArrangeResult.class);
                                intent.putExtra("name", username);
                                intent.putExtra("nic", usernic);
                                intent.putExtra("address", useraddress);
                                intent.putExtra("con", usercon);
                                intent.putExtra("mail", usermail);
                                intent.putExtra("job", userjob);
                                intent.putExtra("income", userincome);
                                startActivity(intent);
                            }
                        }
                    }
                });

                        builder.setNeutralButton("Delete", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which)
                            {
                                Integer deleteRows = dbHelper.deleteUser(nic.getText().toString());

                                if(deleteRows > 0) {
                                    name.getText().clear();
                                    nic.getText().clear();
                                    address.getText().clear();
                                    con.getText().clear();
                                    mail.getText().clear();
                                    job.getText().clear();
                                    income.getText().clear();
                                    Toast.makeText(ArrangeFinance.this, "Delete Details", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ArrangeFinance.this, ArrangeFinance.class);
                                    startActivity(intent);
                                }
                                else{
                                    Toast.makeText(ArrangeFinance.this, "Data not Delete", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                        builder.show();

                    }
                });
    }




}
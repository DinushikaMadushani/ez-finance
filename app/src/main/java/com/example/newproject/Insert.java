package com.example.newproject;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class Insert extends AppCompatActivity {

    private EditText accno,name,vcnumber ,cardno,cardty,mounthlyin,address;
    private Button btn1, btn2;
    private Context context;
    private dbconecter dbHandler;
    boolean clicked = false;
    AwesomeValidation awesomeValidation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);


        //Assign Variable
        accno = findViewById(R.id.accno1);
        name = findViewById(R.id.uname);
        vcnumber = findViewById(R.id.vechicleno);
        cardno = findViewById(R.id.con);
        cardty = findViewById(R.id.cardtyp);
        mounthlyin = findViewById(R.id.job);
        address = findViewById(R.id.address1);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        context = this;
        dbHandler = new dbconecter(context);



        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //add Validations name
        awesomeValidation.addValidation(this,R.id.uname, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        //add Validation nic
        awesomeValidation.addValidation(this,R.id.accno1,"[0-5]{6}",R.string.invalid_account);
        //add Validation phone number
        awesomeValidation.addValidation(this,R.id.job,RegexTemplate.NOT_EMPTY,R.string.invalid_amount);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //check Validations
                if(awesomeValidation.validate()) {
                    String useraccno = accno.getText().toString();
                    String username = name.getText().toString();
                    String uservcnumber = vcnumber.getText().toString();
                    String usercarno = cardno.getText().toString();
                    String usercardty = cardty.getText().toString();
                    String usermounthlyin = mounthlyin.getText().toString();
                    String useraddress = address.getText().toString();

                    usermodel usermodel = new usermodel(useraccno, username, uservcnumber, usercarno, usercardty, usermounthlyin, useraddress);
                    dbHandler.insertUser(usermodel);
                    clicked = true;
                    Toast.makeText(Insert.this, "Saved details", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Insert.this,"Validation fails", Toast.LENGTH_SHORT).show();
                }
            }

        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(Insert.this);
                builder.setTitle("Message");
                builder.setMessage(" Save your details and confirm your arrangement ");

                builder.setPositiveButton("next", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String useraccno = accno.getText().toString();
                        String username = name.getText().toString();
                        String uservcnumber = vcnumber.getText().toString();
                        String usercarno = cardno.getText().toString();
                        String usercardty = cardty.getText().toString();
                        String usermounthlyin = mounthlyin.getText().toString();
                        String useraddress = address.getText().toString();

                        //check All the details are completed
                        if ((useraccno.isEmpty()) || (username.isEmpty()) || (uservcnumber.isEmpty()) || (usercarno.isEmpty()) || usercardty.isEmpty() || (usermounthlyin.isEmpty()) || (useraddress.isEmpty())) {
                            AlertDialog dlg = new AlertDialog.Builder(Insert.this)
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

                                Toast.makeText(Insert.this, "Please save the details", Toast.LENGTH_SHORT).show();
                            } else {

                                //pass values ArrangeResult class
                                Intent intent = new Intent(Insert.this, MainActivity.class);
                                intent.putExtra("name", username);
                                intent.putExtra("accno", useraccno);
                                intent.putExtra("address", useraddress);
                                intent.putExtra("vcnumber", uservcnumber);
                                intent.putExtra("cardno", usercarno);
                                intent.putExtra("cardty", usercardty);
                                intent.putExtra("mounthlyin", usermounthlyin);
                                startActivity(intent);
                            }
                        }
                    }
                });


            }
        });
    }
}
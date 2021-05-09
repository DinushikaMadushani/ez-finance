package com.example.newproject;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class Insert extends AppCompatActivity {

    private EditText accno,name,vcnumber ,cardno,cardty,mounthlyin,address;
    private Button btn1, btn2;
    private Context context;
    private dbconecter dbconecter;
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
        dbconecter = new dbconecter(context);



        //Initialize Validation Style
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        //add Validations name
        awesomeValidation.addValidation(this,R.id.uname, RegexTemplate.NOT_EMPTY,R.string.invalid_name);
        //add Validation nic
        awesomeValidation.addValidation(this,R.id.accno1,"[0-9]{10}",R.string.invalid_account);
        //add Validation phone number
        awesomeValidation.addValidation(this,R.id.job,"[0-9]{10}",R.string.invalid_amount);


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
                    Toast.makeText(ArrangeFinance.this,"Validation fails", Toast.LENGTH_SHORT).show();
                }
            }

        });

            }
        });

    }
}
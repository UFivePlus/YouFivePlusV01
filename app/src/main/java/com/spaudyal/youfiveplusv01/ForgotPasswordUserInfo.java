package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ForgotPasswordUserInfo extends AppCompatActivity {

    //back button
    private android.widget.ImageView backButton;

    //email inputText
    private EditText emailText;

    //phone number input text
    private EditText phoneText;

    //string value
    private String emailVal, phoneVall;


    //reset button
    private Button reset;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password_user_info);

        //back button
        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBack();
            }
        });

        emailText = findViewById(R.id.emailText);
        phoneText = findViewById(R.id.phoneText);
        reset = findViewById(R.id.button8);


        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                emailVal = emailText.getText().toString().replaceAll("\\s+","");
                phoneVall = phoneText.getText().toString().replaceAll("\\s+","");
                if(emailVal.equals("") && !phoneVall.equals("")){
                    gotoPhoneVerification(phoneVall);
                }else if(!emailVal.equals("") && phoneVall.equals("")){
                    gotoEmailVerification(emailVal);
                }else if(!emailVal.equals("") && !phoneVall.equals("")){
                    //display a toast saying enter only one field
                    Toast.makeText(getApplicationContext(),
                            "Enter phone number OR email (Only One)", Toast.LENGTH_LONG).show();
                }else{
                    //display a toast saying enter atleast one field.
                    Toast.makeText(getApplicationContext(),
                            "Enter atleast email address or phone number", Toast.LENGTH_LONG).show();
                }
            }
        });


    }

    //method that opens up signup Page
    protected void goBack(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    protected void gotoPhoneVerification(String phNumber){
        Intent intent = new Intent(this, PhoneVerification.class);
        intent.putExtra("message", phNumber);
        startActivity(intent);
    }

    protected void gotoEmailVerification(String email){
        Intent intent = new Intent(this, EmailVerification.class);
        intent.putExtra("message", email);
        startActivity(intent);
    }



}


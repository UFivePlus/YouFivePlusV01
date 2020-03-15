package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    //button for opening up the sign up Page
    private Button registerButton;

    //button for login
    private Button loginButton;

    //button for forgot password
    private TextView forgotPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //code to open sign up page once clicked on the signup textView
        registerButton = findViewById(R.id.email_signup_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignUpPage();
            }
        });

        //code to open 5 options menu from the login button
        loginButton = findViewById(R.id.email_login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAfterLoginActivityPage();
            }
        });

        //code for forgot password
        forgotPassword = findViewById(R.id.textViewForgotPassword);
        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openForgotPasswordLayout();
            }
        });


    }

    //method that opens up signup Page
    protected void openSignUpPage(){
        Intent intent = new Intent(this, RegistrationActivity.class);
        startActivity(intent);
    }

    //method that opens up after login options Page
    protected void openAfterLoginActivityPage(){
        Intent intent = new Intent(this, AfterLoginScreen.class);
        startActivity(intent);
    }

    //method for opening forgot password
    protected void openForgotPasswordLayout(){
        Intent intent = new Intent(this, ForgotPasswordUserInfo.class);
        startActivity(intent);
    }

}

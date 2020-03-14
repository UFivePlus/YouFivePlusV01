package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RegistrationActivity extends AppCompatActivity {

    private CheckBox termsAndCond;

    private Button signUpButton;

    private TextView backLogIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        signUpButton = findViewById(R.id.btn_signup);

        backLogIn = findViewById(R.id.link_login);

        termsAndCond = findViewById(R.id.terms_check_box);
        termsAndCond.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
            {
                if ( isChecked )
                {
                    signUpButton.setEnabled(true);

                }else{
                    signUpButton.setEnabled(false);
                }

            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openWelcomeScreen();
            }
        });

        backLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goBackToLogIn();
            }
        });



    }

    protected void openWelcomeScreen(){
        Intent intent = new Intent(this, WelcomeToU5.class);
        startActivity(intent);
    }

    protected void goBackToLogIn(){
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
    }
}

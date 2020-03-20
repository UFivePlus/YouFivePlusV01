package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class UFiveOptionsActivity extends AppCompatActivity {

    private ImageView imageButtonPlus;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ufive_options);

        //code for the profile.
        ImageView imageButtonU = (ImageView) findViewById(R.id.U);
        imageButtonU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Code for the profile
                openProfile();
            }
        });

        ImageView imageButtonFive = findViewById(R.id.Five);
        imageButtonFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFiveOptions();
            }
        });



    }

    //method that opens up FiveOptions Page
    protected void openFiveOptions(){
        Intent intent = new Intent(this, FiveOptions.class);
        startActivity(intent);
    }

    protected void openProfile(){
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}

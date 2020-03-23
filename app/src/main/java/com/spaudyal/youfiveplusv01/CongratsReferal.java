package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class CongratsReferal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats_referal);

        Handler mHandler = new Handler();
        mHandler.postDelayed(new Runnable() {

            @Override
            public void run() {
               openCongratsBarCode();
            }

        }, 3000L);
    }

    protected void openCongratsBarCode(){
        Intent intent = new Intent(this, CongratsBarCodeDisplay.class);
        startActivity(intent);
    }
}

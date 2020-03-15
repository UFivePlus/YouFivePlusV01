package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PhoneVerification extends AppCompatActivity {

    private TextView text, timer;
    private int counterSec = 59, counterMin = 9;
    private String display;
    private ImageView backBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_verification);

        backBtn = findViewById(R.id.imageView4);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackForgotPassword();
            }
        });


//        text = findViewById(R.id.textView16);
//        timer = findViewById(R.id.timer);
//
//        Intent intent = getIntent();
//        String str = intent.getStringExtra("message");
//        text.setText(str);
//
//        while(counterMin >= 0){
//            new CountDownTimer(60000,1000) {
//                @Override
//                public void onTick(long millisUntilFinished) {
//                    display = counterMin + ":" + counterSec;
//                    timer.setText(display);
//                    counterSec--;
//                }
//                @Override
//                public void onFinish() {
//                    counterMin--;
//                    display = counterMin + ":" + counterSec;
//                    timer.setText(display);
//                }
//            }.start();
//        }

    }

    protected void goBackForgotPassword(){
        Intent intent = new Intent(this, ForgotPasswordUserInfo.class);
        startActivity(intent);
    }
}

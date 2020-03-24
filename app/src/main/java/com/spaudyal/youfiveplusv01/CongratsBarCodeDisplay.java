package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class CongratsBarCodeDisplay extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        final TextView textView;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_congrats_bar_code_display);

        textView = findViewById(R.id.testText);
        Intent intent = getIntent();
        String str = intent.getStringExtra("EdiTtEXTvALUE");
        //Log.d("SUper", str.toString());
        textView.setText(str);
        textView.setTextColor(Color.RED);
        //imageView.setImageBitmap(bitmap);
    }
}

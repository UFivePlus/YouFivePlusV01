package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ncorti.slidetoact.SlideToActView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeToU5 extends AppCompatActivity {

    private TextView youTubeLink;

    private SlideToActView slideToReferalCodeGen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_to_u5);

        youTubeLink = findViewById(R.id.textView32);
        youTubeLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openYouTubeLink();
            }
        });

        slideToReferalCodeGen = findViewById(R.id.slideToActView4);
        slideToReferalCodeGen.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(SlideToActView slideToActView) {
                openReferalCodeGen();
            }
        });
    }

    protected void openYouTubeLink(){
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
        startActivity(browserIntent);
    }

    protected void openReferalCodeGen(){
        Intent intent = new Intent(this, GetRefText.class);
        startActivity(intent);
    }
}

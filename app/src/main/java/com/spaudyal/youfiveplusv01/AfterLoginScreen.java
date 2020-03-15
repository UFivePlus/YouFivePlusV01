package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.ncorti.slidetoact.SlideToActView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AfterLoginScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_login_screen);

        ImageView mainLogo = findViewById(R.id.imageView8);
        mainLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openUFiveOption();
            }
        });

        final SlideToActView slide = findViewById(R.id.slideToActView6);
        slide.setOnSlideCompleteListener(new SlideToActView.OnSlideCompleteListener() {
            @Override
            public void onSlideComplete(@NonNull SlideToActView view) {
                openU5Gallery();
            }
        });



    }

    protected void openU5Gallery(){
        Intent intent = new Intent(this, U5Gallery.class);
        startActivity(intent);
    }

    protected void openUFiveOption(){
        Intent intent = new Intent(this, UFiveOptionsActivity.class);
        startActivity(intent);
    }
}
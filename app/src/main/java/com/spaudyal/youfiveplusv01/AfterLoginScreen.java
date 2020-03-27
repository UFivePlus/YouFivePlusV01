package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.sanojpunchihewa.glowbutton.GlowButton;

import androidx.appcompat.app.AppCompatActivity;

public class AfterLoginScreen extends AppCompatActivity {

    protected GlowButton fiveBuss, uPlus ;

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

        fiveBuss = findViewById(R.id.glowButton2);
        fiveBuss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openFiveBisOptions();
            }
        });

        uPlus = findViewById(R.id.glowButton);
        uPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPlusSide();
            }
        });



    }

    protected void openPlusSide(){
        Intent intent = new Intent(this, PlusSide.class);
        startActivity(intent);
    }

    protected void openFiveBisOptions(){
        Intent intent = new Intent(this, FiveOptions.class);
        startActivity(intent);
    }

    protected void openUFiveOption(){
        Intent intent = new Intent(this, UFiveOptionsActivity.class);
        startActivity(intent);
    }
}
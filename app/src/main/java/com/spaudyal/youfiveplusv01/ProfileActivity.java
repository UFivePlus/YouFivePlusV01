package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {

    private Button transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        transaction = findViewById(R.id.button5);
        transaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransaction();
            }
        });
    }

    protected void openTransaction(){
        Intent intent = new Intent(this, CosmePay.class);
        startActivity(intent);
    }


}

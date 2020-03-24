package com.spaudyal.youfiveplusv01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class GetRefText extends Activity {

    EditText SendValue;
    Button SendEditTextValue;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_ref_text);

        SendEditTextValue = (Button)findViewById(R.id.button1);
        SendEditTextValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendData();
            }
        });

    }

    protected void sendData(){
        SendValue = (EditText)findViewById(R.id.editText1);
        intent = new Intent(getApplicationContext(),GenQRCode.class);
        intent.putExtra("EdiTtEXTvALUE", SendValue.getText().toString());
        startActivity(intent);
    }
}
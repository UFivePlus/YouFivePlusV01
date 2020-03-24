package com.spaudyal.youfiveplusv01;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import java.util.Objects;

import androidx.appcompat.app.AppCompatActivity;

public class QRCodeGenerator extends AppCompatActivity {

    private final static int WHITE = 0xFFFFFFFF;
    private final static int BLACK = 0xFF000000;
    private final static int WIDTH = 400;
    private final static int HEIGHT = 400;
    private TextInputEditText editText;
    private Button genButt;
    private String refCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrcode_generator);


        final ImageView imageView = findViewById(R.id.myImage);
        editText = findViewById(R.id.textForCode);
        genButt = findViewById(R.id.genButt);
        refCode = "";

        genButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//
//                String STR = Objects.requireNonNull(editText.getText()).toString();
//                disableEditText(editText);
//                try {
//
//                    Bitmap bitmap = encodeAsBitmap(STR);
//                    imageView.setImageBitmap(bitmap);
//                    sendQR(bitmap);
//                    //send this bitmap image to next activity right here.
//                } catch (WriterException ex) {
//                    ex.printStackTrace();
//                }
                refCode =  Objects.requireNonNull(editText.getText()).toString();
                Intent intent = new Intent(getApplicationContext(), CongratsBarCodeDisplay.class);
                intent.putExtra("msg", refCode);
                //sendSTR(refCode);
                disableEditText(editText);
                openCongratsReferal();
            }
        });


    }
    //disable editText after you hit generate.
    private void disableEditText(EditText editText) {
        editText.setFocusable(false);
        editText.setEnabled(false);
        editText.setCursorVisible(false);
        editText.setKeyListener(null);
        editText.setBackgroundColor(Color.TRANSPARENT);
    }

    protected void sendSTR(String str){
        Intent intent = new Intent(getApplicationContext(), CongratsBarCodeDisplay.class);
        intent.putExtra("msg", str);
    }

    protected void openCongratsReferal(){
        Intent intent = new Intent(this, CongratsReferal.class);
        startActivity(intent);
    }

    protected Bitmap encodeAsBitmap(String str) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(str,
                    BarcodeFormat.QR_CODE, WIDTH, HEIGHT, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }

        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ? BLACK : WHITE;
            }
        }

        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, w, 0, 0, w, h);
        return bitmap;
    }
}


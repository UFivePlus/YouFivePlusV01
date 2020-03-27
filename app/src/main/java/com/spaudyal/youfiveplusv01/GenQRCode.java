package com.spaudyal.youfiveplusv01;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class GenQRCode extends Activity {

    protected String refCode = "";
    protected TextView receive;
    protected ImageView qrDisplay, closeButton, shareButton;
    protected Bitmap bitmap;


    //hardcoded bitmap values
    protected final static int WHITE = 0xFFFFFFFF;
    protected final static int BLACK = 0xFF000000;
    protected final static int WIDTH = 800;
    protected final static int HEIGHT = 800;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_gen_qrcode);

        qrDisplay = findViewById(R.id.qrDisplay);
        receive = findViewById(R.id.textView1);
        closeButton = findViewById(R.id.imageView13);
        shareButton = findViewById(R.id.shareButton);

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takeToAfterLoginScreen();
            }
        });

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                String shareBody = "Here is the share content body";
                sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Subject Here");
                sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));
            }
        });

        refCode = getIntent().getStringExtra("EdiTtEXTvALUE");
        try {
            bitmap = encodeAsBitmap(refCode);
            receive.setText(refCode);
            Bitmap overlay = BitmapFactory.decodeResource(getResources(), R.drawable.main_logo);
            mergeBitmaps(overlay,bitmap);
            qrDisplay.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }

    protected void takeToAfterLoginScreen(){
        Intent intent = new Intent(this, AfterLoginScreen.class);
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

    protected Bitmap mergeBitmaps(Bitmap overlay, Bitmap bitmap) {

        int height = bitmap.getHeight();
        int width = bitmap.getWidth();

        Bitmap combined = Bitmap.createBitmap(width, height, bitmap.getConfig());
        Canvas canvas = new Canvas(combined);
        int canvasWidth = canvas.getWidth();
        int canvasHeight = canvas.getHeight();

        canvas.drawBitmap(bitmap, new Matrix(), null);

        int centreX = (canvasWidth  - overlay.getWidth()) /2;
        int centreY = (canvasHeight - overlay.getHeight()) /2 ;
        canvas.drawBitmap(overlay, centreX, centreY, null);

        return combined;
    }

}

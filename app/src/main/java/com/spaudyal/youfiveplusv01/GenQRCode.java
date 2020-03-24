package com.spaudyal.youfiveplusv01;

import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

public class GenQRCode extends Activity {

    protected String refCode = "";
    protected TextView receive;
    protected ImageView qrDisplay;
    protected Bitmap bitmap;


    //hardcoded bitmap values
    protected final static int WHITE = 0xFFFFFFFF;
    protected final static int BLACK = 0xFF000000;
    protected final static int WIDTH = 400;
    protected final static int HEIGHT = 400;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_qrcode);

        qrDisplay = findViewById(R.id.qrDisplay);
        receive = findViewById(R.id.textView1);

        refCode = getIntent().getStringExtra("EdiTtEXTvALUE");
        try {
            bitmap = encodeAsBitmap(refCode);
            qrDisplay.setImageBitmap(bitmap);
            receive.setText(refCode);
        } catch (WriterException e) {
            e.printStackTrace();
        }

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

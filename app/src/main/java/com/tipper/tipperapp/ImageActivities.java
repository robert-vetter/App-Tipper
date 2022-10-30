package com.tipper.tipperapp;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class ImageActivities {

    private Bitmap image;

    public ImageActivities(Bitmap bmp){
        image = bmp;
    }

    public void draw (Canvas canvas){
        canvas.drawBitmap(image, -100, -100, null);
    }
}

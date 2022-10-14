package com.example.kkkkkkkkk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Random;

public class MyDraw extends View {

    public MyDraw(Context context) {
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-12345678);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        int r = 35;
        int ro = 55; // m(20) -> ro(55)
        Random rand = new Random();
        int array[][] = new int[canvas.getHeight() / (r + ro)]
                [canvas.getWidth() / (r + ro)];

        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[0].length; j++){
                array[i][j] = rand.nextInt(255);
            }
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] <= 20) paint.setStyle(Paint.Style.STROKE);
                else paint.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawCircle(j * (r + ro) + ro, i * (r + ro) + ro, r, paint);
            }
        }
    }
}

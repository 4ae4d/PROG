package com.example.kkkkkkkkk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.Random;

public class MyDraw extends View {

    int r = 35;
    int ro = 55; // m(20) -> ro(55)
    int array[][];
    double x1 = 0;
    double y1 = 0;
    double x2 = 0;
    double y2 = 0;
    boolean initial = true;


    public MyDraw(Context context) {
        super(context);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int touch = event.getAction();
        if (touch == MotionEvent.ACTION_DOWN){
            x1 = event.getX();
            y1 = event.getY();
        }
        if (touch == MotionEvent.ACTION_UP){
            x2 = event.getX();
            y2 = event.getY();
        }

        int xx1 = (int) (x1/(ro+r));
        int yy1 = (int) (y1/(ro+r));

        if (array[yy1][xx1] == 0) array[yy1][xx1] = 1;
        else array[yy1][xx1] = 0;
        invalidate();
        return true;
    }

    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(-12345678);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        Random rand = new Random();
        array = new int[canvas.getHeight() / (r + ro)]
                [canvas.getWidth() / (r + ro)];
        if (initial) {
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[0].length; j++) {
                    array[i][j] = rand.nextInt(2);
                }
            }
            initial = false;
        }
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                if (array[i][j] == 0) paint.setStyle(Paint.Style.STROKE);
                else paint.setStyle(Paint.Style.FILL_AND_STROKE);
                canvas.drawCircle(j * (r + ro) + ro, i * (r + ro) + ro, r, paint);
            }
        }
    }
}

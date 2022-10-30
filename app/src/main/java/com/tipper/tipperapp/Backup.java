/*package com.example.appnr03;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.SystemClock;
import android.view.MotionEvent;

import java.util.Random;
import java.util.Timer;

public class Backup {
    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
        Paint paint = new Paint();
        Timer gameTimer = new Timer();

        paint.setTextSize(70);
        paint.setColor(Color.rgb(0, 0, 0));
        imageActivities.draw(canvas);
        Random rand = new Random();

        int upperbound = 250;
        int lowerbound = 100;
        long timer = 1000;

        try {
            //while (working) {
            if (score >= 5) {
                timer = timer - 100;
            }
            if (score >= 10) {
                timer = timer - 100;
            }
            if (score >= 15) {
                timer = timer - 100;
            }
            if (score >= 20) {
                timer = timer - 100;
            }
            if (score >= 30) {
                timer = timer - 100;
            }
            if (score >= 40) {
                timer = timer - 50;
            }
            if (score >= 50) {
                timer = timer - 50;
            }
            if (score >= 60) {
                timer = timer - 20;
            }
            if (score >= 70) {
                timer = timer - 20;
            }
            if (score >= 80) {
                timer = timer - 20;
            }
            if (score >= 90) {
                timer = timer - 10;
            }
            if (score >= 100) {
                timer = timer - 10;
            }
            paint.setColor(Color.rgb(0, 0, 0));
            canvas.drawText("Your score: ", 100, 100, paint);
            canvas.drawText("Your mistakes: ", 100, 200, paint);
            Thread.sleep(timer);
            radius = (int) ((Math.random() * (upperbound - lowerbound)) + lowerbound);
            cx = (int) ((Math.random() * (getWidth() - radius - 300)) + radius);
            cy = (int) ((Math.random() * (getHeight() - radius - 400)) + radius + 200);
            colorAttribute = rand.nextInt() % 2;
            if (colorAttribute == 0) {
                paint.setColor(Color.rgb(250, 0, 0));
                canvas.drawCircle(cx, cy, radius, paint);
                paint.setColor(Color.rgb(0, 0, 0));
                canvas.drawText(Integer.toString(score), 700, 100, paint);
                canvas.drawText(Integer.toString(mistake), 700, 200, paint);
            } else {
                paint.setColor(Color.rgb(0, 250, 0));
                canvas.drawCircle(cx, cy, radius, paint);
                paint.setColor(Color.rgb(0, 0, 0));
                canvas.drawText(Integer.toString(score), 700, 100, paint);
                canvas.drawText(Integer.toString(mistake), 700, 200, paint);
            }
            //}
        } catch (Exception e){
            e.printStackTrace();}


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 300){
            return false;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        if ((event.getX() <= cx + radius && event.getX() >= cx - radius) && (event.getY() >= cy - radius && event.getY() <= cy + radius) ){
            if (colorAttribute == 0){

                score--;
                if (score < 0){
                    score = 0;
                }
                mistake=mistake+1;

            } else {
                score++;
            }
        }
        return super.onTouchEvent(event);


    }

}


public class SecondActivity extends Activity {
    GamePanel gamePanel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(new GamePanel(this));

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                startActivity(intent);
                System.exit(0);

            }
        }, 120000);
        }


        public void onBackPressed(){
            System.exit(0);
        }

    }*/

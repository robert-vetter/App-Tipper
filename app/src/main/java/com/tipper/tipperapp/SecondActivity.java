package com.tipper.tipperapp;


import android.app.Activity;

import android.content.Intent;
import android.graphics.Point;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import android.os.Handler;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ThreadLocalRandom;


public class SecondActivity extends Activity {
    private Timer timer = new Timer();
    private Handler handler = new Handler();
    private Random random = new Random();

    private TextView scoreLabel, TapToStartLabel, mistakeLabel;
    private ImageView red, green, red1, green1;
    private int whichColor, whichSide, screenHeight, screenWidth;
    private int whichSideRed, whichSideGreen, whichSideGreen1, whichSideRed1, whichSideRG1, red1Orgreen1;

    private int velocityX, velocityY;

    private boolean taptostart_act = false;

    private int score, mistake;
    private int[] arr = new int[10000];
    private int counter = -1;
    private boolean clicked = false;
    private long mLastClickTime = 0;
    private int time = 1000;

    private int position;

    private int greenX, greenY, redX, redY, greenX1, greenY1, redX1, redY1;

    private Button pauseButton;
    private boolean pause_act = false;

    private SoundPlayer soundPlayer;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_second);
        soundPlayer = new SoundPlayer(this);

        scoreLabel = findViewById(R.id.scoreLabel);
        mistakeLabel = findViewById(R.id.mistakeLabel);
        TapToStartLabel = findViewById(R.id.TapToStartLabel);
        green = findViewById(R.id.green);
        red = findViewById(R.id.red);
        green1 = findViewById(R.id.green1);
        red1 = findViewById(R.id.red1);

        pauseButton = (Button) findViewById(R.id.pauseButton);

        //Initial positions
        green.setX(-500);
        green.setY(-500);
        red.setX(-500);
        red.setY(-500);
        green1.setX(-500);
        green1.setY(-500);
        red1.setX(-500);
        red.setY(-500);

        WindowManager windowManager = getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        screenHeight = size.y;
        screenWidth = size.x;

        //Get Spinner position
        position = getIntent().getIntExtra("POSITION", 0);


    }

        public void newCircle(){
            if (position==0){
                whichColor = random.nextInt() % 2;
                if (whichColor == 0) {
                    clicked = false;
                    whichSide = ThreadLocalRandom.current().nextInt(0, 4);
                    red.setVisibility(View.INVISIBLE);
                    green.setVisibility(View.VISIBLE);
                    if (whichSide == 0) {
                        greenX = 0;
                        greenY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        green.setX(greenX);
                        green.setY(greenY);
                    }
                    if (whichSide == 1) {
                        greenY = 0;
                        greenX = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                        green.setX(greenX);
                        green.setY(greenY);
                    }
                    if (whichSide == 2) {
                        greenX = screenWidth - 200;
                        greenY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        green.setX(greenX);
                        green.setY(greenY);
                    }
                    if (whichSide == 3) {
                        greenX = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                        greenY = screenHeight - 200;
                        green.setX(greenX);
                        green.setY(greenY);
                    }

                } else {
                    whichSide = ThreadLocalRandom.current().nextInt(0, 4);
                    green.setVisibility(View.INVISIBLE);
                    red.setVisibility(View.VISIBLE);
                    if (whichSide == 0) {
                        redX = 0;
                        redY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        red.setX(redX);
                        red.setY(redY);
                    }
                    if (whichSide == 1) {
                        redY = 0;
                        redX = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                        red.setX(redX);
                        red.setY(redY);
                    }
                    if (whichSide == 2) {
                        redX = screenWidth - 200;
                        redY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        red.setX(redX);
                        red.setY(redY);
                    }
                    if (whichSide == 3) {
                        redY = screenHeight - 200;
                        redX = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                        red.setX(redX);
                        red.setY(redY);
                    }
                }
            }
            if (position==1){
                whichSideGreen = ThreadLocalRandom.current().nextInt(0, 4);
                whichSideRed = ThreadLocalRandom.current().nextInt(0, 4);
                red.setVisibility(View.VISIBLE);
                green.setVisibility(View.VISIBLE);
                clicked = false;
                if (whichSideGreen==0){
                    greenX = 0;
                    greenY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideGreen==1){
                    greenY = 0;
                    greenX = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideGreen==2){
                    greenX = screenWidth - 200;
                    greenY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideGreen==3){
                    greenX = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                    greenY = screenHeight - 200;
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideRed==0){
                    redX = 0;
                    redY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    red.setX(redX);
                    red.setY(redY);
                }
                if (whichSideRed ==1){
                    redY = 0;
                    redX = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                    red.setX(redX);
                    red.setY(redY);
                }
                if (whichSideRed==2){
                    redX = screenWidth - 200;
                    redY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    red.setX(redX);
                    red.setY(redY);
                }
                if (whichSideRed==3){
                    redY = screenHeight - 200;
                    redX = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                    red.setX(redX);
                    red.setY(redY);
                }


            }
            if (position==2){
                whichSideGreen = ThreadLocalRandom.current().nextInt(0, 4);
                whichSideRed = ThreadLocalRandom.current().nextInt(0, 4);
                whichSideRG1 = ThreadLocalRandom.current().nextInt(0, 4);
                red1Orgreen1 = ThreadLocalRandom.current().nextInt(0, 2);
                red.setVisibility(View.VISIBLE);
                green.setVisibility(View.VISIBLE);
                if (red1Orgreen1==0){
                    green1.setVisibility(View.VISIBLE);
                    red1.setVisibility(View.INVISIBLE);
                } else {
                    green1.setVisibility(View.INVISIBLE);
                    red1.setVisibility(View.VISIBLE);
                }

                clicked = false;
                if (whichSideGreen==0){
                    greenX = 0;
                    greenY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideGreen==1){
                    greenY = 0;
                    greenX = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideGreen==2){
                    greenX = screenWidth - 200;
                    greenY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideGreen==3){
                    greenX = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                    greenY = screenHeight - 200;
                    green.setX(greenX);
                    green.setY(greenY);
                }
                if (whichSideRed==0){
                    redX = 0;
                    redY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    red.setX(redX);
                    red.setY(redY);
                }
                if (whichSideRed ==1){
                    redY = 0;
                    redX = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                    red.setX(redX);
                    red.setY(redY);
                }
                if (whichSideRed==2){
                    redX = screenWidth - 200;
                    redY = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                    red.setX(redX);
                    red.setY(redY);
                }
                if (whichSideRed==3){
                    redY = screenHeight - 200;
                    redX = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                    red.setX(redX);
                    red.setY(redY);
                }
                if (red1Orgreen1 == 0){
                    //green
                    if (whichSideRG1 == 0){
                        greenX1 = 0;
                        greenY1 = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        green1.setX(greenX1);
                        green1.setY(greenY1);
                    }
                    if (whichSideRG1 == 1){
                        greenY1 = 0;
                        greenX1 = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                        green1.setX(greenX1);
                        green1.setY(greenY1);
                    }
                    if (whichSideRG1 == 2){
                        greenX1 = screenWidth - 200;
                        greenY1 = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        green1.setX(greenX1);
                        green1.setY(greenY1);
                    }
                    if (whichSideRG1 == 3){
                        greenX1 = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                        greenY1 = screenHeight - 200;
                        green1.setX(greenX1);
                        green1.setY(greenY1);
                    }
                } else {
                    //red
                    if (whichSideRG1 == 0){
                        redX1 = 0;
                        redY1 = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        red1.setX(redX1);
                        red1.setY(redY1);
                    }
                    if (whichSideRG1 == 1){
                        redY1 = 0;
                        redX1 = ThreadLocalRandom.current().nextInt(180, screenWidth - 300);
                        red1.setX(redX1);
                        red1.setY(redY1);
                    }
                    if (whichSideRG1 == 2){
                        redX1 = screenWidth - 200;
                        redY1 = ThreadLocalRandom.current().nextInt(100, screenHeight - 300);
                        red1.setX(redX1);
                        red1.setY(redY1);
                    }
                    if (whichSideRG1 == 3){
                        redX1 = ThreadLocalRandom.current().nextInt(100, screenWidth - 300);
                        redY1 = screenHeight - 200;
                        red1.setX(redX1);
                        red1.setY(redY1);
                    }
                }
            }

        }

        public void changePos(){
            velocityX = 7;
            velocityY = 9;
            if (position==0){
                if (whichColor==0){
                    if (whichSide == 0){
                        greenX += velocityX;
                        green.setX(greenX);
                    }
                    if (whichSide == 1){
                        greenY += velocityY;
                        green.setY(greenY);
                    }
                    if (whichSide == 2){
                        greenX -= velocityX;
                        green.setX(greenX);
                    }
                    if (whichSide == 3){
                        greenY -= velocityY;
                        green.setY(greenY);
                    }

                } else {
                    if (whichSide == 0){
                        redX += velocityX;
                        red.setX(redX);
                    }
                    if (whichSide == 1){
                        redY += velocityY;
                        red.setY(redY);
                    }
                    if (whichSide == 2){
                        redX -= velocityX;
                        red.setX(redX);
                    }
                    if (whichSide == 3){
                        redY -= velocityY;
                        red.setY(redY);
                    }

                }
            }
            if (position==1){
                if (whichSideGreen == 0){
                    greenX += velocityX;
                    green.setX(greenX);
                }
                if (whichSideGreen == 1){
                    greenY += velocityY;
                    green.setY(greenY);
                }
                if (whichSideGreen == 2){
                    greenX -= velocityX;
                    green.setX(greenX);
                }
                if (whichSideGreen == 3){
                    greenY -= velocityY;
                    green.setY(greenY);
                }
                if (whichSideRed == 0){
                    redX += velocityX;
                    red.setX(redX);
                }
                if (whichSideRed == 1){
                    redY += velocityY;
                    red.setY(redY);
                }
                if (whichSideRed == 2){
                    redX -= velocityX;
                    red.setX(redX);
                }
                if (whichSideRed == 3){
                    redY -= velocityY;
                    red.setY(redY);
                }
            }
            if (position==2){
                if (whichSideGreen == 0){
                    greenX += velocityX;
                    green.setX(greenX);
                }
                if (whichSideGreen == 1){
                    greenY += velocityY;
                    green.setY(greenY);
                }
                if (whichSideGreen == 2){
                    greenX -= velocityX;
                    green.setX(greenX);
                }
                if (whichSideGreen == 3){
                    greenY -= velocityY;
                    green.setY(greenY);
                }
                if (whichSideRed == 0){
                    redX += velocityX;
                    red.setX(redX);
                }
                if (whichSideRed == 1){
                    redY += velocityY;
                    red.setY(redY);
                }
                if (whichSideRed == 2){
                    redX -= velocityX;
                    red.setX(redX);
                }
                if (whichSideRed == 3){
                    redY -= velocityY;
                    red.setY(redY);
                }
                if (red1Orgreen1 == 0){
                    if (whichSideRG1 == 0){
                        greenX1 += velocityX;
                        green1.setX(greenX1);
                    }
                    if (whichSideRG1 == 1){
                        greenY1 += velocityY;
                        green1.setY(greenY1);
                    }
                    if (whichSideRG1 == 2){
                        greenX1 -= velocityX;
                        green1.setX(greenX1);
                    }
                    if (whichSideRG1 == 3){
                        greenY1 -= velocityY;
                        green1.setY(greenY1);
                    }
                } else {
                    if (whichSideRG1 == 0){
                        redX1 += velocityX;
                        red1.setX(redX1);
                    }
                    if (whichSideRG1 == 1){
                        redY1 += velocityY;
                        red1.setY(redY1);
                    }
                    if (whichSideRG1 == 2){
                        redX1 -= velocityX;
                        red1.setX(redX1);
                    }
                    if (whichSideRG1 == 3){
                        redY1 -= velocityY;
                        red1.setY(redY1);
                    }
                }

            }

        }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (!taptostart_act){
            taptostart_act = true;
            TapToStartLabel.setVisibility(View.GONE);
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                counter++;
                                arr[counter]=whichColor;
                                if (counter>=1){
                                    if (arr[counter]==0 && !clicked){
                                        notClicked();
                                        soundPlayer.playRedBallSound();
                                    }
                                }
                                newCircle();
                            }

                        });
                    }
                }, 0, 1860);

            timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                changePos();
                            }
                        });
                    }
                    }, 0, 7);
        }

        else {
                if ((event.getX() <= greenX + 300 && event.getX() >= greenX)
                        && (event.getY() <= greenY + 425 && event.getY() >= greenY)) {
                    if (SystemClock.elapsedRealtime() - mLastClickTime < 100) {
                        return false;
                    }
                    clicked = true;
                    soundPlayer.playGreenBallSound();
                    mLastClickTime = SystemClock.elapsedRealtime();
                    score++;
                    scoreLabel.setText("Score: " + score);
                    green.setVisibility(View.INVISIBLE);

                }
                if ((event.getX() <= redX + 300 && event.getX() >= redX)
                        && (event.getY() >= redY && event.getY() <= redY + 425)) {
                    if (SystemClock.elapsedRealtime() - mLastClickTime < 100) {
                        return false;
                    }
                    soundPlayer.playRedBallSound();
                    mLastClickTime = SystemClock.elapsedRealtime();
                    soundPlayer.playRedBallSound();
                    red.setVisibility(View.INVISIBLE);
                    mistake++;
                    mistakeLabel.setText("Mistakes: " + mistake + " / 5");

                    if (mistake>=5){
                        if (timer != null){
                            timer.cancel();
                            timer = null;
                        }
                        soundPlayer.playOverSound();
                        Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                        intent.putExtra("SCORE", score);
                        startActivity(intent);
                    }


                }
            if ((event.getX() <= redX1 + 300 && event.getX() >= redX1)
                    && (event.getY() >= redY1 && event.getY() <= redY1 + 425)) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 100) {
                    return false;
                }
                soundPlayer.playRedBallSound();
                mLastClickTime = SystemClock.elapsedRealtime();
                soundPlayer.playRedBallSound();
                red1.setVisibility(View.INVISIBLE);
                mistake++;
                mistakeLabel.setText("Mistakes: " + mistake + " / 5");

                if (mistake>=5){
                    if (timer != null){
                        timer.cancel();
                        timer = null;
                    }
                    soundPlayer.playOverSound();
                    Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                    intent.putExtra("SCORE", score);
                    startActivity(intent);
                }


            }
            if ((event.getX() <= greenX1 + 300 && event.getX() >= greenX1)
                    && (event.getY() <= greenY1 + 425 && event.getY() >= greenY1)) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 100) {
                    return false;
                }
                clicked = true;
                soundPlayer.playGreenBallSound();
                mLastClickTime = SystemClock.elapsedRealtime();
                score++;
                scoreLabel.setText("Score: " + score);
                green1.setVisibility(View.INVISIBLE);

            }




        }




        return super.onTouchEvent(event);
    }

    public void notClicked(){
        mistake++;
        clicked = false;
        mistakeLabel.setText("Mistakes: " + mistake + " / 5");
        if (mistake>=5){
            if (timer != null){
                timer.cancel();
                timer = null;
            }
            soundPlayer.playOverSound();
            Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
            intent.putExtra("SCORE", score);
            startActivity(intent);
        }


    }

    public void pausePushed(View view){
        if (pause_act == false){
            pause_act = true;
            timer.cancel();
            timer=null;

            pauseButton.setText("START");

        } else {
            pause_act = false;
            pauseButton.setText("PAUSE");

            timer = new Timer();

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            newCircle();
                        }
                    });
                }
            }, 0, 1000);

            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            changePos();
                        }
                    });
                }
            }, 0, 5);
        }
    }

    public int makeFaster(){
        time = 1000;
        if (score >= 5) {
            time = time - 500;
            return time;
        }
        if (score >= 10) {
            time = time - 100;
            return time;
        }
        if (score >= 15) {
            time = time - 100;
            return time;
        }
        if (score >= 20) {
            time = time - 100;
            return time;
        }
        if (score >= 30) {
            time = time - 100;
            return time;
        }
        if (score >= 40) {
            time = time - 50;
            return time;
        }
        if (score >= 50) {
            time = time - 50;
            return time;
        }
        if (score >= 60) {
            time = time - 20;
            return time;
        }
        if (score >= 70) {
            time = time - 20;
            return time;
        }
        if (score >= 80) {
            time = time - 20;
            return time;
        }
        if (score >= 90) {
            time = time - 10;
            return time;
        }
        if (score >= 100) {
            time = time - 10;
            return time;
        }
        return time;
    }
}
















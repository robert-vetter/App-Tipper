package com.tipper.tipperapp;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;

public class SoundPlayer {

    private AudioAttributes audioAttributes;
    private static SoundPool soundPool;
    private static int redballSound, greenballSound, overSound;

    public SoundPlayer(Context context){

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            audioAttributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .build();
            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(audioAttributes)
                    .setMaxStreams(2)
                    .build();
        } else {
            soundPool = new SoundPool(2, AudioManager.STREAM_MUSIC, 0);
        }

        redballSound = soundPool.load(context, R.raw.redball, 1);
        greenballSound = soundPool.load(context, R.raw.greenball, 1);
        overSound = soundPool.load(context, R.raw.over, 1);
    }

    public void playGreenBallSound(){
        soundPool.play(greenballSound, 1.0f, 1.0f, 1, 0, 1.0f);
    }

    public void playRedBallSound(){soundPool.play(redballSound, 1.0f, 1.0f, 1, 0, 1.0f);}

    public void playOverSound(){soundPool.play(overSound, 1.0f, 1.0f, 1, 0, 1.0f);}
}

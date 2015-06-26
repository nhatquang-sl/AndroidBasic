package com.example.nquang.helloworld;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

/**
 * Created by NQuang on 6/4/2015.
 */
public class SplashActivity extends Activity {

    MediaPlayer splashSound;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        splashSound = MediaPlayer.create(this,R.raw.zombie_moan);
        splashSound.start();

        Thread splashTimer = new Thread() {
            public void run() {
                try {
                    sleep(5000);
                    Intent intentMenu = new Intent("com.example.nquang.helloworld.Menu");
                    startActivity(intentMenu);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    finish();
                }
            }
        };
        splashTimer.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        splashSound.release();
    }
}

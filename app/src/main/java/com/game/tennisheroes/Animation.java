package com.game.tennisheroes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;

public class Animation extends AppCompatActivity {
    boolean dr1 = true;
    boolean dr2 = true;
    CountDownTimer ct;
    CountDownTimer ct2;
    CountDownTimer ct3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
       final ImageView iv = findViewById(R.id.imageViews);

     ct = new CountDownTimer(4000, 1000) {
        public void onFinish() {
            Drawable d = getResources().getDrawable(R.drawable.scntwo);
            iv.setImageDrawable(d);
            dr1 = false;
            ct2.start();
        }

        public void onTick(long millisUntilFinished) {
            // millisUntilFinished    The amount of time until finished.
        }
    };
        ct.start();

        ct2 = new CountDownTimer(4000, 1000) {
            public void onFinish() {
                Drawable d2 = getResources().getDrawable(R.drawable.scnthree);
                iv.setImageDrawable(d2);
                dr2 = false;
                ct3.start();
            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        };

         ct3 = new CountDownTimer(4000, 1000) {
            public void onFinish() {
                SharedPreferences prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                boolean animation = false;
                editor.putBoolean("anim",animation);

                finish();
            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        };



}



    }


package com.game.tennisheroes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.util.Timer;

public class Animation extends AppCompatActivity {
    boolean dr1 = true;
    boolean dr2 = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
       final ImageView iv = findViewById(R.id.imageViews);
while (1==1) {
    new CountDownTimer(4000, 1000) {
        public void onFinish() {
            Drawable d = getResources().getDrawable(R.drawable.scntwo);
            iv.setImageDrawable(d);
            dr1 = false;
        }

        public void onTick(long millisUntilFinished) {
            // millisUntilFinished    The amount of time until finished.
        }
    }.start();
    if (!dr1) {

        new CountDownTimer(4000, 1000) {
            public void onFinish() {
                Drawable d2 = getResources().getDrawable(R.drawable.scnthree);
                iv.setImageDrawable(d2);
                dr2 = false;
            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        }.start();
    }
    if (!dr2) {
        new CountDownTimer(4000, 1000) {
            public void onFinish() {
                Intent i = new Intent(getApplicationContext(), HomeScreen.class);
                startActivity(i);
                finish();
            }

            public void onTick(long millisUntilFinished) {
                // millisUntilFinished    The amount of time until finished.
            }
        }.start();
    }
}



    }
}

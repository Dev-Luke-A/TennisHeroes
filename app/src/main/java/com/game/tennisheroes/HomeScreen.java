package com.game.tennisheroes;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeScreen extends AppCompatActivity {
     MediaPlayer mp1;
     MediaPlayer mp;
  String anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       mp = MediaPlayer.create(getApplicationContext(), R.raw.click);

        setContentView(R.layout.activity_home_screen);
       final ImageButton b1 = findViewById(R.id.imageButton1);
       final ImageView iv = findViewById(R.id.imageView122);
        final Animation scaleAnimation = new ScaleAnimation(0.4f, 1, 0.4f, 1,Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new DecelerateInterpolator(1.0f));
        iv.startAnimation(scaleAnimation);
        final Animation scaleAnimation1 = new ScaleAnimation(1f, 1.2f, 1f, 1.2f,Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,0.5f),scaleAnimation3 = new ScaleAnimation(0.7f, 0.8f, 0.7f, 0.8f,Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation1.setDuration(100);
        scaleAnimation1.setFillAfter(true);
        scaleAnimation3.setDuration(100);
        scaleAnimation3.setFillAfter(true);
        final Animation scaleAnimation2 = new ScaleAnimation(1.2f ,1f, 1.2f, 1,Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f),scaleAnimation4 = new ScaleAnimation(0.8f, 0.7f, 0.8f, 0.7f,Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation2.setDuration(100);
        scaleAnimation2.setFillAfter(true);
        scaleAnimation4.setDuration(100);
        scaleAnimation4.setFillAfter(true);
        scaleAnimation1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                iv.startAnimation(scaleAnimation2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        scaleAnimation3.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                b1.startAnimation(scaleAnimation4);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.startAnimation(scaleAnimation1);


            }
        });
        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.hsmusicfinal);
        mp1.setLooping(true);
        mp1.start();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.start();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                finish();

            }
        });

        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {
                while (true) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            ImageButton b12 = findViewById(R.id.imageButton1);
                            b12.startAnimation(scaleAnimation3);

                        }
                    });
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
                }
            };
        Thread myThread = new Thread(myRunnable);
        myThread.start();
    }
    @Override
    protected void onPause() {
        super.onPause();
       mp1.pause();
    }
    @Override
    protected void onResume() {
        super.onResume();
       mp1.start();
    }
    }




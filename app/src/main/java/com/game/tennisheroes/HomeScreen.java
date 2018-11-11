package com.game.tennisheroes;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;

public class HomeScreen extends AppCompatActivity {
     MediaPlayer mp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_home_screen);

       final ImageView iv = findViewById(R.id.imageView122);
        Animation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new DecelerateInterpolator(1.0f));
        iv.startAnimation(scaleAnimation);


        ImageButton button1 = findViewById(R.id.imageButton1);
        iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Animation scaleAnimation1 = new ScaleAnimation(1f, 1.2f, 1f, 1.2f,Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation1.setDuration(100);
                scaleAnimation1.setFillAfter(true);
                final Animation scaleAnimation2 = new ScaleAnimation(1.2f ,1f, 1.2f, 1,Animation.RELATIVE_TO_SELF, 0.5f,
                        Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation2.setDuration(100);
                scaleAnimation2.setFillAfter(true);
                iv.startAnimation(scaleAnimation1);

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

            }
        });
        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.hsmusicfinal);
        mp1.setLooping(true);
        mp1.start();
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final MediaPlayer mp = MediaPlayer.create(getApplicationContext(), R.raw.click);
                mp.start();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                finish();

            }
        });

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


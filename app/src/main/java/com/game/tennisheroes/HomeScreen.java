package com.game.tennisheroes;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.OvershootInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;

public class HomeScreen extends AppCompatActivity {
     MediaPlayer mp1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        ImageView iv = findViewById(R.id.imageView122);
        Animation scaleAnimation = new ScaleAnimation(0, 1, 0, 1,Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(2000);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setInterpolator(new DecelerateInterpolator(1.0f));
        iv.startAnimation(scaleAnimation);

        ImageButton button1 = findViewById(R.id.imageButton1);

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
       mp1.stop();
    }
    @Override
    protected void onResume() {
        super.onResume();
       mp1.start();
    }
    }


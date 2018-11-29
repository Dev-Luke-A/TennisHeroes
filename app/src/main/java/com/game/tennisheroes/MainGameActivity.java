package com.game.tennisheroes;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;

public class MainGameActivity extends AppCompatActivity {
    SensorManager sensorManager;
    Boolean firstTouch = true;
    Sensor accelerometer;
    long startTime;
    TextView textView;
    public int anim = 0;
    Runnable myRunnable;
    float pos = 0;
    Long difference;
    MediaPlayer mp1;
   boolean touch = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.tennisappmusic);
        mp1.setLooping(true);
        mp1.start();
        textView = findViewById(R.id.space);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        final ImageView iv = findViewById(R.id.iv1);
        final int max = 450;
        final int min = -450;


        SensorEventListener listener = (new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {

                float x = sensorEvent.values[0];
                if (x * 125 > max) x = max / 125;
                if (x * 125 < min) x = min / 125;
                float x75 = x * -125;
                if(!touch){
                if (Math.abs(x75 - pos) > 10) {
                    if (Math.abs(x75 - pos) < 1000) {
                        TranslateAnimation translateAnimation = new TranslateAnimation(pos, x75, 0, 0);
                        translateAnimation.setDuration(90);
                        pos = x75;
                        translateAnimation.setFillAfter(true);
                        iv.startAnimation(translateAnimation);
                    } else {
                        TranslateAnimation translateAnimation = new TranslateAnimation(pos, x75, 0, 0);
                        translateAnimation.setDuration(125);
                        pos = x75;
                        translateAnimation.setFillAfter(true);
                        iv.startAnimation(translateAnimation);
                    }
                }
                }
            }


            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }

        });

        sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);

    }

    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getActionMasked();
        if (action == MotionEvent.ACTION_UP) {
            touch = false;
            long endTime = System.currentTimeMillis();
            difference = (endTime - startTime);
            textView.setText(String.valueOf(difference));
            firstTouch = true;
             return false;
        } else {
            touch = true;
            difference = System.currentTimeMillis() - startTime;
            textView.setText(String.valueOf(difference));
            if (firstTouch) {
                startTime = System.currentTimeMillis();
                firstTouch = false;
            }
            return true;
        }
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








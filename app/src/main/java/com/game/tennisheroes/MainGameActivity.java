package com.game.tennisheroes;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
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
    float currentx = 0;
    float currenty = 0;
    TextView textView;
    public int anim = 0;
    int xjump = 10;
    int yjump = 10;
    int speed = 1;
    Runnable myRunnable;
    float pos = 0;
    Long difference;
    MediaPlayer mp1;
   boolean touch = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        int UI_OPTIONS = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        }

        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.tennisappmusic);
        mp1.setLooping(true);
        mp1.start();
        textView = findViewById(R.id.space);

        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);


        final ImageView iv = findViewById(R.id.iv1);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int width = displayMetrics.widthPixels;
        final int height = displayMetrics.heightPixels;
        final int maxx = width/2 - 100;
        final int maxy = width/2;
        final int min = -(width/2) + 100;


        SensorEventListener listener = (new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                int multiplier = 90;
                float x = sensorEvent.values[0];
                float x75 = x * -multiplier;
                if (x75 > maxx) x75 = maxx;
                if (x75 < min) x75 = min;
                if(!touch){
                        iv.setTranslationX(x75);
                }
            }
            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }

        });
       final ImageView ball = findViewById(R.id.ball);

        sensorManager.registerListener(listener, accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {

                while (true) {

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            textView.setText(String.valueOf(ball.getTop()+currenty));
                            if(currenty+ball.getTop()+350 > height){
                                yjump = -yjump;
                            }
                            if(currenty-ball.getTop()+150 < 0){
                                yjump = -yjump;
                            }
                            if(currentx+ball.getLeft()+250 > width){
                                xjump = -xjump;
                            }
                            if(currentx-ball.getLeft()+100 < 0){
                                xjump = -xjump;
                            }
                          TranslateAnimation animation = new TranslateAnimation(currentx,currentx+xjump ,currenty,currenty + yjump);
                          ball.startAnimation(animation);
                            currentx = currentx+xjump;
                            currenty = currenty + yjump;

                        }
                    });
                    try {
                        Thread.sleep(10);
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
    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getActionMasked();
        if (action == MotionEvent.ACTION_UP) {
            touch = false;
            long endTime = System.currentTimeMillis();
            difference = (endTime - startTime);
            textView.setText(String.valueOf(difference/500));
            firstTouch = true;

             return false;
        } else {
            touch = true;
            difference = System.currentTimeMillis() - startTime;
            textView.setText(String.valueOf(difference/500));
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








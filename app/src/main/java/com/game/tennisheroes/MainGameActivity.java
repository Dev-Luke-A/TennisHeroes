package com.game.tennisheroes;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;
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
    int xjump = 5;
    int yjump = 5;
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
        //RotateCP
        ImageView cpman = findViewById(R.id.iv);
        RotateAnimation rotateAnimation = new RotateAnimation(cpman.getRotation(),cpman.getRotation()+180,cpman.getWidth()/2, cpman.getHeight()/2);
        cpman.startAnimation(rotateAnimation);
//Immersive mode
        int UI_OPTIONS = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        }
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);
        //Start music
        mp1 = MediaPlayer.create(getApplicationContext(), R.raw.tennisappmusic);
        mp1.setLooping(true);

        mp1.start();
        final int duration = mp1.getDuration();
// Measure screen height, etc.
        textView = findViewById(R.id.space);
        final ImageView iv = findViewById(R.id.iv1);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        final int width = displayMetrics.widthPixels;
        final int height = displayMetrics.heightPixels;
        final int maxx = width/2 - 100;
        final int maxy = width/2;
        final int min = -(width/2) + 100;
//Register Sensors
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener sensorEventListener = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                //Move man
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
        };
        //Register accelerometer listener
        sensorManager.registerListener(sensorEventListener, accelerometer, SensorManager.SENSOR_DELAY_UI);
       final ImageView ball = findViewById(R.id.ball);
       float ballwidth = ball.getWidth();
       final float ballheight = ball.getHeight();
        Runnable myRunnable = new Runnable() {
            @Override
            public void run() {

                while (true) {
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //CPman

                            //Man bounce

                            //Y pos of ball
                            float yposs = currentx-ball.getLeft()+(ball.getWidth())/2-ball.getScaleX()*150;
                            textView.setText(String.valueOf(ball.getTop()));
                            float ypos = currenty+ball.getTop()+ballheight + 200;
                            float scalexconstant = (float) 0.4;
                            float quarterheight = height/4;
                            float threequarterheight = quarterheight*3;
                            //"Bounce" up and down
                            if(Math.abs(ypos-(quarterheight)) < Math.abs(ypos-threequarterheight)){
                                float qdifference = quarterheight -ypos;

                                ball.setScaleX(scalexconstant+Math.abs(qdifference)/2000);
                                ball.setScaleY(scalexconstant+Math.abs(qdifference)/2000);

                            }else{
                                float tdifference = threequarterheight-ypos;

                                ball.setScaleX(scalexconstant+Math.abs(tdifference)/2000);
                                ball.setScaleY(scalexconstant+Math.abs(tdifference)/2000);

                            }
                            //Move
                          TranslateAnimation animation = new TranslateAnimation(currentx,currentx+xjump ,currenty,currenty + yjump);
                          ball.startAnimation(animation);
                          ball.bringToFront();
                            currentx = currentx+xjump;
                            currenty = currenty + yjump;

                        }
                    });
                    //Pause
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
//When touched:
    @Override
    public boolean onTouchEvent(MotionEvent e) {
        int action = e.getActionMasked();
        //if (finger is up)
        if (action == MotionEvent.ACTION_UP) {
            //Start the ball again, stop the timer
            touch = false;
            long endTime = System.currentTimeMillis();
            difference = (endTime - startTime);
            textView.setText(String.valueOf(difference/500));
            firstTouch = true;

             return false;
        } else {
            //Stop the ball, start a timer
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
    //Stop the music when closed
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








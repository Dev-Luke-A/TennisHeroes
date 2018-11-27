package com.game.tennisheroes;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainGameActivity extends AppCompatActivity {
   SensorManager sensorManager;
   Sensor accelerometer;
   float pos = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_game);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        accelerometer = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        SensorEventListener listener = (new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent sensorEvent) {
                float x = sensorEvent.values[0];
                int max = 450;
                int min = -450;
                if (x * 75 > max) x = max/75;
                if (x * 75 < min) x = min/75;
                TranslateAnimation translateAnimation = new TranslateAnimation(pos,x * -75,0,0);
                translateAnimation.setDuration(1);
                translateAnimation.setFillAfter(true);
                final ImageView iv = findViewById(R.id.iv1);
                iv.startAnimation(translateAnimation);
                pos =  (x * -75);
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int i) {

            }
        });
        sensorManager.registerListener( listener, accelerometer,SensorManager.SENSOR_DELAY_NORMAL);




    }

}




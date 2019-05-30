package com.game.tennisheroes;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Animation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        ImageView iv = findViewById(R.id.imageViews);

        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Drawable d = getResources().getDrawable(R.drawable.scntwo);
        iv.setImageDrawable(d);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Drawable d2 = getResources().getDrawable(R.drawable.scnthree);
        iv.setImageDrawable(d2);
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Intent i = new Intent(getApplicationContext(), HomeScreen.class);
        startActivity(i);

    }
}

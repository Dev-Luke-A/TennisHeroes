package com.game.tennisheroes;

import android.content.Intent;

import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import static com.game.tennisheroes.HomeScreen.tf;

public class MainActivity extends AppCompatActivity {
    float one;
    float two;
    float three;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    public float coins;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = prefs.edit();
        coins = prefs.getFloat("coins", 1000);
        one = prefs.getFloat("one", 1);
        two = prefs.getFloat("two", 1);
        three = prefs.getFloat("three", 1);
        TextView tv = findViewById(R.id.coins);
        ImageView ivm = findViewById(R.id.imageViewm);
        tv.setTypeface(tf);
        tv.setText(String.valueOf(coins));
        ImageView iv = findViewById(R.id.imageView5);
        if(three == 1){
            iv.setImageResource(R.drawable.lvl1hat);
            ivm.setImageResource(R.drawable.lvl1hat);
        }
        if(three == 2){
            iv.setImageResource(R.drawable.lvl2hat);
            ivm.setImageResource(R.drawable.lvl2hat);
        }
        if(three == 3){
            iv.setImageResource(R.drawable.lvl3hat);
            ivm.setImageResource(R.drawable.lvl3hat);
        }
        if(three == 4){
            iv.setImageResource(R.drawable.lvl4hat);
            ivm.setImageResource(R.drawable.lvl4hat);
        }
        if(three == 5){
            iv.setImageResource(R.drawable.lvl5hat);
            ivm.setImageResource(R.drawable.lvl5hat);
        }
        //Immersive mode
        int UI_OPTIONS = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            UI_OPTIONS = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION;
        }
        getWindow().getDecorView().setSystemUiVisibility(UI_OPTIONS);

        //Tournament button
        ImageButton b1 = findViewById(R.id.imageButton4);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainGameActivity.class);
                startActivity(intent);
                finish();
            }


        });
        //Shop button
        ImageButton b2 = findViewById(R.id.imageButton3);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ShopActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
public void onBackPressed(){
    ActivityCompat.finishAffinity(this);
    finish();
}

}

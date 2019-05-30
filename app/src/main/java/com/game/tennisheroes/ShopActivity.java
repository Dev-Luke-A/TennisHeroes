package com.game.tennisheroes;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
Typeface tf = HomeScreen.tf;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
TextView tv2 = findViewById(R.id.textView2);
tv2.setTypeface(tf);
TextView tv3 = findViewById(R.id.textView3);
tv3.setTypeface(tf);
TextView tv4 = findViewById(R.id.textView4);
tv4.setTypeface(tf);

TextView tv6 = findViewById(R.id.textView6);
tv6.setTypeface(tf);
TextView tv7 = findViewById(R.id.textView7);
tv7.setTypeface(tf);
TextView tv8 = findViewById(R.id.textView8);
tv8.setTypeface(tf);

 int power;
  int speed;
   int luck;

 power = 1;
  speed = 1;
   luck = 1;


    }
}

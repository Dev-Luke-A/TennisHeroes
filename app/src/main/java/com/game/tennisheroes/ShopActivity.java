package com.game.tennisheroes;

import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity {
Typeface tf = HomeScreen.tf;
    ProgressBar pb1;
    ProgressBar pb2;
    ProgressBar pb3;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    float one;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    float two;
    float three;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        pb1 = findViewById(R.id.progressBar1);
        pb2 = findViewById(R.id.progressBar2);
        pb3 = findViewById(R.id.progressBar3);
        prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = prefs.edit();
        one = prefs.getFloat("one", 0);
        two = prefs.getFloat("two", 0);
        three = prefs.getFloat("three", 0);
             tv2    = findViewById(R.id.textView1);
tv2.setTypeface(tf);

tv3 = findViewById(R.id.textView2);
tv3.setTypeface(tf);

tv4 = findViewById(R.id.textView3);
tv4.setTypeface(tf);

tv6 = findViewById(R.id.textView4);
tv6.setTypeface(tf);
        tv3.setText(String.valueOf(one));
tv7 = findViewById(R.id.textView5);
tv7.setTypeface(tf);
        tv6.setText(String.valueOf(two));
tv8 = findViewById(R.id.textView6);
tv8.setTypeface(tf);
        tv8.setText(String.valueOf(three));
        pb1.setProgress((int)one);
        pb2.setProgress((int)two);
        pb3.setProgress((int)three);
 int power;
  int speed;
   int luck;

 power = 1;
  speed = 1;
   luck = 1;


    }


    public void one(View view) {
         one++;
         editor.putFloat("one", one).apply();
        tv3.setText(String.valueOf(one));
        pb1.setProgress((int)one);
    }
    public void two(View view) {
two++;
        editor.putFloat("two", two).apply();
        tv6.setText(String.valueOf(two));
        pb2.setProgress((int)two);
    }
    public void three(View view) {
three++;
        editor.putFloat("three", three).apply();
        tv8.setText(String.valueOf(three));
        pb3.setProgress((int)three);
    }
}

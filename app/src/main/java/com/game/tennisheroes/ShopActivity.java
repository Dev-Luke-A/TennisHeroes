package com.game.tennisheroes;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class ShopActivity extends AppCompatActivity {
Typeface tf = HomeScreen.tf;
    ProgressBar pb1;
    ProgressBar pb2;
    ProgressBar pb3;
    SharedPreferences prefs;
    SharedPreferences.Editor editor;

    TextView pr1;
    TextView pr2;
    TextView pr3;
    TextView tv2;
    TextView tv3;
    TextView tv4;
    TextView tv6;
    TextView tv7;
    TextView tv8;
    TextView tv9;
    public float one;
    public float two;
    public float three;
    float coins;
    float price1;
    float price2;
    float price3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        pr1 = findViewById(R.id.Price1);
        pr2 = findViewById(R.id.Price2);
        pr3 = findViewById(R.id.Price3);
        pb1 = findViewById(R.id.progressBar1);
        pb2 = findViewById(R.id.progressBar2);
        pb3 = findViewById(R.id.progressBar3);
        prefs = getApplicationContext().getSharedPreferences("MyPref", MODE_PRIVATE);
        editor = prefs.edit();
        coins = prefs.getFloat("coins", 1000);
        one = prefs.getFloat("one", 1);
        two = prefs.getFloat("two", 1);
        three = prefs.getFloat("three", 1);
        price1 = prefs.getFloat("pr1", 10);
        price2 = prefs.getFloat("pr2", 10);
        price3 = prefs.getFloat("pr3", 10);
        pr1.setText(String.valueOf(price1 + "coins"));
        pr2.setText(String.valueOf(price2 + "coins"));
        pr3.setText(String.valueOf(price3 + "coins"));
        tv2    = findViewById(R.id.textView1);
        tv3 = findViewById(R.id.textView2);
        tv4 = findViewById(R.id.textView3);
        tv6 = findViewById(R.id.textView4);
        tv7 = findViewById(R.id.textView5);
        tv8 = findViewById(R.id.textView6);
        tv9 = findViewById(R.id.coins);
        tv3.setText(String.valueOf(one));
        tv6.setText(String.valueOf(two));
        tv8.setText(String.valueOf(three));
        tv9.setText(String.valueOf(coins));
        tv9.setTypeface(tf);
        tv8.setTypeface(tf);
        tv7.setTypeface(tf);
        tv6.setTypeface(tf);
        tv4.setTypeface(tf);
        tv3.setTypeface(tf);
        tv2.setTypeface(tf);
        pr1.setTypeface(tf);
        pr2.setTypeface(tf);
        pr3.setTypeface(tf);
        pb1.setProgress((int)one);
        pb2.setProgress((int)two);
        pb3.setProgress((int)three);
        float power;
        float speed;
        float luck;
        power = one;
        speed = two;
        luck = three;
        editor.apply();
    }


    public void one(View view) {
        if(coins >= price1) {
            coins = coins - price1;
            one++;
            tv3.setText(String.valueOf(one));
            pb1.setProgress((int) one);
            price1 = (price1 * 2);

            pr1.setText(String.valueOf(price1) + "coins");
            editor.putFloat("pr1", price1).apply();
            editor.putFloat("one", one).apply();
            editor.putFloat("coins", coins).apply();
            tv9.setText(String.valueOf(coins));
        }else{
            Toast.makeText(getApplicationContext(), "Not enough coins", Toast.LENGTH_SHORT).show();
        }
    }
    public void two(View view) {
        if (coins >= price2){
            coins = coins - price2;
        two++;
        tv6.setText(String.valueOf(two));
        pb2.setProgress((int)two);
        price2 = (price2 * 2);
        pr2.setText(String.valueOf(price2) + "coins");
        editor.putFloat("pr2", price2).apply();
        editor.putFloat("two", two).apply();
            editor.putFloat("coins", coins).apply();
            tv9.setText(String.valueOf(coins));
        }else{
            Toast.makeText(getApplicationContext(), "Not enough coins", Toast.LENGTH_SHORT).show();
        }
    }
    public void three(View view) {
        if (three < 6) {
            if (coins >= price3) {
                coins = coins - price3;
                three++;
                tv8.setText(String.valueOf(three));
                pb3.setProgress((int) three);
                price3 = (price3 * 2);
                pr3.setText(String.valueOf(price3) + "coins)");
                editor.putFloat("pr3", price3).apply();
                editor.putFloat("three", three).apply();
                editor.putFloat("coins", coins).apply();
                tv9.setText(String.valueOf(coins));
            } else {
                Toast.makeText(getApplicationContext(), "Not enough coins", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public void onBackPressed(){
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
        finish();
    }
}

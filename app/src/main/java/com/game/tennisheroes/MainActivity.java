package com.game.tennisheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
public void onBackPressed(){
        Intent intent = new Intent(getApplicationContext(), HomeScreen.class);
        startActivity(intent);
        finish();
}
}

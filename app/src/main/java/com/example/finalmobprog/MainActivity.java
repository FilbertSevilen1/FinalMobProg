package com.example.finalmobprog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void gotoMusicians(View view){
        Intent intent = new Intent(this, MusicianActivity.class);
        startActivity(intent);
    }
    public void gotoMusics(View view){
        Intent intent = new Intent(this, MusicActivity.class);
        startActivity(intent);
    }

    public void gotoAbtUs(View view){
        Intent intent = new Intent(this, AboutUsActivity.class);
        startActivity(intent);
    }
}
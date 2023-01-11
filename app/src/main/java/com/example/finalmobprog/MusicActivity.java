package com.example.finalmobprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MusicActivity extends AppCompatActivity {
    RecyclerView musicRV;
    MusicAdapter adapter;
    ArrayList<Music> listMusic = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        Music music1 = new Music();
        music1.name = "Hello World";
        music1.genre = "Pop";
        music1.release = "2020-01-01";

        listMusic.add(music1);

        musicRV = findViewById(R.id.musicRV);
        musicRV.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MusicAdapter(this, listMusic);
        musicRV.setAdapter(adapter);
    }
}
package com.example.finalmobprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicianActivity extends AppCompatActivity {

    RecyclerView musicianRV;
    MusicianAdapter adapter;
    ArrayList<Musician> listMusician;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);

        MusicianDBFunction musicianDBFunction = new MusicianDBFunction(this);
        listMusician = musicianDBFunction.getAllMusician();

        if(listMusician.isEmpty()){
            Musician musician = new Musician();
            musician.name = "Taylor Swift";
            musician.age = 33;
            musicianDBFunction.insert(musician);

            Musician musician2 = new Musician();
            musician.name = "Beyoncé";
            musician.age = 41;
            musicianDBFunction.insert(musician2);

            Musician musician3 = new Musician();
            musician.name = "Ariana Grande";
            musician.age = 29;
            musicianDBFunction.insert(musician3);

            Musician musician4 = new Musician();
            musician.name = "Rihanna";
            musician.age = 34;
            musicianDBFunction.insert(musician4);

            listMusician = musicianDBFunction.getAllMusician();
        }

        musicianRV = findViewById(R.id.musicianRV);
        musicianRV.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MusicianAdapter(this, listMusician);
        musicianRV.setAdapter(adapter);

    }
}
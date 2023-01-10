package com.example.finalmobprog;

import androidx.appcompat.app.AppCompatActivity;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

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
            musician.country = "Wakanda";
            musician.description = "I am Jhonny Sins";            
            musicianDBFunction.insert(musician);

            Musician musician2 = new Musician();
            musician2.name = "Beyoncé";
            musician2.age = 41;
            musician2.country = "Wakanda";
            musician2.description = "I am Jhonny Sins";            
            musicianDBFunction.insert(musician2);

            Musician musician3 = new Musician();
            musician3.name = "Ariana Grande";
            musician3.age = 29;
            musician3.country = "Wakanda";
            musician3.description = "I am Jhonny Sins";
            musicianDBFunction.insert(musician3);

            Musician musician4 = new Musician();
            musician4.name = "Rihanna";
            musician4.age = 34;
            musician4.country = "Wakanda";
            musician4.description = "I am Jhonny Sins";
            musicianDBFunction.insert(musician4);

            Musician musician5 = new Musician();
            musician5.name = "Jhonny Sins";
            musician5.age = 23;
            musician5.country = "Wakanda";
            musician5.description = "I am Jhonny Sins";
            musicianDBFunction.insert(musician5);

            listMusician = musicianDBFunction.getAllMusician();
        }

        musicianRV = findViewById(R.id.musicianRV);
        musicianRV.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MusicianAdapter(this, listMusician);
        musicianRV.setAdapter(adapter);

    }

}
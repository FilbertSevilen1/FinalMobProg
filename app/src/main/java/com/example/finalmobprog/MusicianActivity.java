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
            musician.country = "America";
            musician.description = "Taylor Alison Swift is an American singer-songwriter. Her discography spans multiple genres, and her songwriting—often inspired by her personal life—has received critical praise and wide media coverage. Born in West Reading, Pennsylvania, Swift moved to Nashville at age 14 to become a country artist.";
            musicianDBFunction.insert(musician);

            Musician musician2 = new Musician();
            musician2.name = "Beyoncé";
            musician2.age = 41;
            musician2.country = "America";
            musician2.description = "Beyoncé Giselle Knowles-Carter is an American singer, songwriter, and dancer. Beyoncé is known for her boundary-pushing artistry and vocals. Her success has led to her becoming a cultural icon and earning her the nickname Queen Bey. Beyoncé performed in various singing and dancing competitions as a child.";
            musicianDBFunction.insert(musician2);

            Musician musician3 = new Musician();
            musician3.name = "Ariana Grande";
            musician3.age = 29;
            musician3.country = "America";
            musician3.description = "Ariana Grande-Butera is an American singer, songwriter, and actress. Her four-octave vocal range has received critical acclaim, and her personal life has been the subject of widespread media attention.";
            musicianDBFunction.insert(musician3);

            Musician musician4 = new Musician();
            musician4.name = "Rihanna";
            musician4.age = 34;
            musician4.country = "Barbadian";
            musician4.description = "Robyn Rihanna Fenty NH is a Barbadian singer, actress, and businesswoman. Born in Saint Michael and raised in Bridgetown, Barbados, Rihanna auditioned for American record producer Evan Rogers who invited her to the United States to record demo tapes.";
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
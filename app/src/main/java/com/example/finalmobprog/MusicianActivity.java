package com.example.finalmobprog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicianActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);

        MusicianDBFunction musicianDBFunction = new MusicianDBFunction(this);

        Musician musician = new Musician();
        musician.name = "Taylor Swift";
        musician.age = 33;

        musicianDBFunction.insert(musician);

        TextView Musiciantv = findViewById(R.id.listMusician);
        ArrayList<Musician> listMusician = musicianDBFunction.getAllMusician();
        String data ="";

        for (int i = 0;i<listMusician.size();i++){
            data+= (listMusician.get(i).id + " " + listMusician.get(i).name + " " + listMusician.get(i).age + "\n");
        }
        Musiciantv.setText(data);
    }
}
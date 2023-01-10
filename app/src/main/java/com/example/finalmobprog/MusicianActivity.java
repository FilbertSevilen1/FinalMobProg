package com.example.finalmobprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MusicianActivity extends AppCompatActivity {
    RecyclerView rvMusician;
    ArrayList<Musician> listMusician;
    MusicianAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_musician);

        rvMusician = findViewById(R.id.rvMusician);
        listMusician = new ArrayList<>();

//      Placeholder data
        Musician musician1 = new Musician();
        musician1.name = "Jhonny Sins";
        musician1.age = 23;
        musician1.country = "Wakanda";
        musician1.description = "I am Jhonny Sins";

        Musician musician2 = new Musician();
        musician2.name = "Jhonny Sins";
        musician2.age = 23;
        musician2.country = "Wakanda";
        musician2.description = "I am Jhonny Sins";

        listMusician.add(musician1);
        listMusician.add(musician2);

        rvMusician.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MusicianAdapter(this, listMusician);
        rvMusician.setAdapter(adapter);
    }

}
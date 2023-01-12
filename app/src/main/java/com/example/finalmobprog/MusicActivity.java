package com.example.finalmobprog;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MusicActivity extends AppCompatActivity {
    RecyclerView musicRV;
    MusicAdapter adapter;
    ArrayList<Music> listMusic = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

//        Music music1 = new Music();
//        music1.trackName = "Hello World";
//        music1.primaryGenreName = "Pop";
//        music1.release = "2020-01-01";

//        listMusic.add(music1);

        musicRV = findViewById(R.id.musicRV);
        musicRV.setLayoutManager(new LinearLayoutManager(this));

        adapter = new MusicAdapter(this);
        musicRV.setAdapter(adapter);

        Retrofit retrofit = APIClient.getRetrofit();
        ItunesService service = retrofit.create(ItunesService.class);
        Call<MusicResponse> call = service.getMusic("music", "jpop");
        call.enqueue(new Callback<MusicResponse>() {
            @Override
            public void onResponse(Call<MusicResponse> call, Response<MusicResponse> response) {
                List<Music> listMusic = response.body().results;
                adapter.setListMusic(listMusic);
            }

            @Override
            public void onFailure(Call<MusicResponse> call, Throwable t) {

            }
        });
    }
}
package com.example.finalmobprog;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ItunesService {
    @GET("search")
    Call<MusicResponse> getMusic(
            @Query(value="media") String media,
            @Query(value="term") String term
    );
}

package com.example.finalmobprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder> {
    Context context;
    List<Music> listMusic;

    public MusicAdapter(Context context) {
        this.context = context;
        this.listMusic = new ArrayList<>();
    }

    public void setListMusic(List<Music> listMusic) {
        this.listMusic = listMusic;
        notifyDataSetChanged();
    }

    public MusicAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_music, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicAdapter.ViewHolder holder, int position) {
        Music music = listMusic.get(position);
        holder.musicName.setText(music.trackName);
        holder.musicGenre.setText(music.primaryGenreName);
        holder.musicReleaseDate.setText(music.releaseDate);
    }

    @Override
    public int getItemCount() {
        return listMusic.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView musicName;
        TextView musicGenre;
        TextView musicReleaseDate;
        public ViewHolder(View itemView) {
            super(itemView);
            musicName = itemView.findViewById(R.id.musicName);
            musicGenre = itemView.findViewById(R.id.musicGenre);
            musicReleaseDate = itemView.findViewById(R.id.musicReleaseDate);
        }

        @Override
        public void onClick(View view) {
            Music music = listMusic.get(getAdapterPosition());
        }
    }
}

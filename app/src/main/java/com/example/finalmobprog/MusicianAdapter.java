package com.example.finalmobprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicianAdapter extends RecyclerView.Adapter <MusicianAdapter.ViewHolder> {

    Context context;
    ArrayList<Musician> musicianList;

    public MusicianAdapter(Context context, ArrayList<Musician> musicianList){
        this.context = context;
        this.musicianList = musicianList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.list_musician, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Musician musician = musicianList.get(position);
        holder.musicianID.setText(""+musician.id);
        holder.musicianName.setText(musician.name);
        holder.musicianAge.setText(""+musician.age);
    }

    @Override
    public int getItemCount() {
        return musicianList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView musicianName, musicianAge, musicianID;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            musicianName = itemView.findViewById(R.id.musicianName);
            musicianAge = itemView.findViewById(R.id.musicianAge);
            musicianID = itemView.findViewById(R.id.musicianid);
        }
    }
}

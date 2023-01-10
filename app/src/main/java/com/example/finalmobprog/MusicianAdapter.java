package com.example.finalmobprog;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MusicianAdapter extends RecyclerView.Adapter<MusicianAdapter.ViewHolder> {
    Context context;
    ArrayList<Musician> listMusician;

    public MusicianAdapter(Context context, ArrayList<Musician> listMusician) {
        this.context = context;
        this.listMusician = listMusician;
    }

    public MusicianAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_musician, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MusicianAdapter.ViewHolder holder, int position) {
        Musician musician = listMusician.get(position);
        holder.musicianName.setText(musician.name);
        String age = "";
        age += musician.age;
        holder.musicianAge.setText(age);
        holder.musicianCountry.setText(musician.country);
        holder.musicianDescription.setText(musician.description);
    }

    @Override
    public int getItemCount() {
        return listMusician.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView musicianName;
        TextView musicianAge;
        TextView musicianCountry;
        TextView musicianDescription;
        public ViewHolder(View itemView) {
            super(itemView);
            musicianName = itemView.findViewById(R.id.musicianName);
            musicianAge = itemView.findViewById(R.id.musicianAge);
            musicianCountry = itemView.findViewById(R.id.musicianCountry);
            musicianDescription = itemView.findViewById(R.id.musicianDescription);
        }

        @Override
        public void onClick(View view) {
            Musician musician = listMusician.get(getAdapterPosition());
        }
    }
}

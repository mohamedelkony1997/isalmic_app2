package com.example.islami.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islami.R;

import java.util.ArrayList;

public class versesadapter extends RecyclerView.Adapter<versesadapter.ViewHolder> {
    ArrayList<String>verses;

    public versesadapter(ArrayList<String> verses) {
        this.verses = verses;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_verses,parent,false);
        return new versesadapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String ayaatext=verses.get(position);
        holder.ayaa.setText(ayaatext);
    }

    @Override
    public int getItemCount() {
        if(verses==null) {
            return 0;
        }
        return verses.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView ayaa;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ayaa=itemView.findViewById(R.id.textayaa);


        }
    }
}

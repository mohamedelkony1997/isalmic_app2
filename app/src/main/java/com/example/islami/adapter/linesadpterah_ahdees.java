package com.example.islami.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islami.R;

import java.util.ArrayList;

public class linesadpterah_ahdees extends RecyclerView.Adapter<linesadpterah_ahdees.ViewHolder> {
    ArrayList<String> lines;

    public linesadpterah_ahdees(ArrayList<String> lines) {
        this.lines = lines;
    }

    @NonNull
    @Override
    public linesadpterah_ahdees.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lines,parent,false);
        return new linesadpterah_ahdees.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull linesadpterah_ahdees.ViewHolder holder, int position) {
        String linetext=lines.get(position);
        holder.linee.setText(linetext);
    }

    @Override
    public int getItemCount() {
        if(lines==null) {
            return 0;
        }
        return lines.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView linee;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linee=itemView.findViewById(R.id.textline);


        }
    }
}

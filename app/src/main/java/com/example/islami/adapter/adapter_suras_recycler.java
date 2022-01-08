package com.example.islami.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islami.R;

public class adapter_suras_recycler extends RecyclerView.Adapter<adapter_suras_recycler.ViewHolder> {
    String []names;

    public adapter_suras_recycler(String[] names) {
        this.names = names;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quran,parent,false);
        return new adapter_suras_recycler.ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String name_text=names[position];
        holder.name.setText(name_text);
        if(onItemClickListner!=null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListner.onitemclick(position,name_text);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        if(names==null) {
            return 0;
        }
        return names.length;
    }
OnItemClickListner onItemClickListner;

    public void setOnItemClickListner(OnItemClickListner onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public  interface OnItemClickListner{
    void onitemclick(int pos, String name);
}
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
          name=itemView.findViewById(R.id.item_text_name);

        }
    }
}

package com.example.islami.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islami.R;

public class adapter_ahadees_recycler extends RecyclerView.Adapter<adapter_ahadees_recycler.ViewHolder> {
    String []names;

    public adapter_ahadees_recycler(String[] names) {
        this.names = names;
    }

    @NonNull
    @Override
    public adapter_ahadees_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_ahadees,parent,false);
        return new adapter_ahadees_recycler.ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull adapter_ahadees_recycler.ViewHolder holder, int position) {
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
    adapter_ahadees_recycler.OnItemClickListner2 onItemClickListner;

    public void setOnItemClickListner(adapter_ahadees_recycler.OnItemClickListner2 onItemClickListner) {
        this.onItemClickListner = onItemClickListner;
    }

    public  interface OnItemClickListner2{
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

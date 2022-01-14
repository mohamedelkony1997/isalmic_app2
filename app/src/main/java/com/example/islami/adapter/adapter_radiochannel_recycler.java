package com.example.islami.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.islami.R;
import com.example.islami.RadiosItem;

import java.util.List;

public class adapter_radiochannel_recycler extends RecyclerView.Adapter<adapter_radiochannel_recycler.ViewHolder> {
  List<RadiosItem>channels;

    public adapter_radiochannel_recycler(List<RadiosItem> channels) {
        this.channels = channels;
    }


    @NonNull
    @Override
    public adapter_radiochannel_recycler.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.radio_item,parent,false);
        return new adapter_radiochannel_recycler.ViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull adapter_radiochannel_recycler.ViewHolder holder, int position) {
   holder.name.setText(channels.get(position).getName());
   if(onItemplay!=null){
       holder.play.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               onItemplay.onitemclick(position,channels.get(position));
           }
       });
   }
        if(onItemstop!=null){
            holder.stop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemstop.onitemclick(position,channels.get(position));
                }
            });
        }



    }

    @Override
    public int getItemCount() {
        if(channels==null)  return 0;
        return channels.size();
    }
    OnItemClickListner3 onItemplay;
    OnItemClickListner3 onItemstop;

    public void setOnItemplay(OnItemClickListner3 onItemplay) {
        this.onItemplay = onItemplay;
    }

    public void setOnItemstop(OnItemClickListner3 onItemstop) {
        this.onItemstop = onItemstop;
    }




    public void changedata(List <RadiosItem> radiosItems) {
        this.channels=radiosItems;
        notifyDataSetChanged();
    }

    public  interface OnItemClickListner3{
        void onitemclick(int pos, RadiosItem channls);
    }
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView play;
        ImageView stop;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.radiochannel);
            stop=itemView.findViewById(R.id.stopplaying);
            play=itemView.findViewById(R.id.play);



        }
    }
}

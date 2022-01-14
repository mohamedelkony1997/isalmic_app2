package com.example.islami;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.islami.adapter.adapter_radiochannel_recycler;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RadioFragment extends Fragment {



    public RadioFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_radio, container, false);
    }
RecyclerView recyclerView;
    adapter_radiochannel_recycler adapter;
  View progresbar;
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.radiorecycler);
        progresbar=view.findViewById(R.id.progressbar);
       adapter=new adapter_radiochannel_recycler(null);
      recyclerView.setAdapter(adapter);
        SnapHelper snapHelper=new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);
       getradiochannels();
       adapter.setOnItemplay(new adapter_radiochannel_recycler.OnItemClickListner3() {
           @Override
           public void onitemclick(int pos, RadiosItem channls) {
       playchannel(channls.getRadioUrl());
           }
       });
       adapter.setOnItemstop(new adapter_radiochannel_recycler.OnItemClickListner3() {
           @Override
           public void onitemclick(int pos, RadiosItem channls) {
               stopchannel();
           }
       });


    }
    MediaPlayer mediaPlayer;
    public  void playchannel(String url){
        stopchannel();
        mediaPlayer=new MediaPlayer();

        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.prepareAsync();
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.start();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
            Toast.makeText(getContext(), "error to play channel", Toast.LENGTH_SHORT).show();
        }


    }
    public  void stopchannel() {
        if(mediaPlayer==null) return;
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer=null;





    }


    private void getradiochannels() {
        ApiManger.getApis().getradiochannel().enqueue(new Callback<RadioChannelResponse>() {
            @Override
            public void onResponse(Call<RadioChannelResponse> call, Response<RadioChannelResponse> response) {
               List <RadiosItem> radiosItems=response.body().getRadios();
                System.out.println(radiosItems.size());
                adapter.changedata( radiosItems);
                progresbar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<RadioChannelResponse> call, Throwable t) {
                Toast.makeText(getContext(), t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                progresbar.setVisibility(View.GONE);
            }
        });

    }
}
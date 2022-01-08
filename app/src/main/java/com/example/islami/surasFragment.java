package com.example.islami;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.islami.adapter.adapter_suras_recycler;


public class surasFragment extends Fragment {


    public surasFragment() {

    }
View view;
    RecyclerView recyclerView;

    adapter_suras_recycler adapter_suras_recycler;
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view= inflater.inflate(R.layout.fragment_suras, container, false);
        recyclerView=view.findViewById(R.id.recyclerview);
        adapter_suras_recycler=new adapter_suras_recycler(Constants.ArSuras);
        adapter_suras_recycler.setOnItemClickListner(new adapter_suras_recycler.OnItemClickListner() {
            @Override
            public void onitemclick(int pos, String name) {
                Intent intent=new Intent(getActivity(),SurasDetails.class);
                intent.putExtra("Pos",pos);
                intent.putExtra("Name",name);
                startActivity(intent);


            }
        });
        recyclerView.setAdapter(adapter_suras_recycler);

return  view;
    }
    }

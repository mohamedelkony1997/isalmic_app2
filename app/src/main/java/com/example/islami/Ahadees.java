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

import com.example.islami.adapter.adapter_ahadees_recycler;
import com.example.islami.adapter.adapter_suras_recycler;


public class Ahadees extends Fragment {

    View view;
    RecyclerView recyclerView;

    adapter_ahadees_recycler adapter_ahadees_recycler;


    public Ahadees() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_ahadees, container, false);
        recyclerView=view.findViewById(R.id.recyclerview2);
        adapter_ahadees_recycler=new adapter_ahadees_recycler(Constants.Arahadees);
        adapter_ahadees_recycler.setOnItemClickListner(new adapter_ahadees_recycler.OnItemClickListner2() {
            @Override
            public void onitemclick(int pos, String name) {
                Intent intent = new Intent(getActivity(), ahadees_details.class);
                intent.putExtra("Pos",pos);
                intent.putExtra("Name",name);
                startActivity(intent);


            }
        });
        recyclerView.setAdapter(adapter_ahadees_recycler);

        return  view;
    }
}
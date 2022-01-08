package com.example.islami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.islami.adapter.linesadpterah_ahdees;
import com.example.islami.adapter.versesadapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ahadees_details extends AppCompatActivity {
    int pos;
    String name;
    ArrayList<String > lines;
    RecyclerView linerecycler;
    TextView ahdees;
    linesadpterah_ahdees linesadpterah_ahdees;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_ahadees);
        linerecycler=findViewById(R.id.recyclerviewlines);
        ahdees=findViewById(R.id.textsuraadd);
        Intent in=getIntent();
        pos= in.getIntExtra("Pos",-1);
        name= in.getStringExtra("Name");
        lines= readahdeesfromfile(("h") + (pos+1) +".txt");
        ahdees.setText(name);
        linesadpterah_ahdees=new linesadpterah_ahdees(lines);
        linerecycler.setAdapter(linesadpterah_ahdees);

    }
    public ArrayList<String> readahdeesfromfile(String file_name){
        ArrayList<String>alllines=new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(file_name), "UTF-8"));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                alllines.add(mLine);

            }
        } catch (IOException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {

                }
            }
        }
        return alllines;
    }

}
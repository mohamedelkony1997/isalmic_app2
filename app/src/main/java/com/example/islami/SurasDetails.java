package com.example.islami;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.example.islami.adapter.adapter_suras_recycler;
import com.example.islami.adapter.versesadapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SurasDetails extends AppCompatActivity {
 int pos;
String name;
ArrayList<String >verses;
RecyclerView verserecycler;
TextView namesura;
    com.example.islami.adapter.versesadapter versesadapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras_details);
        verserecycler=findViewById(R.id.recyclerviewverses);
        namesura=findViewById(R.id.textsuraadd);
        Intent in=getIntent();
     pos= in.getIntExtra("Pos",-1);
        name= in.getStringExtra("Name");
       verses= readsurafromfile((pos+1) +".txt");
         namesura.setText(name);
        versesadapter=new versesadapter(verses);
         verserecycler.setAdapter(versesadapter);

    }
    public ArrayList<String> readsurafromfile(String file_name){
        ArrayList<String>allverses=new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(
                    new InputStreamReader(getAssets().open(file_name), "UTF-8"));

            String mLine;
            while ((mLine = reader.readLine()) != null) {
                allverses.add(mLine);

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
        return allverses;
    }

    //log the exception
}
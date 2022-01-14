package com.example.islami;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class home extends AppCompatActivity {
BottomNavigationView navigationView;
Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        navigationView=findViewById(R.id.navigation);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.qouran) {
                 fragment=new surasFragment();
                }else if(item.getItemId()==R.id.ahadees){
                    fragment=new Ahadees();
                }else if(item.getItemId()==R.id.radio){
                   fragment=new RadioFragment();
                }
                getSupportFragmentManager().beginTransaction().
                        replace(  R.id.framlayout,fragment).commit();
                return true;
            }
        });

    }
}
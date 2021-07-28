package com.example.study;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private boolean isLandscape = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if(!isLandscape){
            FragmentManager fragmentManager = getSupportFragmentManager();

            Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_list);

            if(fragment == null){

                fragmentManager.beginTransaction()
                        .replace(R.id.fragment_list, NoteList.newInstance(null,null))
                        .commit();
            }
        }
    }
}
package com.example.study;

import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.example.study.domain.Note;

import java.util.concurrent.Flow;

public class MainActivity extends AppCompatActivity implements NoteList.OnNoteClicked, PublisherHolder {

    private boolean isLandscape = false;
    private Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (!isLandscape) {
            FragmentManager fragmentManager = getSupportFragmentManager();

            Fragment fragment = fragmentManager.findFragmentById(R.id.container);

            if (fragment == null) {

                fragmentManager.beginTransaction()
                        .replace(R.id.container, NoteList.newInstance())
                        .commit();
            }
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onNoteClicked(Note note) {
        FragmentManager fragmentManager = getSupportFragmentManager();

        if (isLandscape) {

            fragmentManager.beginTransaction()
                    .replace(R.id.note_details, NoteDetails.newInstance(note))
                    .commit();
        } else {

            fragmentManager.beginTransaction()
                    .replace(R.id.container, NoteDetails.newInstance(note))
                    .addToBackStack(null)
                    .commit();
        }
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}
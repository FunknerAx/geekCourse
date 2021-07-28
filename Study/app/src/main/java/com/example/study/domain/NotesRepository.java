package com.example.study.domain;

import com.example.study.R;

import java.util.ArrayList;
import java.util.List;

public class NotesRepository {
    public List<Note> getNotes(){
        ArrayList<Note> notes = new ArrayList<>();
        notes.add(new Note(R.string.label1,R.string.description1,R.string.date1));
        notes.add(new Note(R.string.label2,R.string.description2,R.string.date2));
        notes.add(new Note(R.string.label3,R.string.description3,R.string.date3));
        return  notes;
    }
}

package com.example.study;

import com.example.study.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    public final List<Subscriber> subscribers = new ArrayList<>();

    public void addSubscriber (Subscriber subscriber) { subscribers.add(subscriber);}

    public void removeSubscriber (Subscriber subscriber) { subscribers.remove(subscriber);}

    public void notify(Note note){
        for(Subscriber subscriber : subscribers){
            subscriber.updateNote(note);
        }
    }
}

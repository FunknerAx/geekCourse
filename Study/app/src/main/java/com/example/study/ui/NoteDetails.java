package com.example.study.ui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.study.Publisher;
import com.example.study.PublisherHolder;
import com.example.study.R;
import com.example.study.Subscriber;
import com.example.study.domain.Note;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteDetails#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteDetails extends Fragment implements Subscriber {

    private static final String NOTE = "note";
    private TextView textView;

    public NoteDetails() {
        // Required empty public constructor
    }

    public static NoteDetails newInstance(Note note) {
        NoteDetails fragment = new NoteDetails();

        Bundle args = new Bundle();
        args.putParcelable(NOTE, note);

        fragment.setArguments(args);

        return fragment;
    }
    private Publisher publisher;
    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();
            publisher.addSubscriber(this);
        }
    }

    @Override
    public void onDetach() {
        if (publisher != null) {
            publisher.removeSubscriber(this);
        }

        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_note_details, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Note note = getArguments().getParcelable(NOTE);

        textView = view.findViewById(R.id.note_description);
        textView.setText(note.getDescription());
    }

    @Override
    public void updateNote(Note note) {
        textView.setText(note.getDescription());
    }
}
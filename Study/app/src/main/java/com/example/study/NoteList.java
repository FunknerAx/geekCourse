package com.example.study;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.example.study.domain.Note;
import com.example.study.domain.NotesRepository;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NoteList#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NoteList extends Fragment {

    public interface OnNoteClicked {
        void onNoteClicked(Note note);
    }

    private OnNoteClicked onNoteClicked;


    public void Fragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnNoteClicked) {
            onNoteClicked = (OnNoteClicked) context;
        }
    }

    @Override
    public void onDetach() {
        onNoteClicked = null;
        super.onDetach();
    }

    public static NoteList newInstance() {
        NoteList fragment = new NoteList();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setHasOptionsMenu(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initList(view);

        Toolbar toolbar = view.findViewById(R.id.toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if(item.getItemId() == R.id.settings){
                    Toast.makeText(getContext(), "settings", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(),"nav",Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initList(View view) {

        List<Note> notes = new NotesRepository().getNotes();
        LinearLayout layoutView = view.findViewById(R.id.notes_list);

        for (Note cur : notes) {
            View curView = LayoutInflater.from(getContext()).inflate(R.layout.note_item, layoutView, false);

            TextView textView = curView.findViewById(R.id.item_label);
            textView.setText(cur.getLabel());

            TextView dateTextView = curView.findViewById(R.id.item_date);
            dateTextView.setText(cur.getDate());

            curView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    openNoteDetails(cur);
                }
            });

            layoutView.addView(curView);
        }
    }

    private void openNoteDetails(Note cur) {
        if (getActivity() instanceof PublisherHolder) {
            PublisherHolder holder = (PublisherHolder) getActivity();

            holder.getPublisher().notify(cur);
        }

        if (onNoteClicked != null) {
            onNoteClicked.onNoteClicked(cur);
        }
    }
}
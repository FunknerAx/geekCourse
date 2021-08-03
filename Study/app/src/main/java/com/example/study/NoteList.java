package com.example.study;


import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;

import com.example.study.domain.Note;
import com.example.study.domain.NotesRepository;
import com.google.android.material.navigation.NavigationView;

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
        DrawerLayout drawer = view.findViewById(R.id.drawer_list);
        NavigationView navigationView = view.findViewById(R.id.nav_bar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(getActivity(), drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.about_nav_view) {
                    Toast.makeText(getContext(), "About", Toast.LENGTH_SHORT).show();
                    drawer.closeDrawer(GravityCompat.START);
                    return true;
                }
                return false;
            }
        });

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.settings) {
                    Toast.makeText(getContext(), "settings", Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "nav", Toast.LENGTH_SHORT).show();
                drawer.openDrawer(GravityCompat.START);
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

            ImageButton imageButton = curView.findViewById(R.id.button_more);


            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    PopupMenu popupMenu = new PopupMenu(getContext(), v);
                    requireActivity().getMenuInflater().inflate(R.menu.popup_note_more, popupMenu.getMenu());

                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.change_note) {
                                Toast.makeText(getContext(), "change note", Toast.LENGTH_SHORT).show();
                                return true;
                            }
                            if (item.getItemId() == R.id.delete_note) {
                                Toast.makeText(getContext(), "delete note", Toast.LENGTH_SHORT).show();
                            }
                            return false;
                        }
                    });
                    popupMenu.show();
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
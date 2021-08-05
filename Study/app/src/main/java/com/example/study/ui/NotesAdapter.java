package com.example.study.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.study.R;
import com.example.study.domain.Note;

import java.util.ArrayList;

public class NotesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    interface OnNoteClicked{
        void onNoteClicked(View v,int position);
    }

    ArrayList<Note> data = new ArrayList<>();

    private OnNoteClicked onNoteClicked;

    public void setOnNoteClicked(OnNoteClicked onNoteClicked) {
        this.onNoteClicked = onNoteClicked;
    }

    public void addData(ArrayList<Note> notes){
        data.clear();
        data.addAll(notes);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_item, parent, false);
        return new NotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Note note = data.get(position);

        NotesViewHolder holder1 = (NotesViewHolder) holder;

        holder1.title.setText(note.getLabel());
        holder1.date.setText(note.getDate());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class NotesViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        TextView date;
        ImageButton imageButton;

        public NotesViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_label);
            date = itemView.findViewById(R.id.item_date);
            imageButton = itemView.findViewById(R.id.button_more);

            imageButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(onNoteClicked != null){
                        onNoteClicked.onNoteClicked(v,getAdapterPosition());
                    }
                }
            });
        }
    }


}

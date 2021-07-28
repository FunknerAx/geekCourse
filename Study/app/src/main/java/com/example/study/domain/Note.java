package com.example.study.domain;

import android.os.Parcel;
import android.os.Parcelable;

public class Note implements Parcelable {

    private int label;
    private int description;
    private int date;

    public Note(int label, int description, int date) {
        this.label = label;
        this.description = description;
        this.date = date;
    }

    protected Note(Parcel in) {
        label = in.readInt();
        description = in.readInt();
        date = in.readInt();
    }

    public static final Creator<Note> CREATOR = new Creator<Note>() {
        @Override
        public Note createFromParcel(Parcel in) {
            return new Note(in);
        }

        @Override
        public Note[] newArray(int size) {
            return new Note[size];
        }
    };

    public void setLabel(int label) {
        this.label = label;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getLabel() {
        return label;
    }

    public int getDescription() {
        return description;
    }

    public int getDate() {
        return date;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(label);
        dest.writeInt(description);
        dest.writeInt(date);
    }
}

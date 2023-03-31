package com.example.librory.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "noteTable")
public class Note {

    @PrimaryKey(autoGenerate = true)
    private int ID;

    private String title;

    private String description;

    public Note(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

package com.example.librory.database;

import androidx.lifecycle.LiveData;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "cartObject")
public class Cart {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String BookName;

    private String BookDescription;

    private String Author;

    private String Category;

    public Cart(String bookName, String bookDescription, String author, String category) {
        BookName = bookName;
        BookDescription = bookDescription;
        Author = author;
        Category = category;
    }

    public Cart() {
    }

    public void setBookName(String bookName) {
        BookName = bookName;
    }

    public void setBookDescription(String bookDescription) {
        BookDescription = bookDescription;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public int getId() {
        return id;
    }

    public String getBookName() {
        return BookName;
    }

    public String getBookDescription() {
        return BookDescription;
    }

    public String getAuthor() {
        return Author;
    }

    public String getCategory() {
        return Category;
    }

    public void setId(int id) {
        this.id = id;
    }


}

package com.example.librory.database;


import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "bookTable")
public class Book {

    @PrimaryKey(autoGenerate = true)
    private int BookID;

    private String BookName;

    private String BookDescription;

    private String Author;

    private String Category;

    public Book(String bookName, String bookDescription, String author, String category) {
        this.BookName = bookName;
        this.BookDescription = bookDescription;
        this.Author = author;
        this.Category = category;
    }

    public Book() {
    }

    public void setBookID(int bookID) {
        BookID = bookID;
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

    //region $getters
    public int getBookID() {
        return BookID;
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
    //endregion
}

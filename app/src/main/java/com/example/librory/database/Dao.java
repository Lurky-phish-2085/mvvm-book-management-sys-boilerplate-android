package com.example.librory.database;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {


    //region $BookDao
    @Insert
    void insert(Book book);

    @Delete
    void delete(Book book);

    @Update
    void update(Book book);

    @Query("SELECT * FROM bookTable")
    LiveData<List<Book>> getBooks();

    @Query("SELECT * FROM bookTable where BookName like :title")
    Book findBookByName(String title);
    //endregion

    //region $NoteDao
    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("SELECT * FROM noteTable")
    LiveData<List<Note>> getNotes();

    @Query("SELECT * FROM noteTable where title like :title")
    Note findNoteByName(String title);
    //endregion

    //region $CartDao
    @Insert
    void insert(Cart cart);

    @Update
    void update(Cart cart);

    @Delete
    void delete(Cart cart);

    @Query("SELECT * FROM cartObject")
    LiveData<List<Cart>> getCart();
    //endregion
}

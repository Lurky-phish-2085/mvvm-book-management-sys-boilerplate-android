package com.example.librory.database;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class BookViewModel extends AndroidViewModel {
    private Repository repository;
    private LiveData<List<Book>> BookList;

    public BookViewModel(@NonNull Application application) {
        super(application);
        repository = new Repository(application);
        BookList = repository.getBookList();
    }

    public void insert(Book book){
        repository.insert(book);
    }

    public void update(Book book){
        repository.update(book);
    }

    public void delete(Book book){
        repository.insert(book);
    }

    public LiveData<List<Book>> getBookList(){
        return BookList;
    }


}

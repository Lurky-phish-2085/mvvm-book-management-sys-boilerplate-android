package com.example.librory.database;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class Repository {
    private Dao dao;

    private LiveData<List<Cart>> cart;
    private LiveData<List<Book>> bookList;

    //Constructor
    public Repository(Application application){
        Database bookDb = Database.getInstance(application);

        dao = bookDb.dao();

        bookList = dao.getBooks();

        cart = dao.getCart();
    }

    //region $Book Functions
    public Book findBookByName(String name){
        return dao.findBookByName(name);
    }

    public LiveData<List<Book>> getBookList() {
        return dao.getBooks();
    }

    public void insert(Book book){
        new BookTableOperationAsyncTask(dao, 0).execute(book);
    }

    public void update(Book book){
        new BookTableOperationAsyncTask(dao, 1).execute(book);
    }

    public void delete(Book book){
        new BookTableOperationAsyncTask(dao, 2).execute(book);
    }
    //endregion

    //region $Note Functions
    public void insert(Note notes){
        new NoteTableOperationAsyncTask(dao, 0).execute(notes);
    }

    public void update(Note notes){
        new NoteTableOperationAsyncTask(dao, 1).execute(notes);
    }

    public void delete(Note notes){
        new NoteTableOperationAsyncTask(dao, 2).execute(notes);
    }
    //endregion

    //region $Cart Function
    public LiveData<List<Cart>> getCart(){
        return dao.getCart();
    }

    public void update(Cart cart){
        new CartAsyncOperations(dao, 0).execute(cart);
    }
    //endregion

    //region $Async Tasks
    private static class BookTableOperationAsyncTask extends AsyncTask<Book, Void, Void>{

        private static Dao dao;
        private static int mode;

        private BookTableOperationAsyncTask(Dao dao, int mode){
            this.dao = dao;
            this.mode = mode;
        }

        @Override
        protected Void doInBackground(Book... books) {
            switch(mode){
                case 0:
                    dao.insert(books[0]);
                case 1:
                    dao.update(books[0]);
                case 2:
                    dao.update(books[0]);
            }
            return null;
        }
    }

    private static class NoteTableOperationAsyncTask extends AsyncTask<Note, Void, Void>{

        private static Dao dao;
        private static int mode;

        public NoteTableOperationAsyncTask(Dao dao, int mode) {
            this.dao = dao;
            this.mode = mode;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            switch(mode){
                case 0:
                    dao.insert(notes[0]);
                case 1:
                    dao.update(notes[0]);
                case 2:
                    dao.delete(notes[0]);
            }
            return null;
        }
    }

    private static class CartAsyncOperations extends AsyncTask<Cart, Void, Void>{
        private static Dao dao;
        private static int mode;

        public CartAsyncOperations(Dao dao, int mode) {
            this.dao = dao;
            this.mode = mode;
        }

        @Override
        protected Void doInBackground(Cart... carts) {
            switch(mode){
                case 0:
                    dao.update(carts[0]);
            }
            return null;
        }
    }
    //endregion
}

package com.example.librory.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;

@androidx.room.Database(entities = {Book.class, Note.class, Cart.class}, version = 1)
public abstract class Database extends RoomDatabase {

    private static Database instance;

    public abstract Dao dao();

    public static synchronized Database getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    Database.class, "bookDataBase")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db){
            super.onCreate(db);
            new PopulateDBAsyncTask(instance).execute();
        }
    };

    private static class PopulateDBAsyncTask extends AsyncTask<Void, Void, Void>{
        private static Dao dao;

        private PopulateDBAsyncTask(Database db){
            dao = db.dao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            dao.insert(new Book("1984", "A good book", "George Orville", "Novel"));
            return null;
        }
    }
}

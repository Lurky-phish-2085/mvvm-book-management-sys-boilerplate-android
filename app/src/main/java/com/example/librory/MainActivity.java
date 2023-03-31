package com.example.librory;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Toast;

import com.example.librory.database.Book;
import com.example.librory.database.BookViewModel;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BookViewModel bookViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        

        bookViewModel = new ViewModelProvider(this).get(BookViewModel.class);
        bookViewModel.getBookList().observe(this, new Observer<List<Book>>() {
            @Override
            public void onChanged(List<Book> books) {
                //update RecyclerView
                Toast.makeText(MainActivity.this, "onChanged", Toast.LENGTH_LONG).show();
            }
        });
    }
}
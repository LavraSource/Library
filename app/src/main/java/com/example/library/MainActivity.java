package com.example.library;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {
    ListView bookList;
    EditText bookName;
    EditText bookAuthor;
    Button addButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bookList=findViewById(R.id.booklist);
        bookName=findViewById(R.id.book_name);
        bookAuthor=findViewById(R.id.book_author);
        addButton=findViewById(R.id.addButton);
        //preparing data
        LinkedList<Book> bookLinkedList=new LinkedList<>();
        bookLinkedList.add(new Book("Гарри Поттер и философский камень", "Роулинг"));
        bookLinkedList.add(new Book("Гарри Поттер и тайная комната", "Роулинг"));
        bookLinkedList.add(new Book("Гарри Поттер и узник Азкабана", "Роулинг"));
        bookLinkedList.add(new Book("Гарри Поттер и дары Смерти", "Роулинг"));
        //creating an adapter
        ArrayAdapter<Book> arrayAdapter=new ArrayAdapter<>(this, R.layout.list_title, bookLinkedList);
        bookList.setAdapter(arrayAdapter);
        bookList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                bookLinkedList.remove((int)id);
                arrayAdapter.notifyDataSetChanged();
            }
        });
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bookLinkedList.add(new Book(bookName.getText().toString(), bookAuthor.getText().toString()));
                bookName.setText("");
                bookAuthor.setText("");
            }
        });

    }
}
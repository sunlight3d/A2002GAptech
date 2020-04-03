package com.example.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private ListView listView;

    private DatabaseReference databaseReference;
    private DatabaseReference booksReference;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();


    private ArrayList<Book> books = new ArrayList<>();
    private BookAdapter bookAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Navigate to next Activity
                //display data from pdf file ?
                //ok ?
                Intent intent = new Intent(MainActivity.this, DetailBookActivity.class);
                intent.putExtra("book", books.get(position));//object must implement Serializable to transport to another Activity

                startActivity(intent);
            }
        });
        readBooksFromFirebase();
    }

    private void readBooksFromFirebase() {
        //gs://a2002gaptech.appspot.com/book1.pdf
        /*
        In Google Storage, we have 2 objects:
        with properties:
        author, name, url, year
        * */
        //test observable from firebase database firstly
        booksReference = firebaseDatabase.getReference("books");
        booksReference.addValueEventListener(new ValueEventListener() {
            //this function is called when you firstly open your app, OR: when database is CHANGED !
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //How to read data from snapshot ?
                HashMap<String, Object> map = (HashMap<String, Object>) dataSnapshot.getValue();
                books.clear();
                for(String key: map.keySet()) {
                    HashMap<String, Object> hashMap = (HashMap<String, Object>) map.get(key);
                    Book book = Book.getFromHashMap(hashMap);
                    books.add(book);
                    System.out.println("haha 1");
                }
                bookAdapter= new BookAdapter(MainActivity.this, books);
                listView.setAdapter(bookAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                books.clear();
                System.out.println("haha error");
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();//
        //because mAuth is NULL !

    }
}

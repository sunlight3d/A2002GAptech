package com.example.myapp;

import android.content.Context;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private Button btnFacebook, btnGoogle;
    private TextView btnRegister;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnFacebook = findViewById(R.id.btnFacebook);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnFacebook.setOnClickListener((View v) -> {
            Toast.makeText(MainActivity.this, "You pressed Facebook", Toast.LENGTH_SHORT).show();
        });
        btnGoogle.setOnClickListener((View v) -> {
            Toast.makeText(MainActivity.this, "You pressed Google", Toast.LENGTH_SHORT).show();
        });
        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener((View v) -> {
            Toast.makeText(MainActivity.this, "You pressed btnRegister", Toast.LENGTH_SHORT).show();
        });
    }

}
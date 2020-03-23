package com.example.myapp;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
//parent class
public class MyActivity extends AppCompatActivity {
    private static int numberOfBackPressed = 0;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(numberOfBackPressed >= 1) {
                    numberOfBackPressed = 0;
                    finish();
                } else {
                    Toast.makeText(MyActivity.this, "Press again to exit", Toast.LENGTH_LONG).show();
                    ++numberOfBackPressed;
                }
            }
        });
    }
}

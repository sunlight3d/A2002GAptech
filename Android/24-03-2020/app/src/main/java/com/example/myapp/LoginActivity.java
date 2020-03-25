package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Server server = new Server();
        //server.setActivity(this);
        server.sendGETRequest(new IMyActivity() {
            @Override
            public void getResponse(Object result, String error) {
                System.out.println("2. do other task...");
            }
        });
    }
}

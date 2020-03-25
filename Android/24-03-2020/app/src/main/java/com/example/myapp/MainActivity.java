package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/*
Example code of sending request to Server/Backend
FROM Mobile app
EXample of api:
GET request
https://jsonplaceholder.typicode.com/photos
For testing request, let's use Postman(from Google)
How to send request from Android ? Many libraries, for example: okhttp
Now install and use it !
* */
public class MainActivity extends AppCompatActivity implements IMyActivity{
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        //call for testing
        Server server = new Server();
        //server.setActivity(this);
        //Toast.makeText(this,"1. Get data okkkkkkk", Toast.LENGTH_SHORT).show();

        //System.out.println("1. Get data okkkkkkk");
        textView.setText("1. Get data okkkkkkk");
        for(int i = 0; i < 10000; i++){
            textView.setText("1. Get data okkkkkkk");
        }
        server.sendGETRequest(this);

    }

    @Override
    public void getResponse(Object result, String error) {
        //Toast.makeText(this,"2. do other task...", Toast.LENGTH_SHORT).show();
        textView.setText("2. do other task...");
    }
/*
    @Override
    public void getResponse(Object result, String error) {
        System.out.println("2. do other task...");
    }
    */

}

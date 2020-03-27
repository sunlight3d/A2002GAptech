package com.example.myapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

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
    ListView listView;

    long dateStart;
    long dateEnd;
    long index = 0;

    final ArrayList<User> users = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //textView = findViewById(R.id.textView);
        //call for testing
        listView=findViewById(R.id.listViewMain);
        //Calulate time to send request
        dateStart = Calendar.getInstance().getTime().getTime();
        index = 0;
        for(int i = 0; i < 10000; i++) {
            Server.getInstance(this).sendGETRequest(this);
        }

    }

    @Override
    public void getResponse(Object result, String error) {
        this.users.clear();
        if (error != null) {
            Toast.makeText(this, "Error loading data :"+error, Toast.LENGTH_LONG).show();
            return;
        }
        //convert result => user ?
        //this.users ?
        index++;
        if(index == 9999) {
            //finished
            dateEnd = Calendar.getInstance().getTime().getTime();
            Toast.makeText(this, "duration time : "+(dateEnd-dateStart)+" miliseconds", Toast.LENGTH_LONG).show();
        }

        /*
        if(result instanceof ArrayList) {
            for(Object item : (ArrayList)result) {
                if(item instanceof User) {
                    MainActivity.this.users.add((User) item);
                }
            }
        }
        MyAdapter adapter=new MyAdapter(this, this.users);
        listView.setAdapter(adapter);
        */
    }


}

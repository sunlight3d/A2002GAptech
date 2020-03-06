package com.example.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;
//Widget = Element = Tag(html). Example: Button, TextView, EditText,...

//Activity = Screeen
//every screen extends from Activity class
public class MainActivity extends AppCompatActivity implements IMyActivity{
    /*
    MainActivity() {
        //constructor ? not necessary, because Android Framework do it for us
    }*/
    private TextView txtHello;
    private EditText txtUserName;
    private Button btnShowMe;
    //AVD = Android Virtual Device = Emulator = Simulator(ios)
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.main_activity);//this read User Interface from main_activity.xml
        mapXMLToUI();
        //How to allow user change text content ? Let's use "EditText element"
        //How to implement the action when press to "Show me" button
        //now write in classic Java
        //btnShowMe.setOnClickListener(this);
        //new way
        /*
        btnShowMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //"this" NOT "MainActivity"
                Toast.makeText(MainActivity.this, "You clicked this button", Toast.LENGTH_LONG).show();
            }
        });
        */
        //way 3: use "lambda function" ?
        btnShowMe.setOnClickListener(view->{
            //Toast.makeText(MainActivity.this, "You clicked this button", Toast.LENGTH_LONG).show();
            System.out.println("You clicked this button");
        });
    }

    @Override
    public void mapXMLToUI() {
        //R = Resource
        this.txtHello = this.findViewById(R.id.txtHello);//map an object in xml file
        this.txtUserName = this.findViewById(R.id.txtUserName);
        this.btnShowMe = findViewById(R.id.btnShowMe);
        //How to change value in txtHello ? Let use setter
        this.txtHello.setText("Hello EVERRYYYY WERHEIRHJ");
        //this.txtHello.setBackgroundResource(R.color.colorRed);
        //How to change to "red"
        Log.d("MAIN", "haha");
    }
}


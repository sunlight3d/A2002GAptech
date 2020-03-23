package com.hean.sqlitecrud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.hean.sqlitecrud.database.DBHandler;
import com.hean.sqlitecrud.database.User;

import java.util.ArrayList;

public class ViewActivity extends AppCompatActivity {

    ListView listView;
    DBHandler dbHandler;
    private ArrayList<User>list = new ArrayList<>();
    private UserAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        listView=findViewById(R.id.listViewShow);
        dbHandler=new DBHandler(this);

        list = dbHandler.getUsers();//this should be list of users
        adapter = new UserAdapter(this, list);
        listView.setAdapter(adapter);


    }
}

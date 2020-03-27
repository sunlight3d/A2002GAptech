package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class MyAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users;
    MyAdapter(Context context, ArrayList<User> users){
        super();
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return this.users.size();
    }

    @Override
    public Object getItem(int position) {
        return this.users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.item,parent,false);
        TextView txtName = row.findViewById(R.id.txtName);
        TextView txtAddress = row.findViewById(R.id.txtAddress);
        TextView txtEmail = row.findViewById(R.id.txtEmail);
        TextView txtPhone = row.findViewById(R.id.txtPhone);
        TextView txtCompany = row.findViewById(R.id.txtCompany);
        TextView txtWebsite = row.findViewById(R.id.txtWebsite);
        TextView txtId = row.findViewById(R.id.txtId);
        //set value
        User selectedUser = this.users.get(position);
        txtId.setText(String.valueOf(selectedUser.getId()));
        txtName.setText(selectedUser.getName());
        txtAddress.setText(selectedUser.getAddress());
        txtEmail.setText(selectedUser.getEmail());
        txtPhone.setText(selectedUser.getPhone());
        txtCompany.setText(selectedUser.getCompany());
        txtWebsite.setText(selectedUser.getWebsite());


        //now set our resources on views
        return row;
    }
}
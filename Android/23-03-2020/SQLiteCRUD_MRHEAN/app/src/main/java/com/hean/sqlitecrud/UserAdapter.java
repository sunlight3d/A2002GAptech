package com.hean.sqlitecrud;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.hean.sqlitecrud.database.User;

import java.util.ArrayList;

public class UserAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<User> users;

    public UserAdapter(Context context, ArrayList<User> users) {
        this.context = context;
        this.users = users;
    }

    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
    }

    @Override
    public long getItemId(int position) {
        return users.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.list_item, null);
            TextView txtName = convertView.findViewById(R.id.txtName);
            TextView txtEmail = convertView.findViewById(R.id.txtEmail);
            TextView txtPhone = convertView.findViewById(R.id.txtPhone);
            //assign data
            User selectedUser = users.get(position);
            txtName.setText(selectedUser.getName()+ " : "+selectedUser.getId());
            txtEmail.setText(selectedUser.getEmail());
            txtPhone.setText(selectedUser.getPhone());
        }
        return convertView;
    }
}

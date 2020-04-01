package com.example.firebaseexample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class BookAdapter extends BaseAdapter {
    private Context context;
    ArrayList<Book> books;

    public BookAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater)context.getApplicationContext()
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(convertView == null) {
            convertView=layoutInflater.inflate(R.layout.row_item,parent,false);
            TextView txtName = convertView.findViewById(R.id.txtName);
            TextView txtAuthor = convertView.findViewById(R.id.txtAuthor);
            Book book = books.get(position);
            txtName.setText(book.getName());
            txtAuthor.setText(book.getAuthor());
        }
        return convertView;
    }
}

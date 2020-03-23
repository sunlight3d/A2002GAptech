package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class MainActivity extends MyActivity {
    //Back action must be applied for all activities(not only MainActivity)
    private ArrayList<Fruit> fruits = new ArrayList<>();
    private ArrayList<Fruit> filteredFruits = new ArrayList<>();
    private GridView gridView;
    private EditText txtSearch;

    public ArrayList<Fruit> getFilteredFruits() {
        final String typedText = txtSearch.getText().toString();
        //filter
        if(typedText.isEmpty()) {
            filteredFruits = fruits;
            return filteredFruits;
        }
        filteredFruits = (ArrayList<Fruit>) fruits.stream()
                .filter(fruit -> fruit.getName().toUpperCase().contains(typedText.toUpperCase()))
                .collect(Collectors.toList());
        return filteredFruits;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fruits.add(new Fruit("Apple", R.drawable.apple));
        fruits.add(new Fruit("Jack fruit", R.drawable.jackfruit));
        fruits.add(new Fruit("Bitter melon", R.drawable.bitter_melon));
        fruits.add(new Fruit("Custard Apple", R.drawable.custard_apple));
        fruits.add(new Fruit("Dragon Fruit", R.drawable.dragon_fruit));
        fruits.add(new Fruit("Grape", R.drawable.grape));
        fruits.add(new Fruit("Kiwi", R.drawable.kiwi));
        fruits.add(new Fruit("Lychee", R.drawable.lychee));
        fruits.add(new Fruit("mangosteen", R.drawable.mangosteen));
        fruits.add(new Fruit("orange", R.drawable.orange));
        fruits.add(new Fruit("peach", R.drawable.peach));
        fruits.add(new Fruit("pomegranate", R.drawable.pomegranate));
        fruits.add(new Fruit("rambutan", R.drawable.rambutan));

        this.gridView = (GridView)findViewById(R.id.gridview);
        txtSearch = findViewById(R.id.txtSearch);
        //1.we must find the listener for "on changed text"
        txtSearch.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable editable) {
                gridView.setAdapter(new FruitAdapter(MainActivity.this, getFilteredFruits()));
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            public void onTextChanged(CharSequence s, int start, int before, int count) {}
        });
        FruitAdapter fruitAdapter = new FruitAdapter(this, getFilteredFruits());
        gridView.setAdapter(fruitAdapter);

    }
}

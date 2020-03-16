package com.example.a16_03_2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.models.Product;

import java.util.ArrayList;


public class ProductsActivity extends AppCompatActivity {
    private ArrayList<Product> products = new ArrayList<>();
    private ListView listViewProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.products_activity);
        listViewProducts = findViewById(R.id.listViewProducts);
        this.generateFakeData();

    }
    private void generateFakeData() {
        //this data is used for testing
        //in practical project, we must have backend and web service
        this.products.add(new Product(1,
                "iphone X",
                "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_x_64gb_3.jpg",
                2016,
                "This is iphone X"
        ));
        this.products.add(new Product(1,
                "iphone 11",
                "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_x_64gb_3.jpg",
                2019,
                "This is iphone X"
        ));
        this.products.add(new Product(1,
                "iphone 6",
                "https://galaxydidong.vn/wp-content/uploads/2017/05/iphone-7-32gb-quoc-te-dep-95-99-3.jpg",
                2019,
                "This is iphone X"
        ));
        this.products.add(new Product(1,
                "iphone 7",
                "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_x_64gb_3.jpg",
                2018,
                "This is iphone 7"
        ));
        this.products.add(new Product(1,
                "iphone X",
                "https://galaxydidong.vn/wp-content/uploads/2017/05/iphone-7-32gb-quoc-te-dep-95-99-3.jpg",
                2016,
                "This is iphone X"
        ));
        this.products.add(new Product(1,
                "iphone 99",
                "https://cdn.cellphones.com.vn/media/catalog/product/cache/7/image/9df78eab33525d08d6e5fb8d27136e95/i/p/iphone_x_64gb_3.jpg",
                2020,
                "This is iphone 7"
        ));
        //what's happen when I clicked each Iem?
        listViewProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = ProductsActivity.this.products.get(position);
                Toast.makeText(ProductsActivity.this, "You clicked :"+product.getProductName(), Toast.LENGTH_LONG)
                        .show();
            }
        });
        //We must create adapter object
        ProductAdapter productAdapter = new ProductAdapter(this, this.products);
        this.listViewProducts.setAdapter(productAdapter);
    }

}

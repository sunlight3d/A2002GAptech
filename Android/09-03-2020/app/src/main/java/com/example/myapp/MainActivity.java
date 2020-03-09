package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helpers.Validation;

public class MainActivity extends AppCompatActivity implements IMyActivity{
    //Define properties(the same name/id with UI Design)
    private TextView textViewX;
    private TextView textViewY;
    private Button btnSum2Numbers;
    private TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        // Get the Intent that started this activity and extract the string
        String email = getIntent().getStringExtra("email");
        Toast.makeText(this, "Email = "+email, Toast.LENGTH_LONG).show();
        mapUIToProperties();
        setupActions();
    }

    @Override
    public void setupActions() {
        btnSum2Numbers.setOnClickListener((view) -> {
            Float x = Float.valueOf(textViewX.getText().toString());
            Float y = Float.valueOf(textViewY.getText().toString());

            if(Validation.validateX(x).length() > 0) {
                Toast.makeText(MainActivity.this, Validation.validateX(x), Toast.LENGTH_LONG).show();
                return;
            }
            if(Validation.validateX(y).length() > 0) {
                Toast.makeText(MainActivity.this, Validation.validateX(y), Toast.LENGTH_LONG).show();
                return;
            }
            txtResult.setText("sum "+x+" + "+y+" = "+(x+y));
        });
    }

    @Override
    public void mapUIToProperties() {
        //We want every dev use this method => let's create interface
        //map UI widgets to properties
        textViewX = findViewById(R.id.textViewX);
        textViewY = findViewById(R.id.textViewY);
        btnSum2Numbers = findViewById(R.id.btnSum2Numbers);
        txtResult = findViewById(R.id.txtResult);
    }
    //Ex2: D2sign 2 EditTexts: Email, Password
    //Validate email ?
    //Password must be at least 2 characters
    //Password must display ****
    //Button must have colors, borders....
    //Don't remove MainActivity, Let create another Activity and change it to Launcher(test)
}

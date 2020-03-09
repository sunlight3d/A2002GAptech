package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helpers.Validation;
import com.example.helpers.ValidationError;

public class LoginActivity extends AppCompatActivity implements IMyActivity {
    private EditText txtEmail;
    private EditText txtPassword;
    private Button btnLogin;
    private Button btnShowAndHideHeader;
    private ConstraintLayout headerBar;
    private Boolean isHideHeader = false;
    private SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mapUIToProperties();
        ((TextView)findViewById(R.id.headerText)).setText("This is login");
        headerBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));
        setupActions();

    }

    @Override
    public void setupActions() {
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidationError validationError = Validation.validateEmail(txtEmail.getText().toString());
                if(validationError != null) {
                    Toast.makeText(LoginActivity.this,
                            validationError.getErrorDetail(),
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                validationError = Validation.validatePassword(txtPassword.getText().toString());
                if(validationError != null) {
                    Toast.makeText(LoginActivity.this,
                            validationError.getErrorDetail(),
                            Toast.LENGTH_LONG)
                            .show();
                    return;
                }
                Toast.makeText(LoginActivity.this,
                        "Email and password are good",
                        Toast.LENGTH_LONG)
                        .show();
                //when you press Login && validation is OK => navigate to MainActivity
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("email", LoginActivity.this.txtEmail.getText().toString());
                //putExtra = send parameters to the Second Activity(MainActivity)
                startActivity(intent);
            }
        });
        btnShowAndHideHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isHideHeader = !isHideHeader;
                headerBar.setVisibility(isHideHeader ?  View.INVISIBLE : View.VISIBLE);
            }
        });
    }

    @Override
    public void mapUIToProperties() {
        //lanscape ?
        //find listener is called when change rotate ?
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnShowAndHideHeader = findViewById(R.id.btnShowHideHeader);
        headerBar = findViewById(R.id.headerBar);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int orientation = newConfig.orientation;
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            Toast.makeText(LoginActivity.this, "Portrait", Toast.LENGTH_LONG).show();
        } else if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            Toast.makeText(LoginActivity.this, "LANDSCAPE", Toast.LENGTH_LONG).show();
        }
        else {
            Toast.makeText(LoginActivity.this, "other", Toast.LENGTH_LONG).show();
        }
    }


}

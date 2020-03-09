package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.graphics.Color;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        mapUIToProperties();
        ((TextView)findViewById(R.id.headerText)).setText("This is login");
        headerBar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorRed));

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
        txtEmail = findViewById(R.id.txtEmail);
        txtPassword = findViewById(R.id.txtPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnShowAndHideHeader = findViewById(R.id.btnShowHideHeader);
        headerBar = findViewById(R.id.headerBar);
    }
}

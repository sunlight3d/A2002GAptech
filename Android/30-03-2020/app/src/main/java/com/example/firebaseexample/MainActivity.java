package com.example.firebaseexample;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Hashtable;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private Button btnLogin;
    private Button btnRegister;
    private Button btnLogout;

    private DatabaseReference databaseReference;
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //firebase is an online database
        //it can store your data, file, authentication's infor
        //login with facebook, username / password,..., gooogle login,...
        //1.setup firebase project in your gmail
        //open your gmail and access to Firebase console
        //firebase can be called by ios/android/web applications
        //login facebook is more complicated, so maybe we will do videos later
        setContentView(R.layout.activity_main);
        //storage allows you to save your images, file,....
        //you can also read your file content, images from storage
        //please use my UI, not UI from Google
        //because we can easily customize as we need
        btnLogin = findViewById(R.id.btnLogin);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogout = findViewById(R.id.btnLogout);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser == null) {
                    Toast.makeText(MainActivity.this, "You donot login", Toast.LENGTH_LONG).show();
                    signInWithEmailAndPassword();
                } else {
                    Toast.makeText(MainActivity.this, "You logged in", Toast.LENGTH_LONG).show();
                    //debug to show detail user
                    //donot need to signin
                }

            }
        });
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseUser currentUser = mAuth.getCurrentUser();
                if(currentUser == null) {
                    Toast.makeText(MainActivity.this, "You donot login", Toast.LENGTH_LONG).show();
                    registerWithEmailAndPassword();
                } else {
                    Toast.makeText(MainActivity.this, "You logged in", Toast.LENGTH_LONG).show();
                    //debug to show detail user
                    //donot need to signin
                    //Please logout firstly
                }
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.this.mAuth.signOut();
            }
        });

        //now test database
        //database here like "json" with key-value pairs

        databaseReference = firebaseDatabase.getReference("photos");
        //databaseReference.setValue("There are some photos..."); //it is a string
        //now I want to save object ?
        String key = databaseReference.push().getKey();
        Map<String, Object> mapPhotos = new Hashtable<>();
        mapPhotos.put("name", "orange");
        mapPhotos.put("url", "https://cdn.fado.vn/images/I/51Tji0K77oL._AC_SR600,600_.jpg");

        Map<String, Object> anotherMap = new Hashtable<>();
        anotherMap.put("/" + key, mapPhotos);
        databaseReference.updateChildren(anotherMap);
        //all multiple objects ?

    }

    private void registerWithEmailAndPassword() {
        //createUserWithEmailAndPassword => sign up
        //if user exists, this function will be failed
        //so you must have 2 buttons:
        //login, register
        //you can also check for existing email / account

        mAuth.createUserWithEmailAndPassword("hoang@gmail.com", "123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(MainActivity.this,
                                    "You logged in with email : "+user.getEmail(),
                                    Toast.LENGTH_LONG).show();
                        } else {
                            //user exist, cannot register
                            //how to dispplay error ?
                            String error = task.getException().toString();
                            Toast.makeText(MainActivity.this,
                                    "createUserWithEmail:failure"+task.getException(),
                                    Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }
    private void signInWithEmailAndPassword() {
        mAuth.signInWithEmailAndPassword("hoang@gmail.com", "123456")
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();

                            Toast.makeText(MainActivity.this,
                                    "You logged in with email : "+user.getEmail(),
                                    Toast.LENGTH_LONG).show();
                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText(MainActivity.this,
                                    "createUserWithEmail:failure"+task.getException(),
                                    Toast.LENGTH_LONG).show();
                            //very userful, donot need backend !
                            // ...
                        }

                        // ...
                    }
                });
    }
    @Override
    protected void onStart() {
        super.onStart();//
        //because mAuth is NULL !

    }
}

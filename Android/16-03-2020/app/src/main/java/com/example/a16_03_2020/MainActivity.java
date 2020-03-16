package com.example.a16_03_2020;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationBuilderWithBuilderAccessor;

public class MainActivity extends AppCompatActivity {
    //SharedPreferences is used for storing data locally
    //After restart your phone, open your app again, data is also exists
    private EditText txtName;
    private Button btnSaveToYourPhone;
    private Button btnSendLocalNotification;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        btnSaveToYourPhone = findViewById(R.id.btnSaveToYourPhone);
        btnSendLocalNotification = findViewById(R.id.btnSendLocalNotification);
        btnSaveToYourPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SAve your name to your local data
                /*
                SharedPreferences sharedPreferences = getApplicationContext()
                        .getSharedPreferences(
                                "myPreference",
                                MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("name", txtName.getText().toString());
                editor.commit();
                */
                //How to read ?
                SharedPreferences sharedPreferences = getApplicationContext()
                        .getSharedPreferences(
                                "myPreference",
                                MODE_PRIVATE);
                String name = sharedPreferences.getString("name", "");//defValue = "default value"= value if it is null
                System.out.println("Haha");
                //SharedPreferences = local storage, save your local data.After you reopen the app again, the data is still exists
                //It used for storing your name/password/email  = "Remember your password"
                //In real project, we store large  data to Local Database(SQLite), DON'T save to text file
                //But: not every data is save to SQLite
                //It must retrieve from the Internet, from your Server using Web Service
                //Notifications: 2 kinds : Local Notification(easy) AND Remote Push Notification(most difficult)
            }
        });
        btnSendLocalNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notification.Builder notification = new Notification
                        .Builder(MainActivity.this)
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("New product")
                        .setContentText("You have new product release");
                NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
                notificationManager.notify(0, notification.build());


            }
        });

    }
}




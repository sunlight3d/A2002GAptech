package com.hean.sqlitecrud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hean.sqlitecrud.database.DBHandler;

public class MainActivity extends AppCompatActivity {

    EditText etId,etName,etEmail,etPhone;
    Button btnAdd,btnUpdate,btnDelete,btnViewAll;
    DBHandler dbHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId=findViewById(R.id.editTextID);
        etName=findViewById(R.id.editTextName);
        etEmail=findViewById(R.id.editTextEmail);
        etPhone=findViewById(R.id.editTextPhone);

        btnAdd=findViewById(R.id.buttonInsert);
        btnUpdate=findViewById(R.id.buttonUpdate);
        btnDelete=findViewById(R.id.buttonDelete);
        btnViewAll=findViewById(R.id.buttonViewAll);

        dbHandler=new DBHandler(this);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(CheckEmpty()==true){
                    return;
                }else {
                    int id = Integer.parseInt(etId.getText().toString());

                    String name = etName.getText().toString();
                    String email = etEmail.getText().toString();
                    String phone = etPhone.getText().toString();

                    boolean status = dbHandler.addUser(id, name, email, phone);
                    if (status) {
                        Toast.makeText(MainActivity.this, "Insert Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Insert Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(CheckEmpty()==true){
                    return;
                }else {
                    int id = Integer.parseInt(etId.getText().toString());
                    String name = etName.getText().toString();
                    String email = etEmail.getText().toString();
                    String phone = etPhone.getText().toString();

                    boolean status = dbHandler.updateUser(id, name, email, phone);
                    if (status) {
                        Toast.makeText(MainActivity.this, "Update Successfully", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Update Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etId.getText().toString().equals("")){
                    Toast.makeText(MainActivity.this,"Please Input ID Before Delete",Toast.LENGTH_SHORT).show();
                    return;
                }else{
                    //Delete, should have Confirmation
                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage("Are you sure you want to exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    MainActivity.this.deleteUser(Integer.parseInt(etId.getText().toString()));
                                }
                            })
                            .setNegativeButton("No", null)
                            .show();

                }
            }
        });

        btnViewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 Intent intent=new Intent(MainActivity.this,ViewActivity.class);
                 startActivity(intent);

            }
        });
        
    }
    private void deleteUser(int id) {
        boolean status = dbHandler.deleteUser(id);
        if (status) {
            Toast.makeText(MainActivity.this, "Delete Successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, "Delete Failed", Toast.LENGTH_SHORT).show();
        }
    }
    public boolean CheckEmpty(){
        if(etId.getText().toString().equals("")||
        etName.getText().toString().equals("")||
        etEmail.getText().toString().equals("")||
        etPhone.getText().toString().equals("")){
            Toast.makeText(MainActivity.this,"Please Input Information",Toast.LENGTH_SHORT).show();
            return true;
        }else
            return false;
    }


}

/**
 * This program demonstrates a mobile app that connects to SQLite database.
 * It is design with Model View Controller design pattern. The code in this file acts
 * as the view of the app.
 * @author  Essa Imhmed
 * Oct 3, 2023
 */

package com.example.helloworldsqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.security.PublicKey;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText txtName, txtTitle, txtPhone, txtOffice, txtStation;
    Model model;
    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtName = findViewById(R.id.txtName);
        txtTitle = findViewById(R.id.txtTile);
        txtPhone = findViewById(R.id.txtPhoneNumber);
        txtOffice = findViewById(R.id.txtOffice);
        txtStation = findViewById(R.id.txtStation);

        model = new Model(this);
        controller = new Controller(model, this);
    }

    public void addUser(View view){
        String name = txtName.getText().toString();
        String title = txtTitle.getText().toString();
        String phone = txtPhone.getText().toString();
        String office = txtOffice.getText().toString();
        String station = txtStation.getText().toString();

        controller.addUser(name, title, phone, office, station);
    }

    public void viewUsers(View view){
        controller.viewUsers();
    }

    public void acknowledge(String message) {
        // Writing Contacts to log
        Log.d("Name: ", message);
    }
}
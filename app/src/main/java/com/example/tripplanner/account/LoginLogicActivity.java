package com.example.tripplanner.account;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripplanner.R;

public class LoginLogicActivity extends AppCompatActivity {
    String id, pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Intent intent = getIntent();
        if(intent != null){
            id = intent.getStringExtra("ID");
            pw = intent.getStringExtra("PW");
        }
    }
}

package com.example.tripplanner.account;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripplanner.R;

public class ForgotAccountFindActivity extends AppCompatActivity {
    private EditText userName, userBirthYear, userBirthMonth, userBirthDate, userID;
    private Button checkID, checkPW;
    private TextView back;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotaccountfind);

        userName = findViewById(R.id.userName);
        userBirthYear = findViewById(R.id.userBirthYear);
        userBirthMonth = findViewById(R.id.userBirthMonth);
        userBirthDate = findViewById(R.id.userBirthDate);
        userID = findViewById(R.id.userID);

        checkID = findViewById(R.id.checkID);
        checkPW = findViewById(R.id.checkPW);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        checkID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String year = userBirthYear.getText().toString();
                String month = userBirthMonth.getText().toString();
                String date = userBirthDate.getText().toString();

                checkInfo(name);
                checkInfo(year);
                checkInfo(month);
                checkInfo(date);
            }
        });

        checkPW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = userID.getText().toString();

                checkInfo(id);
            }
        });

    }

    private void checkInfo(String inputInfo){

    }
}

package com.example.tripplanner.account;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripplanner.R;

public class ForgotAccountFindActivity extends AppCompatActivity {
    private EditText userName, userBirth, userID;
    private Button checkID, checkPW;
    private TextView back;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgotaccountfind);

        userName = findViewById(R.id.userName);
        userBirth = findViewById(R.id.userBirth);
        userID = findViewById(R.id.userID);

        checkID = findViewById(R.id.checkID);
        checkPW = findViewById(R.id.checkPW);

        back = findViewById(R.id.back);
        back.setOnClickListener(v -> onBackPressed());

        checkID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = userName.getText().toString();
                String birth = userBirth.getText().toString();

                checkInfo(name);
                checkInfo(birth);
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

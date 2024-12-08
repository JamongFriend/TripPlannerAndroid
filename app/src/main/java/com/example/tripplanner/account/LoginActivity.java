package com.example.tripplanner.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tripplanner.MainActivity;
import com.example.tripplanner.R;

public class LoginActivity extends AppCompatActivity {
    private EditText emailEditText, passwordEditText;
    private Button loginButton;
    private TextView forgotText, registerText;
    ActivityResultLauncher<Intent> launcher;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        forgotText = findViewById(R.id.forgotText);
        registerText = findViewById(R.id.registerText);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailEditText.getText().toString();
                String pw = passwordEditText.getText().toString();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                intent.putExtra("ID", email);
                intent.putExtra("PW", pw);
                launcher.launch(intent);
            }

        });

        launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(),
                result -> {
            if(result.getResultCode() == LoginActivity.RESULT_OK){
                Intent data = result.getData();
            }
                } );
        //아이디, 비번 찾기 페이지로 이동
        forgotText.setOnClickListener(v -> {
            Intent intent = new Intent(this, ForgotAccountFindActivity.class);
            startActivity(intent);
        });
        //회원가입 페이지로 이동
        registerText.setOnClickListener(v -> {
            Intent intent = new Intent(this, RegisterAccountActivity.class);
            startActivity(intent);
        });
    }
}

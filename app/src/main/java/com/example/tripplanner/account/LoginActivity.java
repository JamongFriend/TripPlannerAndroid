package com.example.tripplanner.account;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tripplanner.MainActivity;
import com.example.tripplanner.R;

public class LoginActivity extends AppCompatActivity {
    //로그인 기능
    private EditText idEditText, passwordEditText;
    private Button loginButton;
    private TextView forgotText, registerText;

    String id, pw;

    @SuppressLint("MissingInflatedId")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        idEditText = findViewById(R.id.idEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        loginButton = findViewById(R.id.loginButton);
        forgotText = findViewById(R.id.forgotText);
        registerText = findViewById(R.id.registerText);

        //로그인 버튼
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = idEditText.getText().toString();
                String pw = passwordEditText.getText().toString();

                check(email, pw);
            }
        });

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

    // 입역한 아이디 비번이 맞는지 확인
    public void check(String id, String pw){
        if(isUserValid(id, pw)){
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "아이디 또는 비밀번호가 틀렸습니다", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isUserValid(String id, String pw){
        return id.equals("ghrb") && pw.equals("1234");
    }
}

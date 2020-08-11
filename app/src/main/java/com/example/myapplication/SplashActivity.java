package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class SplashActivity extends AppCompatActivity {
/*
    변수명 = 설명
    IDtext = id 적는 텍스트박스
    loginbutton = login버튼
    PWtext = pw 적는 텍스트박스
 */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        EditText IDtext = (EditText)findViewById(R.id.editTextTextPersonName);
        EditText PWtext = (EditText)findViewById(R.id.editTextTextPassword);
        Button loginButton = (Button) findViewById(R.id.login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
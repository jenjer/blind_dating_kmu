package com.example.myapplication.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.SplashActivity;


public class SplashRegisterActivity extends AppCompatActivity {
/*
    변수명 = 설명
    IDtext = id 적는 텍스트박스
    loginbutton = login버튼
    PWtext = pw 적는 텍스트박스
*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button registerButton = (Button)findViewById(R.id.register_complete_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                startActivity(intent);
            }
        });
    }

}
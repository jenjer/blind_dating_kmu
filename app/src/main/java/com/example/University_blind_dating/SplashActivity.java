package com.example.University_blind_dating;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.FacebookLogin.LoginCallback;
import com.example.University_blind_dating.ui.splash.RegisterActivity;
import com.example.login_data.Login_data_log;
import com.facebook.CallbackManager;
import com.facebook.GraphRequest;
import com.facebook.login.widget.LoginButton;
import com.facebook.FacebookSdk;


import java.util.Arrays;

import static com.example.login_data.Login_data_log.get_login_data;


public class SplashActivity extends AppCompatActivity {
/*
    변수명 = 설명
    IDtext = id 적는 텍스트박스
    loginbutton = login버튼
    PWtext = pw 적는 텍스트박스
    findButton = 비밀번호 찾기 버튼
*/

    private LoginCallback loginCallback;
    private CallbackManager callbackManager;
    @Override
    protected void onActivityResult(int requestCode,int resultCode, Intent data){
        callbackManager.onActivityResult(requestCode,resultCode,data);
        super.onActivityResult(requestCode,resultCode,data);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //facebook call back manager
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        callbackManager = CallbackManager.Factory.create();
        loginCallback = new LoginCallback();
        LoginButton Button_Facebook_login;
        get_login_data().Auto_login();

        Button_Facebook_login = (LoginButton)findViewById(R.id.Button_facebook_login);
        Button_Facebook_login.setReadPermissions (Arrays.asList("public_profile", "email"));
        Button_Facebook_login.registerCallback(callbackManager,loginCallback);

        Button loginButton = (Button)findViewById(R.id.button_login);
        Button registerButton = (Button)findViewById(R.id.register);
        Button testButton = (Button)findViewById(R.id.testButton);
        Button findButton = (Button)findViewById(R.id.id_pw_find);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });

        testButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                startActivity(intent);
            }
        });
        findButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindActivity.class);
                startActivity(intent);
            }

        });
    }
    public void button_login_onclick(View view2){

    }

}
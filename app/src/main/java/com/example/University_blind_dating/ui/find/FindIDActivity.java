package com.example.University_blind_dating.ui.find;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.University_blind_dating.R;

public class FindIDActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_id);

        EditText inputEmail = (EditText)findViewById(R.id.input_email); // 이메일 입력 EditText
        EditText inputBirthday = (EditText)findViewById(R.id.input_birthday); // 생년월일 입력 EditText
        Button confirmButton = (Button) findViewById(R.id.confirm); // 확인 Button
        TextView viewID = (TextView)findViewById(R.id.view_id); // ID 띄워주는 TextView
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user_email = inputEmail.getText().toString(); // input받은 이메일 저장 변수
                String user_birthday = inputBirthday.getText().toString(); // input받은 생년월일 저장 변수
                Boolean isAccounted = false; // 가입된 유저인지 확인용 boolean

                String user_id = null;
                // todo #DB, user_email과 user_birthday를 확인하여 가입된 회원인지 확인해야함.
                //  가입됐으면 isAcconted = true, user_id에 가입된 아이디 저장

                isAccounted = true; // 테스트용 계정 확인
                user_id = "abcdefghi"; // 테스트용 계정

                if(isAccounted == true){
                    viewID.setText("아이디는 : " + user_id.substring(0, user_id.length()-4) + "**** 입니다.");
                }
                else{
                    Toast.makeText(getApplicationContext(), "등록되지 않은 이메일입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
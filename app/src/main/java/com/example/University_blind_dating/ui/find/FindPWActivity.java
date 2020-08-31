package com.example.University_blind_dating.ui.find;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

import androidx.appcompat.app.AppCompatActivity;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

import android.telephony.SmsManager;

import com.example.University_blind_dating.FindActivity;
import com.example.University_blind_dating.R;
import com.example.University_blind_dating.function.MailSender.GMailSender;

public class FindPWActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_pw);

        // 이메일 관련
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());
        //

        EditText inputEmail = (EditText)findViewById(R.id.input_email);
        EditText inputPhone = (EditText)findViewById(R.id.input_phone);
        EditText inputCertification = (EditText)findViewById(R.id.input_certification);
        Button confirmEmailButton = (Button) findViewById(R.id.confirm_email);
        Button confirmPhoneButton = (Button) findViewById(R.id.confirm_phone);
        Button confirmCertificationButton = (Button) findViewById(R.id.confirm_certification);
        Random randomNum = new Random();

        confirmEmailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_email = inputEmail.getText().toString();
                String output_pw = "1234";

                //todo #DB, input_email을 대조해 맞는 pw 값을 output_pw에 저장해야함, 없으면 null?
                //추후 이름 및 생년월일 대조 추가 가능

                if (output_pw != null) {
                    try {
                        GMailSender gMailSender = new GMailSender("kimpape123@gmail.com", "dating0715");
                        //GMailSender.sendMail(제목, 본문내용, 받는사람);
                        gMailSender.sendMail("dating앱 비밀번호",
                                output_pw,
                                input_email,
                                input_email);
                        Toast.makeText(getApplicationContext(), "이메일을 성공적으로 보냈습니다.", Toast.LENGTH_SHORT).show();
                    } catch (SendFailedException e) {
                        Toast.makeText(getApplicationContext(), "이메일 형식이 잘못되었습니다.", Toast.LENGTH_SHORT).show();
                    } catch (MessagingException e) {
                        Toast.makeText(getApplicationContext(), "인터넷 연결을 확인해주십시오", Toast.LENGTH_SHORT).show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "등록되지 않은 이메일 입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        confirmPhoneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input_phone = inputPhone.getText().toString();
                String output_pw = "1234";

                //todo #DB, input_phone을 대조해 맞는 pw 값을 output_pw에 저장해야함, 없으면 null?
                //추후 이름 및 생년월일 대조 추가 가능

                if (output_pw != null) {
                    String certification_num = Integer.toString(randomNum.nextInt(1000000));
                    try {
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(input_phone, null, certification_num, null, null);
                        Toast.makeText(getApplicationContext(), "인증번호를 성공적으로 보냈습니다.", Toast.LENGTH_SHORT).show();
                    } catch(Exception e) {
                        Toast.makeText(getApplicationContext(), "SMS 전송에 실패하였습니다. 다시 시도해 주십시오.", Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "등록되지 않은 전화번호 입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        confirmCertificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
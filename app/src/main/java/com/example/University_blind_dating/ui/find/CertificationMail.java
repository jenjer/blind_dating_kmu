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
import android.os.CountDownTimer;
import android.view.LayoutInflater;

import javax.mail.MessagingException;
import javax.mail.SendFailedException;

import android.telephony.SmsManager;

import com.example.University_blind_dating.FindActivity;
import com.example.University_blind_dating.R;
import com.example.University_blind_dating.function.MailSender.GMailSender;

import androidx.appcompat.app.AppCompatActivity;

public class CertificationMail extends AppCompatActivity implements View.OnClickListener {

    String randomNum; // 랜덤 인증번호
    boolean isCounted = false; // 카운트 중인지 확인
    boolean isAccounted = false; // 가입되어 있는지 확인

    EditText inputEmail; // 이메일 입력 EditText
    Button sendEmailBtn; // 인증번호 보내기 버튼

    TextView timeCounter; // 남은 시간 보여주는 TextView
    EditText certificationNum; // 인증 번호 입력 EditText
    Button confirmBtn; // 인증 확인 버튼
    CountDownTimer countDownTimer;

    final int MILLISINFUTURE = 180 * 1000; //총 시간 (300초 = 5분)
    final int COUNT_DOWN_INTERVAL = 1000; //onTick 메소드를 호출할 간격 (1초)

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_certification_mail);
        // 이메일 관련
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .permitDiskReads()
                .permitDiskWrites()
                .permitNetwork().build());
        //
        inputEmail = (EditText) findViewById(R.id.input_email);
        sendEmailBtn = (Button) findViewById(R.id.send_email);
        sendEmailBtn.setOnClickListener(this);

        timeCounter = (TextView) findViewById(R.id.time_counter);
        certificationNum = (EditText) findViewById(R.id.certification_num);
        confirmBtn = (Button) findViewById(R.id.confirm_btn);
        confirmBtn.setOnClickListener(this);
    }

    public void countDownTimer() { //카운트 다운 메소드

        countDownTimer = new CountDownTimer(MILLISINFUTURE, COUNT_DOWN_INTERVAL) {
            @Override
            public void onTick(long millisUntilFinished) { //(300초에서 1초 마다 계속 줄어듬)

                long emailAuthCount = millisUntilFinished / 1000;

                if ((emailAuthCount - ((emailAuthCount / 60) * 60)) >= 10) { //초가 10보다 크면 그냥 출력
                    timeCounter.setText((emailAuthCount / 60) + " : " + (emailAuthCount - ((emailAuthCount / 60) * 60)));
                } else { //초가 10보다 작으면 앞에 '0' 붙여서 같이 출력. ex) 02,03,04...
                    timeCounter.setText((emailAuthCount / 60) + " : 0" + (emailAuthCount - ((emailAuthCount / 60) * 60)));
                }
            }

            @Override
            public void onFinish() {
                isCounted = false;
                countDownTimer.cancel();
                countDownTimer = null;
            }
        }.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_email:
                if(isCounted == true)
                {
                    countDownTimer.cancel();
                    countDownTimer = null;
                    isCounted = false;
                }
                isCounted = true;

                String input_email = inputEmail.getText().toString();
                // todo #DB : input_email을 확인하여 가입된 회원인지 확인해야함
                //  있으면 isAccounted = true, 없으면 isAccounted = false
                isAccounted = true; // 테스트용 임시 계정 확인

                if(isAccounted == true) {
                    Random random = new Random();
                    randomNum = Integer.toString(random.nextInt(1000000));
                    System.out.println(randomNum);
                    try {
                        GMailSender gMailSender = new GMailSender("kimpape123@gmail.com", "dating0715"); //todo 보안 설정
                        //GMailSender.sendMail(제목, 본문내용, 받는사람);
                        gMailSender.sendMail("dating앱 인증번호",
                                randomNum,
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
                    countDownTimer();
                } else {
                    Toast.makeText(getApplicationContext(), "등록되지 않은 이메일 입니다.", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.confirm_btn: //다이얼로그 내의 인증번호 인증 버튼을 눌렀을 시
                if (isCounted == true) {
                    System.out.println(randomNum);
                    String inputNum = certificationNum.getText().toString();
                    System.out.println(inputNum);
                    if (inputNum.equals(randomNum)) {
                        Toast.makeText(this, "이메일 인증 성공", Toast.LENGTH_SHORT).show();
                        //todo : 비밀번호 재설정 페이지로 이동해야함
                    } else {
                        Toast.makeText(this, "이메일 인증 실패", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "인증번호를 전송해주세요", Toast.LENGTH_SHORT).show();
                } break;
        }
    }
}
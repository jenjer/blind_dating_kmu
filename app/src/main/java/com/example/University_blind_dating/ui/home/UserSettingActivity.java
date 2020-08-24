package com.example.University_blind_dating.ui.home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.University_blind_dating.R;
import com.example.University_blind_dating.ui.home.settings.CommunityRulesActivity;
import com.example.University_blind_dating.ui.home.settings.MembershipWithdrawalActivity;
import com.example.University_blind_dating.ui.home.settings.MessageSettingActivity;
import com.example.University_blind_dating.ui.home.settings.NoticeActivity;
import com.example.University_blind_dating.ui.home.settings.NotificationSettingActivity;
import com.example.University_blind_dating.ui.home.settings.PasswordSettingActivity;
import com.example.University_blind_dating.ui.home.settings.PrivacyPolicyActivity;
import com.example.University_blind_dating.ui.home.settings.SchoolCertificationActivity;
import com.example.University_blind_dating.ui.home.settings.SetInfoConsentActivity;
import com.example.University_blind_dating.ui.home.settings.SuggestionsQuestionsSettingActivity;
import com.example.University_blind_dating.ui.home.settings.UserImageActivity;
import com.example.University_blind_dating.ui.home.settings.UserInfoChangeActivity;

public class UserSettingActivity extends AppCompatActivity{

    class BtnOnClickListener implements Button.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                // -----계정-----
                case R.id.user_Image :
                    ImageView user_image = (ImageView)findViewById(R.id.user_Image);
                    user_image.setImageResource(R.drawable.ic_human_icon);
                    Intent user_image_activity = new Intent(getApplicationContext(), UserImageActivity.class);
                    startActivity(user_image_activity);
                    break ;
                case R.id.school_certification :
                    Intent school_certification = new Intent(getApplicationContext(), SchoolCertificationActivity.class);
                    startActivity(school_certification);
                    break ;
                case R.id.user_info_change :
                    Intent user_info_change = new Intent(getApplicationContext(), UserInfoChangeActivity.class);
                    startActivity(user_info_change);
                    break ;


                // -----앱 설정-----
                case R.id.notification_setting :
                    Intent notification_setting = new Intent(getApplicationContext(), NotificationSettingActivity.class);
                    startActivity(notification_setting);
                    break ;
                case R.id.message_setting :
                    Intent message_setting = new Intent(getApplicationContext(), MessageSettingActivity.class);
                    startActivity(message_setting);
                    break ;
                case R.id.password_setting :
                    Intent password_setting = new Intent(getApplicationContext(), PasswordSettingActivity.class);
                    startActivity(password_setting);
                    break ;
                // -----앱 정보-----
                case R.id.suggestions_questions :
                    Intent suggestions_question = new Intent(getApplicationContext(), SuggestionsQuestionsSettingActivity.class);
                    startActivity(suggestions_question);
                    break ;
                case R.id.notice :
                    Intent notice = new Intent(getApplicationContext(), NoticeActivity.class);
                    startActivity(notice);
                    break ;
                case R.id.community_rules :
                    Intent community_rules = new Intent(getApplicationContext(), CommunityRulesActivity.class);
                    startActivity(community_rules);
                    break ;
                case R.id.privacy_policy :
                    Intent privacy_policy = new Intent(getApplicationContext(), PrivacyPolicyActivity.class);
                    startActivity(privacy_policy);
                    break ;

                // -----기타-----
                case R.id.set_info_consent :
                    Intent set_info_consent = new Intent(getApplicationContext(), SetInfoConsentActivity.class);
                    startActivity(set_info_consent);
                    break ;

                // -----계정 관리-----
                case R.id.membership_withdrawal :
                    Intent membership_withdrawal = new Intent(getApplicationContext(), MembershipWithdrawalActivity.class);
                    startActivity(membership_withdrawal);
                    break ;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_setting);

        // BtnOnClickListener의 객체 생성.
        BtnOnClickListener onClickListener = new BtnOnClickListener() ;

        // 각 Button의 이벤트 리스너로 onClickListener 지정.
        // -----계정-----
        ImageView user_image = (ImageView)findViewById(R.id.user_Image) ;
        user_image.setOnClickListener(onClickListener) ;
        Button school_certification_button = (Button) findViewById(R.id.school_certification) ;
        school_certification_button.setOnClickListener(onClickListener) ;
        Button user_info_change = (Button) findViewById(R.id.user_info_change) ;
        user_info_change.setOnClickListener(onClickListener) ;
        // 로그아웃 AlertDialog
        Button logout_button = (Button)findViewById(R.id.user_logout);
        logout_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_logout();
            }
        });
        // -----앱 설정-----
        Button notification_setting = (Button) findViewById(R.id.notification_setting) ;
        notification_setting.setOnClickListener(onClickListener) ;
        Button message_setting = (Button) findViewById(R.id.message_setting) ;
        message_setting.setOnClickListener(onClickListener) ;
        Button password_setting = (Button) findViewById(R.id.password_setting) ;
        password_setting.setOnClickListener(onClickListener) ;
        // -----앱 정보-----
        // 앱 버전 AlertDialog
        Button app_version_button = (Button)findViewById(R.id.app_version);
        app_version_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_app_version();
            }
        });
        Button suggestions_questions = (Button) findViewById(R.id.suggestions_questions) ;
        suggestions_questions.setOnClickListener(onClickListener) ;
        Button notice = (Button) findViewById(R.id.notice) ;
        notice.setOnClickListener(onClickListener) ;
        Button community_rules = (Button) findViewById(R.id.community_rules) ;
        community_rules.setOnClickListener(onClickListener) ;
        Button privacy_policy = (Button) findViewById(R.id.privacy_policy) ;
        privacy_policy.setOnClickListener(onClickListener) ;
        // 오픈소스 라이선스 AlertDialog
        Button open_source_license_button = (Button)findViewById(R.id.open_source_license);
        open_source_license_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_open_source_license();
            }
        });

        // -----기타-----
        Button set_info_consent = (Button) findViewById(R.id.set_info_consent) ;
        set_info_consent.setOnClickListener(onClickListener) ;
        // -----계정 관리-----
        Button membership_withdrawal = (Button) findViewById(R.id.membership_withdrawal) ;
        membership_withdrawal.setOnClickListener(onClickListener) ;

    }
    // 로그아웃 함수 !----------------- 기능 구현 필요-------------------
    void show_logout()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("로그아웃");
        builder.setMessage("로그아웃 하시겠습니까?");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"예를 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.setNegativeButton("아니오",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"아니오를 선택했습니다.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }
    // 앱 버전 함수 !----------------- 기능 구현 필요-------------------
    void show_app_version()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("앱 버전");
        builder.setMessage("최신버전입니다.");
        builder.show();
    }

    // 오픈소스 라이선스 !--------------- 내용 추가 ----------------------
    void show_open_source_license()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("오픈소스 라이선스");
        builder.setMessage("김영수법에 의거하여 오픈소스를 썼음");
        builder.setNegativeButton("닫기",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getApplicationContext(),"닫아버렸음.",Toast.LENGTH_LONG).show();
                    }
                });
        builder.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼
        getSupportActionBar().setTitle("내 정보");
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
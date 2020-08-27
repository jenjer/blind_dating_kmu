package com.example.University_blind_dating;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.University_blind_dating.ui.home.UserSettingActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_chatting, R.id.navigation_meeting).build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 활성화                                        //TODO 정후 : 네비게이션 이동 이후 내 정보 사라지는 버그 수정 못할 시 삭제
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_user); // 뒤로가기 버튼 설정 아이콘으로 변경                  // 버그 수정 못할 시 삭제
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){ // 뒤로가기 버튼                                                                        // 버그 수정 못할 시 삭제
            Intent user_setting_activity = new Intent(this, UserSettingActivity.class); // 뒤로가기 버튼을 설정으로 변경 // 버그 수정 못할 시 삭제
            startActivity(user_setting_activity);                                                                            // 버그 수정 못할 시 삭제
        }                                                                                                                    // 버그 수정 못할 시 삭제
        return super.onOptionsItemSelected(item);
    }
}
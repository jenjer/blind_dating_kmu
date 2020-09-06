package com.example.University_blind_dating.ui.home.settings;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.University_blind_dating.R;

public class NoticeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting_notice);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar_actions, menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 달기
        getSupportActionBar().setTitle("공지사항");
        menu.findItem(R.id.write).setVisible(true); // 액션바 write 활성화
        return super.onCreateOptionsMenu(menu);
    }
    //뒤로가기 버튼 기능
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        if (id == R.id.write){
            Toast.makeText(getApplicationContext(), "글쓰기 만들어야됨", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}

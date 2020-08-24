package com.example.University_blind_dating.ui.home.settings;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.example.University_blind_dating.R;

public class UserImageActivity extends AppCompatActivity {

    @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_user_image);
            ImageView imageView = (ImageView) findViewById(R.id.user_image_view);
            imageView.setImageResource(R.drawable.ic_human_icon);
        }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 달기
        getSupportActionBar().setTitle("내 사진");
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
        return super.onOptionsItemSelected(item);
    }
}

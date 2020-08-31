package com.example.University_blind_dating;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.University_blind_dating.R;
import com.example.University_blind_dating.ui.find.FindIDActivity;
import com.example.University_blind_dating.ui.find.FindPWActivity;

public class FindActivity extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_register);
        Button id_button = (Button) findViewById(R.id.find_id_button);
        id_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindIDActivity.class);
                startActivity(intent);
            }
        });

        Button pw_button = (Button) findViewById(R.id.find_pw_button);
        pw_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), FindPWActivity.class);
                startActivity(intent);
            }
        });
    }
}

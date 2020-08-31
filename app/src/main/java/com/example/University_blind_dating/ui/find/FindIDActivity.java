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
        EditText inputEmail = (EditText)findViewById(R.id.input_email);
        Button confirmButton = (Button) findViewById(R.id.confirm);
        final TextView viewID = (TextView)findViewById(R.id.view_id);
        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String input_email = inputEmail.getText().toString();
                String output_id = null;
                // todo #DB, input_email을 대조해 맞는 id 값을 output_id에 저장해야함, 없으면 null?
                if(output_id != null){
                    viewID.setText(output_id);
                }
                else{
                    Toast.makeText(getApplicationContext(), "등록되지 않은 이메일입니다.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
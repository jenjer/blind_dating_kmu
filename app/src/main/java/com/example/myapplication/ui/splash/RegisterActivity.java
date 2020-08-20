package com.example.myapplication.ui.splash;
import com.example.myapplication.*;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Collage_adapter.Collage_find_adapter;

public class RegisterActivity extends AppCompatActivity {
   private Collage_find_adapter adapter;
    public void init(){
        List<String> Collage_list = new ArrayList<String>();
        Collage_list.add("계명대");
        Collage_list.add("계명대1");
        Collage_list.add("계명대2");
        adapter = new Collage_find_adapter(this,Collage_list);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        EditText EditText_find_collage = (EditText)findViewById(R.id.EditText_find_collage);
        EditText_find_collage.addTextChangedListener(new TextWatcher(){
            @Override
            public void afterTextChanged(Editable arg0){
                String text = EditText_find_collage.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }
            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3){

            }
            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3){

            }
        });




        // 레지스터 버튼 및 기능
        Button registerButton = (Button)findViewById(R.id.register_complete_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                startActivity(intent);
            }
        });
    }
}
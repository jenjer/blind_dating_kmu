package com.example.myapplication.ui.splash;
import com.example.myapplication.*;
import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import Collage_adapter.Collage_find_adapter;

public class RegisterActivity extends AppCompatActivity {
   private Collage_find_adapter adapter;
    ListView listView;
    EditText EditText_find_collage;
    //if untact textview then remove list view code
    boolean check =false;

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View focusView = getCurrentFocus();
        if (focusView != null) {
            Rect rect = new Rect();
            focusView.getGlobalVisibleRect(rect);
            int x = (int) ev.getX(), y = (int) ev.getY();
            if (!rect.contains(x, y)) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm != null) {
                    View.OnClickListener listener_listview = new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            switch (view.getId()) {
                                case R.id.Listview_find_collage:
                                    Toast.makeText(getApplicationContext(), "onclick", Toast.LENGTH_LONG).show();
                                    check = true;
                                    break;
                            }
                        }
                    };
                   // if(check == false)
                      //  listView.setVisibility(View.INVISIBLE);
                   // else
                       // check = false;
                    focusView.clearFocus();
                }
            }
        }
            return super.dispatchTouchEvent(ev);
    }
    //each listview item click event
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        List<String> Collage_list = new ArrayList<String>();
        Collage_list.add("계명대");
        Collage_list.add("계명대1");
        Collage_list.add("계명대2");

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        listView = (ListView)findViewById(R.id.Listview_find_collage);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EditText_find_collage.setText(Collage_list.get(position));
                Toast.makeText(getApplicationContext(),"onclick",Toast.LENGTH_LONG).show();
            }
        });


        adapter = new Collage_find_adapter(this,Collage_list);
        listView.setAdapter(adapter);

        EditText_find_collage = (EditText)findViewById(R.id.EditText_find_collage);

        EditText_find_collage.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    listView.setVisibility(View.VISIBLE);
                }
                return false;
            }
        });
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
package com.example.University_blind_dating.ui.splash;
import com.example.University_blind_dating.*;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.example.University_blind_dating.R;

import java.util.ArrayList;
import java.util.List;

import Collage_adapter.Collage_find_adapter;

public class RegisterActivity extends AppCompatActivity {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private Collage_find_adapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    private static Context mContext;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mContext = getApplicationContext();//현재 콘텍스트 저장

        final AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.AutoCompleteTextView_find_collage);

        editSearch = (EditText) findViewById(R.id.AutoCompleteTextView_find_collage);
        listView = (ListView) findViewById(R.id.Listview_find_collage);
        //make list
        list = new ArrayList<String>();
        //검색에 사용할 데이터를 가져온다.
        settingList();
        autoCompleteTextView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,list));

        //리스트의 모든 데이터를 arraylist에 복사한다.(list 복사본을 만든다)
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);
        //리스트에 연동될 아답터를 생성한다.
        adapter = new Collage_find_adapter(list, this);
        //리스트뷰에 아답터를 연동한다.
        listView.setAdapter(adapter);
        //input창에 검색어를 입력시 "addTextChangeListener"이벤트 리스너를 정의한다.
        editSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //input창에 문자를 입력할 때 마다 호출되며 search메소드를 호출할것
                String text = editSearch.getText().toString();
                search(text);
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
    //search메소드 구현
    public void search(String charText){
        //문자 입력시마다 리스트를 지우고 새로 뿌릴것
        list.clear();
        //문자 입력이 없을 때는 아무일도 하지 않는다.
        if(charText.length()==0){
            list.addAll(arraylist);
        }
        else{
            //리스트의 모든 데이터를 검색한다.
            for(int i=0;i<arraylist.size();i++){
                //arraylist의 모든 데이터에 입력받은 단어가 있으면 true를 반환
                if(arraylist.get(i).toLowerCase().contains(charText)){
                    list.add(arraylist.get(i));
                }
            }
        }
        //리스트 데이터가 변경되었으므로 아답터를 갱신해 검색된 데이터를 화면에 보여줌
        adapter.notifyDataSetChanged();
    }
    //todo 검색에 사용될 데이터를 리스트에 추가하는 메소드
    private void settingList(){
        list.add("계명대");
        list.add("계명대1");
        list.add("계명대2");
        list.add("계명대3");
        list.add("계명대4");
        list.add("계명대5");
    }
    public static Context getContext(){
        return mContext;//콘텍스트 리턴해주는 함수
    }
}
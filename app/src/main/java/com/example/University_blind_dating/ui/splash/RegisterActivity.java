package com.example.University_blind_dating.ui.splash;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

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
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.University_blind_dating.MainActivity;
import com.example.University_blind_dating.R;
import com.example.University_blind_dating.SplashActivity;
import com.example.University_blind_dating.db.splashDB.RegisterRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import Collage_adapter.Collage_find_adapter;

public class RegisterActivity extends AppCompatActivity {

    private List<String> list;          // 데이터를 넣은 리스트변수
    private ListView listView;          // 검색을 보여줄 리스트변수
    private EditText editSearch;        // 검색어를 입력할 Input 창
    private EditText editUserID;        // 유저 아이디를 받는 Input 창
    private EditText editUserPW1;        // 유저 비밀번호를 받는 Input 창
    private EditText editUserPW2;        // 유저 비밀번호 확인을 받는 Input 창
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
        editUserID = (EditText) findViewById(R.id.editText_NewID);
        editUserPW1 = (EditText) findViewById(R.id.editText_UserPW1);
        editUserPW2 = (EditText) findViewById(R.id.editText_UserPW2);

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
                String userID = editUserID.getText().toString(); //입력된 아이디를 스트링값으로
                String userPW1 = editUserPW1.getText().toString(); //입력된 비밀번호1을 스트링값으로
                String userPW2 = editUserPW2.getText().toString(); //입력된 비밀번호2를 스트링값으로

                if(userID.length() != 0 && userPW1.length() != 0 && userPW2.length() != 0 && userPW1.equals(userPW2)){
                    Response.Listener<String> responseListener = new Response.Listener<String>() { //DB와 통신을 요청한다, php문에 에러가 없으면 success반납 php문은 서버안에 담겨져있고, 파일질라를 통해 php문을 넣게된다.
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                boolean success = jsonObject.getBoolean("success");
                                if (success) { //success를 반납받으면 (php문에서 질의문을 보낸 후 응답을 제대로 받게되면 success를 반납하게 된다)
                                    Toast.makeText(getApplicationContext(), "회원등록에 성공하였습니다.", Toast.LENGTH_SHORT).show();

                                    Intent intent = new Intent(getApplicationContext(), SplashActivity.class);
                                    startActivity(intent);
                                } else { //success반납받지 못하면 (php문에서 질의문에 에러가 있을 시 success를 반납받지 못하게 된다. else문 안의 토스트메시지가 뜬다면 php문안의 질의문을 확인해주세요. //php문 안의 문법을 틀릴시에도 success반납을 못받습니다.
                                    Toast.makeText(getApplicationContext(), "에러!", Toast.LENGTH_SHORT).show();
                                    return;
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    };
                    //서버로 volley를 이용해서 요청
                    RegisterRequest registerrequest = new RegisterRequest(userID, userPW1, responseListener); //RegisterRequest로 인스턴스 생성
                    RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this); //큐를 생성하여 요청문(registerRequest)를 넣고 해당 순서가 되면 큐에서 나가게 됩니다.
                    queue.add(registerrequest); //큐에 해당 리퀘스트 삽입

                }else if(userID.length() == 0){ //ID값이 없을때
                    Toast.makeText(getApplicationContext(), "아이디를 입력해주세요!", Toast.LENGTH_SHORT).show();
                }else if(userPW1.length() == 0 || userPW2.length() == 0){ //PW값이 없을때
                    Toast.makeText(getApplicationContext(), "비밀번호를 입력해주세요!", Toast.LENGTH_SHORT).show();
                }else if(!userPW1.equals(userPW2)){ //두 PW값이 다를때
                    Toast.makeText(getApplicationContext(), "두 비밀번호가 같지 않습니다!", Toast.LENGTH_SHORT).show();
                }


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
package com.example.University_blind_dating.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.University_blind_dating.R;

import java.util.ArrayList;
import java.util.List;

import Collage_adapter.Collage_find_adapter;
import Collage_adapter.Community_adapter;

public class HomeFragment extends Fragment {

    private List<String> list;          // 커뮤니티 제목 데이터를 넣은 리스트변수
    private List<String> list_Community_text; //커뮤니티 내용 데이터를 넣은 리스트변수
    private ListView listView_community;          // 검색을 보여줄 리스트변수
    private Community_adapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    private ArrayList<String> arraylist_community_text_cp;//커뮤니티 내용 복사해 저장할 리스트변수
    //현재 fragment 를 리턴해주는 함수
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
    private HomeViewModel homeViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        Button Chat_button = (Button)root.findViewById(R.id.Button_Fragment_Chat);
        Chat_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_chatting);
            }
        });

        //start for listview _community
        listView_community = (ListView)root.findViewById(R.id.ListView_Community);
        //make list
        list = new ArrayList<String>();
        list_Community_text = new ArrayList<String>();
        //검색에 사용할 데이터를 가져온다.
        settingList();
        setting_Community_List();
        //리스트의 모든 데이터를 arraylist에 복사한다.(list 복사본을 만든다)
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        arraylist_community_text_cp = new ArrayList<String>();
        arraylist_community_text_cp.addAll(list_Community_text);
        //리스트에 연동될 아답터를 생성한다.
        adapter = new Community_adapter(list, getActivity(),list_Community_text);
        //리스트뷰에 아답터를 연동한다.
        listView_community.setAdapter(adapter);
        return root;

    }

    //todo 게시판 제목 데이터를 리스트에 추가하는 메소드
    private void settingList(){
        list.add("계명대");
        list.add("계명대1");
        list.add("계명대2");
        list.add("계명대3");
        list.add("계명대4");
        list.add("계명대5");
    }
    //todo 게시판 내용 데이터를 리스트에 추가하는 메소드
    private void setting_Community_List(){
        list_Community_text.add("계명대 내용1");
        list_Community_text.add("계명대1 내용1");
        list_Community_text.add("계명대2 내용1");
        list_Community_text.add("계명대3");
        list_Community_text.add("계명대4");
        list_Community_text.add("계명대5");
    }









    /*------------------Actionbar of Home Fragment-------------------*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actionbar_actions, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Actionbar item click event
        int id = item.getItemId();
        if (id == R.id.user_settings){
            //Toast.makeText(getActivity(), "Settings", Toast.LENGTH_SHORT).show();
            Intent user_setting_activity = new Intent(this.getContext(), UserSettingActivity.class);
            startActivity(user_setting_activity);
        }
        if (id == R.id.home_search){
            //Toast.makeText(getActivity(), "Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
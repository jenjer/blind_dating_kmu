package com.example.University_blind_dating.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.University_blind_dating.R;

import java.util.ArrayList;
import java.util.List;

import Collage_adapter.Dashboard_adapter;

public class DashboardFragment extends Fragment {
    private List<String> list;          // 커뮤니티 제목 데이터를 넣은 리스트변수
    private List<String> list_Dashboard_text; //커뮤니티 내용 데이터를 넣은 리스트변수
    private List<String> list_metadata;
    //todo 이미지 추가할때 주석해제 private List<이미지 자료형> list_profile;
    private ListView listView_Dashboard;          // 검색을 보여줄 리스트변수
    private Dashboard_adapter adapter;      // 리스트뷰에 연결할 아답터
    private ArrayList<String> arraylist;
    private ArrayList<String> arraylist_community_text_cp;//커뮤니티 내용 복사해 저장할 리스트변수

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        //start for listview _community
        listView_Dashboard = (ListView)root.findViewById(R.id.ListView_dashboard);
        //make list
        list = new ArrayList<String>();
        list_Dashboard_text = new ArrayList<String>();
        list_metadata = new ArrayList<String>();
        //검색에 사용할 데이터를 가져온다.
        settingList();
        setting_dashboard_List();
        setting_dashboard_metadata();
        //todo 이미지 추가할때 주석해제 setting_profile_image();
        //리스트의 모든 데이터를 arraylist에 복사한다.(list 복사본을 만든다)
        arraylist = new ArrayList<String>();
        arraylist.addAll(list);

        arraylist_community_text_cp = new ArrayList<String>();
        arraylist_community_text_cp.addAll(list_Dashboard_text);
        //리스트에 연동될 아답터를 생성한다.
        adapter = new Dashboard_adapter(list, getActivity(),list_Dashboard_text,list_metadata);
        //리스트뷰에 아답터를 연동한다.
        listView_Dashboard.setAdapter(adapter);
        ListView list_move_dash = (ListView)root.findViewById(R.id.ListView_Community);



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
        list.add("계명대6");
        list.add("계명대7");
        list.add("계명대8");
    }
    //todo 데시보드  내용 데이터를 리스트에 추가하는 메소드
    private void setting_dashboard_List(){
        list_Dashboard_text.add("계명대 내용1");
        list_Dashboard_text.add("계명대1 내용1");
        list_Dashboard_text.add("계명대2 내용1");
        list_Dashboard_text.add("계명대3");
        list_Dashboard_text.add("계명대4");
        list_Dashboard_text.add("계명대5");
        list_Dashboard_text.add("계명대6");
        list_Dashboard_text.add("계명대7");
        list_Dashboard_text.add("계명대8");
    }
    private void setting_dashboard_metadata(){
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
        list_metadata.add("댓글 n 개 , 이미지 o");
    }
    /*todo 이미지 추가할 때 주석 해제하며 자료형 추가
    private void setting_profile_image(){
        list_profile.add("이미지")
        ...

    }
    */



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);

    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.actionbar_actions, menu);
        menu.findItem(R.id.dashboard_search).setVisible(true);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Actionbar item click event
        int id = item.getItemId();
        if (id == R.id.dashboard_search){
            //Toast.makeText(getActivity(), "Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
package com.example.University_blind_dating.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.example.University_blind_dating.R;

public class HomeFragment extends Fragment {

    //현재 fragment 를 리턴해주는 함수
    public static HomeFragment newInstance(){
        return new HomeFragment();
    }
    private HomeViewModel homeViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        final TextView textView = root.findViewById(R.id.text_home);
        Button Chat_button = (Button)root.findViewById(R.id.Button_Fragment_Chat);
        Chat_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Navigation.findNavController(root).navigate(R.id.action_navigation_home_to_navigation_chatting);
            }
        });


        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;

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
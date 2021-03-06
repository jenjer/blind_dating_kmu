package com.example.University_blind_dating.ui.chatting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.University_blind_dating.R;

public class ChattingFragment extends Fragment {

    private ChattingViewModel chattingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        chattingViewModel = ViewModelProviders.of(this).get(ChattingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chatting, container, false);

        return root;
    }
}
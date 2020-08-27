package com.example.University_blind_dating.ui.meeting;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.example.University_blind_dating.R;

public class MeetingFragment extends Fragment {

    private MeetingViewModel meetingViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        meetingViewModel = ViewModelProviders.of(this).get(MeetingViewModel.class);
        View root = inflater.inflate(R.layout.fragment_meeting, container, false);

        return root;
    }
    /*------------------Actionbar of Home Fragment-------------------*/
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.actionbar_actions, menu);
        // hide item (settings)
        menu.findItem(R.id.user_settings).setVisible(false);
        menu.findItem(R.id.likes).setVisible(false);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // Actionbar item click event
        int id = item.getItemId();
        if (id == R.id.home_search){
            Toast.makeText(getActivity(), "Search", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
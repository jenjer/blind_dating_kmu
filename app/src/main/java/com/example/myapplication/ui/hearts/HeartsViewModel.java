package com.example.myapplication.ui.hearts;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class HeartsViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public HeartsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is hearts fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
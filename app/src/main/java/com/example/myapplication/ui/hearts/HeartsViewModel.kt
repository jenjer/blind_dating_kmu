package com.example.myapplication.ui.hearts

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HeartsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is hearts Fragment"
    }
    val text: LiveData<String> = _text
}
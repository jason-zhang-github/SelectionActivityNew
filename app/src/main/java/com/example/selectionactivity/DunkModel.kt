package com.example.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel

class DunkModel : ViewModel()
{
    private final MutableLiveData<User> userLiveData = new MutableLiveData<>()
}
package com.example.selectionactivity

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData


class DunkModel : ViewModel()
{
    val dunk = MutableLiveData<Dunk>()

    fun getDunk() : LiveData<Dunk>
    {
        return dunk
    }

    fun setDunk(_dunk : Dunk)
    {
        dunk.value = _dunk
    }



}
package com.xxm.jetpackdemo.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    public val data = MutableLiveData<String>()

    init {
        data.value = "Hello World"
    }

}
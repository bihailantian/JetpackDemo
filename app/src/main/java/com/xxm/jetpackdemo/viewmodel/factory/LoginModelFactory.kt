package com.xxm.jetpackdemo.viewmodel.factory

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xxm.jetpackdemo.db.repository.UserRepository
import com.xxm.jetpackdemo.viewmodel.LoginModel

class LoginModelFactory(private val repository: UserRepository, private val context: Context) :
    ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginModel(repository, context) as T
    }
}
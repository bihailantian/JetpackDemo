package com.xxm.jetpackdemo.viewmodel.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.xxm.jetpackdemo.db.repository.ShoeRepository
import com.xxm.jetpackdemo.viewmodel.ShoeModel

class ShoeModelFactory( private val repository: ShoeRepository
) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ShoeModel(repository) as T
    }
}
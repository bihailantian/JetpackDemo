package com.xxm.jetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.xxm.jetpackdemo.db.data.Shoe
import com.xxm.jetpackdemo.db.repository.ShoeRepository

class FavouriteModel(private val shoeRepository: ShoeRepository, private val userId:Long) :
    ViewModel() {
    // 鞋子集合的观察类
    val shoes: LiveData<List<Shoe>> = shoeRepository.getShoesByUserId(userId)
}
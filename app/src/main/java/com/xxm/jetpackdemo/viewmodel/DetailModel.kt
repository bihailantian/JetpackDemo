package com.xxm.jetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.xxm.jetpackdemo.db.data.FavouriteShoe
import com.xxm.jetpackdemo.db.data.Shoe
import com.xxm.jetpackdemo.db.repository.FavouriteShoeRepository
import com.xxm.jetpackdemo.db.repository.ShoeRepository

class DetailModel constructor(shoeRepository: ShoeRepository, favouriteShoeRepository: FavouriteShoeRepository, shoeId: Long, userId:Long) :
    ViewModel() {

    // 鞋
    val shoe: LiveData<Shoe> = shoeRepository.getShoeById(shoeId)

    // 收藏记录
    val favouriteShoe:LiveData<FavouriteShoe?> = favouriteShoeRepository.findFavouriteShoe(userId,shoeId)
}
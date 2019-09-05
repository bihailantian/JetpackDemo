package com.xxm.jetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xxm.jetpackdemo.db.data.FavouriteShoe
import com.xxm.jetpackdemo.db.data.Shoe
import com.xxm.jetpackdemo.db.repository.FavouriteShoeRepository
import com.xxm.jetpackdemo.db.repository.ShoeRepository
import kotlinx.coroutines.launch

class DetailModel constructor(
    shoeRepository: ShoeRepository,
    private val favouriteShoeRepository: FavouriteShoeRepository,
    private val shoeId: Long,
    private val userId: Long
) : ViewModel() {


    // 鞋
    val shoe: LiveData<Shoe> = shoeRepository.getShoeById(shoeId)

    // 收藏记录
    val favouriteShoe: LiveData<FavouriteShoe?> =
        favouriteShoeRepository.findFavouriteShoe(userId, shoeId)

    /**
     * 收藏一双鞋
     */
    fun favourite() {
        viewModelScope.launch {
            favouriteShoeRepository.createFavouriteShoe(userId, shoeId)
        }
    }
}
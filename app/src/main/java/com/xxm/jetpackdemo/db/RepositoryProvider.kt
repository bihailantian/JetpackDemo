package com.xxm.jetpackdemo.db

import android.content.Context
import com.xxm.jetpackdemo.db.repository.ShoeRepository
import com.xxm.jetpackdemo.db.repository.UserRepository

object RepositoryProvider {

    /**
     * 得到用户仓库
     */
    fun providerUserRepository(context: Context): UserRepository {
        return UserRepository.getInstance(AppDataBase.getInstance(context).userDao())
    }

    /**
     * 得到鞋的本地仓库
     */
    fun providerShoeRepository(context: Context): ShoeRepository {
       return ShoeRepository.getInstance(AppDataBase.getInstance(context).shoeDao())
    }


}
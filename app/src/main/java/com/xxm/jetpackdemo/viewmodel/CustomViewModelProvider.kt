package com.xxm.jetpackdemo.viewmodel

import android.content.Context
import androidx.navigation.NavController
import com.xxm.jetpackdemo.common.BaseConstant
import com.xxm.jetpackdemo.db.RepositoryProvider
import com.xxm.jetpackdemo.db.repository.FavouriteShoeRepository
import com.xxm.jetpackdemo.db.repository.ShoeRepository
import com.xxm.jetpackdemo.db.repository.UserRepository
import com.xxm.jetpackdemo.utils.AppPrefsUtils
import com.xxm.jetpackdemo.viewmodel.factory.*

object CustomViewModelProvider  {

    fun providerRegisterModel(context: Context, navController: NavController):RegisterModelFactory{
        val repository: UserRepository = RepositoryProvider.providerUserRepository(context)
        return RegisterModelFactory(repository,navController)
    }

    fun providerLoginModel(context: Context):LoginModelFactory{
        val repository: UserRepository = RepositoryProvider.providerUserRepository(context)
        return LoginModelFactory(repository,context)
    }

    fun providerShoeModel(context: Context): ShoeModelFactory {
        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
        return ShoeModelFactory(repository)
    }

    /**
     * @shoeId 鞋子的Id
     * @userId 用户的Id
     */
    fun providerDetailModel(context: Context, shoeId: Long, userId: Long): FavouriteShoeModelFactory {
        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
        val favShoeRepository: FavouriteShoeRepository = RepositoryProvider.providerFavouriteShoeRepository(context)
        return FavouriteShoeModelFactory(repository, favShoeRepository, shoeId, userId)
    }

    fun providerFavouriteModel(context: Context): FavouriteModelFactory {
        val repository: ShoeRepository = RepositoryProvider.providerShoeRepository(context)
        val userId:Long = AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
        return FavouriteModelFactory(repository,userId)
    }

    fun providerMeModel(context: Context):MeModelFactory{
        val repository:UserRepository = RepositoryProvider.providerUserRepository(context)
        return MeModelFactory(repository)
    }


}
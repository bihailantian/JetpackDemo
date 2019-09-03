package com.xxm.jetpackdemo.viewmodel

import android.content.Context
import androidx.navigation.NavController
import com.xxm.jetpackdemo.db.RepositoryProvider
import com.xxm.jetpackdemo.db.repository.ShoeRepository
import com.xxm.jetpackdemo.db.repository.UserRepository
import com.xxm.jetpackdemo.viewmodel.factory.LoginModelFactory
import com.xxm.jetpackdemo.viewmodel.factory.RegisterModelFactory
import com.xxm.jetpackdemo.viewmodel.factory.ShoeModelFactory

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
}
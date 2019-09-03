package com.xxm.jetpackdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.xxm.jetpackdemo.db.data.User

/**
 * 用户的方法
 */
@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE user_account = :account AND user_pwd = :pwd")
    fun login(account: String, pwd: String): List<User>

    @Insert
    fun insertUser(user: User): Long

    @Delete
    fun deleteUser(user: User)


    @Query("SELECT * FROM user WHERE id=:id")
    fun findUserById(id: Long): LiveData<User>

    @Query("SELECT * FROM user")
    fun getAllUsers(): List<User>
}
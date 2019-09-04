package com.xxm.jetpackdemo.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.xxm.jetpackdemo.db.dao.FavouriteShoeDao
import com.xxm.jetpackdemo.db.dao.ShoeDao
import com.xxm.jetpackdemo.db.dao.UserDao
import com.xxm.jetpackdemo.db.data.FavouriteShoe
import com.xxm.jetpackdemo.db.data.Shoe
import com.xxm.jetpackdemo.db.data.User
import com.xxm.jetpackdemo.utils.ShoeWorker

/**
 * 数据库文件
 */
@Database(entities = [User::class, Shoe::class, FavouriteShoe::class],version = 1,exportSchema = false) //生成表
@TypeConverters(Converters::class) // 转换不确定值
abstract class AppDataBase : RoomDatabase() {
    // 得到UserDao
    abstract fun userDao(): UserDao
    // 得到ShoeDao
    abstract fun shoeDao(): ShoeDao
    // 得到FavouriteShoeDao
    abstract fun favouriteShoeDao(): FavouriteShoeDao


    companion object {
        @Volatile
        private var instance: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            return instance ?: synchronized(this) {
                instance ?: buildDataBase(context).also {
                        instance = it
                    }
            }
        }

        private fun buildDataBase(context: Context): AppDataBase {

            return Room.databaseBuilder(context, AppDataBase::class.java, "jetPackDemo-database")
                .addCallback(object :RoomDatabase.Callback(){
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        // 读取鞋的集合
                        val request = OneTimeWorkRequestBuilder<ShoeWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                }) .build()
        }
    }

}
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
@Database(entities = [User::class, Shoe::class, FavouriteShoe::class],version = 1,exportSchema = false)
@TypeConverters(Converters::class)
abstract class AppDataBase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun shoeDao(): ShoeDao
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
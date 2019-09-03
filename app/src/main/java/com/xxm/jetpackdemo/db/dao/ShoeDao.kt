package com.xxm.jetpackdemo.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xxm.jetpackdemo.db.data.Shoe

/**
 * 鞋子业务
 */
@Dao
interface ShoeDao {

    // 选择所有的鞋
    @Query("SELECT * FROM shoe")
    fun getAllShoes(): LiveData<List<Shoe>>

    @Query("SELECT * FROM shoe WHERE id=:id")
    fun findShoeById(id: Long): LiveData<Shoe>

    /**
     * 通过品牌查询鞋子
     */
    @Query("SELECT * FROM shoe WHERE shoe_brand=:brand")
    fun findShoeByBrand(brand: String): LiveData<List<Shoe>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoe(shoe: Shoe)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertShoes(shoes: List<Shoe>)
}
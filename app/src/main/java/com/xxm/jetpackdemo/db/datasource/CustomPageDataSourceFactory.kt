package com.xxm.jetpackdemo.db.datasource

import androidx.paging.DataSource
import com.xxm.jetpackdemo.db.data.Shoe
import com.xxm.jetpackdemo.db.repository.ShoeRepository

/**
 * 构建CustomPageDataSource的工厂
 */
class CustomPageDataSourceFactory(val shoeRepository: ShoeRepository): DataSource.Factory<Int, Shoe>() {

    override fun create(): DataSource<Int, Shoe> {
        return CustomPageDataSource(shoeRepository)
    }
}
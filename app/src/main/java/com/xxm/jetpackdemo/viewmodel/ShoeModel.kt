package com.xxm.jetpackdemo.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.xxm.jetpackdemo.db.data.Shoe
import com.xxm.jetpackdemo.db.datasource.CustomPageDataSourceFactory
import com.xxm.jetpackdemo.db.repository.ShoeRepository

class ShoeModel constructor(shoeRepository: ShoeRepository) : ViewModel() {

    // 品牌的观察对象 默认观察所有的品牌
    private val brand = MutableLiveData<String>().apply {
        value = ALL
    }

    // 鞋子集合的观察类
//    val shoes: LiveData<List<Shoe>> = brand.switchMap {
//        // Room数据库查询，只要知道返回的是LiveData<List<Shoe>>即可
//        if (it == ALL) {
//            shoeRepository.getAllShoes()
//        } else {
//            shoeRepository.getShoesByBrand(it)
//        }
//    }

    fun setBrand(brand:String){
        this.brand.value = brand

        this.brand.map {

        }
    }

    fun clearBrand(){
        this.brand.value = ALL
    }


    // 鞋子集合的观察类
    val shoes: LiveData<PagedList<Shoe>> = LivePagedListBuilder<Int, Shoe>(
        CustomPageDataSourceFactory(shoeRepository) // DataSourceFactory
        , PagedList.Config.Builder()
            .setPageSize(10) // 分页加载的数量
            .setEnablePlaceholders(false) // 当item为null是否使用PlaceHolder展示
            .setInitialLoadSizeHint(10) // 预加载的数量
            .build())
        .build()


    companion object {
        private const val ALL = "所有"
    }
}
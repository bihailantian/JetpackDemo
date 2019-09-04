package com.xxm.jetpackdemo.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.xxm.jetpackdemo.R
import com.xxm.jetpackdemo.common.BaseConstant
import com.xxm.jetpackdemo.databinding.ActivityDetailBinding
import com.xxm.jetpackdemo.utils.AppPrefsUtils
import com.xxm.jetpackdemo.viewmodel.CustomViewModelProvider
import com.xxm.jetpackdemo.viewmodel.DetailModel

class DetailActivity : AppCompatActivity() {

    private val detailModel: DetailModel by viewModels<DetailModel> {
        CustomViewModelProvider.providerDetailModel(
            this
            , intent.getLongExtra(BaseConstant.DETAIL_SHOE_ID, 1L)
            , AppPrefsUtils.getLong(BaseConstant.SP_USER_ID)
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_detail)

        val binding = DataBindingUtil.setContentView<ActivityDetailBinding>(this, R.layout.activity_detail)
        observer(binding)
    }

    private fun observer(binding: ActivityDetailBinding) {
        detailModel.shoe.observe(this, Observer {
            binding.shoe = it
            binding.price = it.price.toString()
        })

        detailModel.favouriteShoe.observe(this, Observer {
            binding.v = if (it == null) View.VISIBLE else View.GONE
        })
    }
}

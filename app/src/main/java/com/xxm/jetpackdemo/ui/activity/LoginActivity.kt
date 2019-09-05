package com.xxm.jetpackdemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xxm.jetpackdemo.R
import com.xxm.jetpackdemo.common.BaseConstant
import com.xxm.jetpackdemo.utils.AppPrefsUtils

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initShoesOnFirstLaunch()
    }

    private fun initShoesOnFirstLaunch() {
        val isFirst = AppPrefsUtils.getBoolean(BaseConstant.IS_FIRST_LAUNCH)
        if (isFirst) {
            // 初始化数据
            AppPrefsUtils.putBoolean(BaseConstant.IS_FIRST_LAUNCH, false)
        }
    }

}

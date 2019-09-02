package com.xxm.jetpackdemo.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xxm.jetpackdemo.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}

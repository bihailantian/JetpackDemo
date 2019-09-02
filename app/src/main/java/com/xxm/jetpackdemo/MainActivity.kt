package com.xxm.jetpackdemo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.xxm.jetpackdemo.viewmodel.LoginViewModel
import java.util.*

class MainActivity : AppCompatActivity() {
    //lateinit定义的变量可以不用初始化
    lateinit var model: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initWidget()
    }

    private fun initWidget() {
        model = LoginViewModel()

        val btn = findViewById<Button>(R.id.btn_random)
        val text = findViewById<TextView>(R.id.tv_content)

        btn.setOnClickListener {
            model.data.value = UUID.randomUUID().toString()
        }

        model.data.observe(this, object : Observer<String> {
            override fun onChanged(t: String?) {
                t?.let {
                    text.text = it
                }
            }

        })


    }
}

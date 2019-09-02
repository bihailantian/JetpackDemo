package com.xxm.jetpackdemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val host: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.my_nav_host_fragment) as NavHostFragment
        val navController = host.navController

        initWidget()
        initBottomNavigationView(bottomNavigationView,navController)
    }


    /**
     * 关联底部导航栏，使之能够点击切换页面
     */
    private fun initBottomNavigationView(bottomNavigationView: BottomNavigationView ,navController: NavController) {
        bottomNavigationView.setupWithNavController(navController)
    }

    /**
     * 初始化控件
     */
    private fun initWidget() {
        bottomNavigationView = findViewById(R.id.navigation_view)
    }
}

package com.internshala.mounty.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.internshala.mounty.R
import com.internshala.mounty.data.network.NetwrokConnectionInterceptor
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val networkConnectionInterceptor = NetwrokConnectionInterceptor(this)

        val navController = Navigation.findNavController(this,R.id.fragment)
        NavigationUI.setupWithNavController(myNav,navController)

    }

    override fun onNavigateUp(): Boolean {
        return super.onNavigateUp()
    }
}

package com.takwolf.android.demo.insetswidget

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.takwolf.android.demo.insetswidget.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge(
            statusBarStyle = SystemBarStyle.dark(Color.TRANSPARENT),
            navigationBarStyle = SystemBarStyle.light(Color.TRANSPARENT, Color.TRANSPARENT),
        )
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDemo1.setOnClickListener {
            startActivity(Intent(this, Demo1Activity::class.java))
        }

        binding.btnDemo2.setOnClickListener {
            startActivity(Intent(this, Demo2Activity::class.java))
        }

        binding.btnDemo3.setOnClickListener {
            startActivity(Intent(this, Demo3Activity::class.java))
        }
    }
}

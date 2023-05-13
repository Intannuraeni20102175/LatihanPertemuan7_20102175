package com.example.latihanpertemuan7_20102175

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.latihanpertemuan7_20102175.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    lateinit var sharedPrefs : SharedPreferences
    lateinit var binding : ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPrefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)

        if(sharedPrefs.contains("user_id")){
            val intet = Intent(this, DetailActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Handler().postDelayed({
                val intent = Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }, 2000)
        }
    }
}
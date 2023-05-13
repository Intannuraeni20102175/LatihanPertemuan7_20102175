package com.example.latihanpertemuan7_20102175

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.latihanpertemuan7_20102175.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    lateinit var sharedprefs : SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedprefs = getSharedPreferences("DataUser", Context.MODE_PRIVATE)

        val email = sharedprefs.getString("user_email","")
        val password = sharedprefs.getString("user_password","'")

        binding.txtEmail.text = " Email : ${email.toString()}"
        binding.txtPassword.text = "Password : ${password.toString()}"

        binding.btnLogout.setOnClickListener{
            with(sharedprefs.edit()){
                clear()
                apply()
            }
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}
package com.example.calculater

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.calculater.databinding.ActivitySettingsBinding

class Settings : AppCompatActivity() {
    private lateinit var binding: ActivitySettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySettingsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.nightMode.setOnCheckedChangeListener { buttonView, isChecked ->
            run {
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)

                }

            }
        }

    initView()
    }

    private fun initView() {
        binding.nightMode.isChecked = AppCompatDelegate.getDefaultNightMode() == AppCompatDelegate.MODE_NIGHT_YES
    }
}
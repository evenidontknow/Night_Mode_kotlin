package com.example.night_mode;
import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences : SharedPreferences =
            getSharedPreferences("sharedpreference",
                Context.MODE_PRIVATE)
        val sharedprefEdit : SharedPreferences.Editor = sharedPreferences.edit()

        var darkMode = sharedPreferences.getBoolean("darkMode",false)

        if (darkMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            button.text = "Disable dark mode"
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            button.text = "Enable dark mode"
        }

        button.setOnClickListener {
            if(darkMode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharedprefEdit.putBoolean("darkMode",false)
                sharedprefEdit.apply()
                button.text = "Enable dark mode"
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharedprefEdit.putBoolean("darkMode",true)
                sharedprefEdit.apply()
                button.text = "Disable dark mode"
            }
        }
    }
}
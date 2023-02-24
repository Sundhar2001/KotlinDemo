package com.example.smallchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var btnShowToast: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

         btnShowToast = findViewById(R.id.btnShowToast)

        btnShowToast.setOnClickListener {
            Log.i("MainActivity","Button was clicked !")
            Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show()
        }
    }
}
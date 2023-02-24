package com.example.smallchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class ReceiverActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receiver)

        val bundle: Bundle?= intent.extras
        val message = bundle?.getString("user_message")

        var userText: TextView = findViewById(R.id.tv_user_message)

        userText.text = message

        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }
}
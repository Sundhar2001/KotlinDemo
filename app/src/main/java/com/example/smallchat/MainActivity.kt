package com.example.smallchat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

   lateinit var btnShowToast: Button
   lateinit var userMessage: EditText
   lateinit var btnSendMessage: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*hide default toolBar in layout file*/
        supportActionBar?.hide()

         btnShowToast = findViewById(R.id.btn_show_toast)
         btnSendMessage = findViewById(R.id.btn_send_message)
         userMessage = findViewById(R.id.et_user_message)

        btnShowToast.setOnClickListener {
            Log.i("MainActivity","Button was clicked !")
            Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show()
        }

        btnSendMessage.setOnClickListener {

            var message = userMessage.text.toString()    /*val message = userMessage.text.toString() ----> //possible// */

            /*validate textview is empty or not*/
            if (message.isEmpty()){
                Log.d("IntentButton","ErrorMessage")
                Toast.makeText(this,"Please enter the value",Toast.LENGTH_SHORT).show()

            }else{

                /*Explicit intent --->  current (this) activity to another(ReceiverActivity) activity*/
                val  messageIntent = Intent(this,ReceiverActivity::class.java)

                /*pass data to another activity*/
                messageIntent.putExtra("user_message",message)
                startActivity(messageIntent)
                Toast.makeText(this,message,Toast.LENGTH_SHORT).show()

                Log.d("IntentButton","SuccessMessage")

            }

        }
    }
}
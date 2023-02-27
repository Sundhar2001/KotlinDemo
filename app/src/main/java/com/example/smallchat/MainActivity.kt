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
   lateinit var btnShare: Button
   lateinit var btnRecyclerview: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*hide default toolBar in layout file*/
        supportActionBar?.hide()

         btnShowToast = findViewById(R.id.btn_show_toast)
         btnSendMessage = findViewById(R.id.btn_send_message)
         userMessage = findViewById(R.id.et_user_message)
         btnShare = findViewById(R.id.btn_share)
         btnRecyclerview = findViewById(R.id.btn_recyclerview)

        btnShowToast.setOnClickListener {
            Log.i("MainActivity","Button was clicked !")
            Toast.makeText(this,"Welcome",Toast.LENGTH_LONG).show()
        }

        /*button for explicit intent test*/
        btnSendMessage.setOnClickListener {

            var message = userMessage.text.toString()    /*val message = userMessage.text.toString() ----> //possible// */

            /*validate textview is empty or not*/
            if (message.isEmpty()){
                Log.d("IntentButton","ErrorMessage")
                Toast.makeText(this,"Please enter the message",Toast.LENGTH_SHORT).show()

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

        /*button for implicit intent test */
        btnShare.setOnClickListener {

            var message = userMessage.text.toString()    /*val message = userMessage.text.toString() ----> //possible// */

            if (message.isEmpty()){

                Log.d("IntentButton","ErrorMessage")
                Toast.makeText(this,"Please enter the message",Toast.LENGTH_SHORT).show()
            }else {

                val intent = Intent()
                intent.action = Intent.ACTION_SEND
                intent.putExtra(Intent.EXTRA_TEXT, message)
                intent.type = "text/plain"

                startActivity(Intent.createChooser(intent, "Please select the application"))
            }
        }

        /*button for recyclerview demo */
        btnRecyclerview.setOnClickListener {
            val recycleIntent =  Intent(this,MyHobbiesActivity::class.java)
            startActivity(recycleIntent)
        }
    }
}
package com.example.smallchat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.smallchat.adapter.HobbiesAdapter
import com.example.smallchat.model.Supplier

class MyHobbiesActivity : AppCompatActivity() {
    lateinit var hobbyRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_hobbies)

        /*Hide default tool bar*/
        supportActionBar!!.hide()

        hobbyRecyclerView = findViewById(R.id.recyclerview_hobby)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        hobbyRecyclerView.layoutManager = layoutManager

        val adapter = HobbiesAdapter(this,Supplier.hobbies)
        hobbyRecyclerView.adapter = adapter
    }
}
package com.example.smallchat.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.smallchat.R
import com.example.smallchat.model.HobbyModel

class HobbiesAdapter(val context: Context,val hobbies:List<HobbyModel>):RecyclerView.Adapter<HobbiesAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.hobby_list_item,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val hobby = hobbies[position]

        holder.setData(hobby)
    }

    override fun getItemCount(): Int {
        return hobbies.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val tittle: TextView = itemView.findViewById(R.id.tv_hobby)

        fun setData(hobby: HobbyModel?){
            tittle.text = hobby?.hobby
        }

    }

}
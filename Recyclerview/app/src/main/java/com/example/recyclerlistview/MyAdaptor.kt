package com.example.recyclerlistview

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_view_row.view.*

class MyAdaptor( var context: Context , var foodList: ArrayList<FoodModel>) : RecyclerView.Adapter<MyAdaptor.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdaptor.MyViewHolder{
        val view =  LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyAdaptor.MyViewHolder, position: Int) {

        holder.itemView.foodName.text = foodList[position].name
       holder.itemView.foodImage.setImageResource(foodList[position].image)

        holder.itemView.linear.setOnClickListener{
            var intent = Intent(context, Recipe::class.java)
            intent.putExtra("name", foodList[position].name)
            intent.putExtra("image", foodList[position].image)
            intent.putExtra("recipe", foodList[position].recipe)
            context.startActivity(intent)
        }

    }

    // return Size of the list of data.
    override fun getItemCount(): Int {
        return foodList.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
    }

}
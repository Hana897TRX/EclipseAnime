package com.hana897trx.eclipseanime

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.ViewHolder> (){

    private var titles= arrayOf("Titulo Uno", "Titulo Dos", "Titulo Tres")

    private var images= intArrayOf(R.drawable.angel,R.drawable.mob,R.drawable.angel)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.ViewHolder {

        val v= LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text=titles[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
    return titles.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
       var itemImage: ImageView
       var itemTitle: TextView

       init {
           itemImage= itemView.findViewById(R.id.item_image)
           itemTitle= itemView.findViewById(R.id.item_title)
       }
    }
}
package com.example.xmlparsingrssfeedhttpurlconnections

import android.content.Context
import android.icu.number.NumberFormatter.with
import android.icu.number.NumberRangeFormatter.with
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_row.view.*
import java.net.URL
import java.util.*

 import com.squareup.picasso.Picasso

class RecyclerViewAdapter (var  perfumes: List<Feed>,var ImgUrls:ArrayList<URL>,var context:Context) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
//
    val TAG = "Adapter"

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

//    var imageView1 :ImageView
//    init{
//        imageView1 = View.findViewById<View>(R.id.imageView1) as ImageView
//    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent,false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var perfume = perfumes[position]
       /// Picasso.with(context).load(ImgUrls[position]).resize(150,150).into(ItemViewHolder.imageView1)




      // picasso.with(conttext).load()

        holder.itemView.apply {
         // nameOfPer1.text = perfume.title
         ///   nameOfPer2.text = perfume.title


        }
    }

    override fun getItemCount() = perfumes.size

    fun filterList(filteredPerfum: ArrayList<Feed>) {
        this.perfumes = filteredPerfum
        notifyDataSetChanged()
    }

}


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
import java.lang.System.load
import java.util.ServiceLoader.load

class RecyclerViewAdapter (var perfumes: List<String>,var ImgUrls:ArrayList<String>) : RecyclerView.Adapter<RecyclerViewAdapter.ItemViewHolder>() {
//
    val TAG = "Adapter"

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent,false))
    }


    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var perfume = perfumes[position]
       var url = ImgUrls[position]






      // picasso.with(conttext).load()

        holder.itemView.apply {
        nameOfPer.text = perfume

            Picasso.get().load(ImgUrls[position]).resize(150,150).into(imageView)

           /// Picasso.get().load(url).into(imageView)
            Log.d(TAG, "urlAdap: $url")

        }
    }

    override fun getItemCount() = perfumes.size

    fun filterList(filteredPerfum: ArrayList<String>) {
        this.perfumes = filteredPerfum
        notifyDataSetChanged()
    }

}


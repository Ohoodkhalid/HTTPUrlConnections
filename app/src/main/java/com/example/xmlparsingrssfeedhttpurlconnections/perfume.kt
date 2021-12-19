package com.example.xmlparsingrssfeedhttpurlconnections

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.EditText
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.SearchView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.xmlparsingrssfeedhttpurlconnections.FeedAPI.Companion.BASE_URL

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit

import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import java.net.URL
import kotlin.random.Random

class perfume : AppCompatActivity() {
    private  val TAG = "perfume"
    private lateinit var recView: RecyclerView
    private lateinit var rvAdapter: RecyclerViewAdapter
    lateinit var searchEditT: EditText
    var  perfumes=  ArrayList<String>()
    var  filter=  ArrayList<String>()
    var ImgUrls =  ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfume)

//        ImgUrls.add("https://img.perfume.com/images/products/parent/medium/60587w.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/sku/small/mdabpt.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/sku/small/jw34pu.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/sku/small/addes17.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/sku/small/wdiori.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/sku/small/53624.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/parent/medium/518w.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/parent/medium/60391w.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/parent/medium/291m.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/sku/small/sm34ps.jpg")
//        ImgUrls.add("https://img.perfume.com/images/products/sku/small/diorhom34.jpg")


        recView = findViewById(R.id.recView)
        rvAdapter = RecyclerViewAdapter(perfumes,ImgUrls)
        recView.adapter = rvAdapter
        recView.layoutManager = GridLayoutManager(this, 2)


        searchEditT = findViewById(R.id.searchEditT)

        searchEditT.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun afterTextChanged(editable: Editable) {
                //after the change calling the method and passing the search input
              filter(editable.toString())
            }
        })

     ///   searchEditT.addTextChangedListener(textWatcher)


     getData()











   }

    fun getData(){

//        val retrofit = Retrofit.Builder()
//            .baseUrl("https://www.perfume.com/blog/")
//            .addConverterFactory(SimpleXmlConverterFactory.create())
//            .build()
//        var feedAPI = retrofit.create(FeedAPI::class.java)
//
//        feedAPI.feed().enqueue(object :Callback<List<Feed>> {

            val feedAPI = APIClient().getClient()?.create(FeedAPI::class.java)
             feedAPI?.feed?.enqueue(object : Callback<Feed?> {


                override fun onResponse(call: Call<Feed?>, response: Response<Feed?>) {

                    Log.d(TAG, "onResponse: feed: " + response.body().toString())
                    Log.d(TAG, "onResponse: Server Response: $response")
               ///  val entries = response.body()?.channel?.title
                    val url =  response.body()?.channel?.items!![0].enclosure?.url
                    Log.d(TAG, "url: $url")
                  ////  Log.d(TAG, "onResponse: feed: $entries")
                    val xmlresponse = response.errorBody()
                    Log.d(TAG, "onResponse: feed: $xmlresponse")
                for(data in response.body()!!.channel?.items!!){
                    perfumes.add(data.title!!)
                    ImgUrls.add(data.enclosure?.url!!)

                }
                rvAdapter.notifyDataSetChanged()

           }

            override fun onFailure(call: Call<Feed?>, t: Throwable) {
                Toast.makeText(this@perfume, "ERROR", Toast.LENGTH_LONG).show()
            }
        })
   }

//    private val textWatcher = object : TextWatcher {
//        override fun afterTextChanged(s: Editable?) {
//           Filter(s.toString())
//        }
//
//        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
//        }
//
//        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
//          ///  recView.text = s
//
//        }
//    }
//
//    private fun Filter(text: String) {
//
//
//    }

    private fun filter(text: String) {
        //new array list that will hold the filtered data
        val filteredNames = ArrayList<String>()
        //looping through existing elements and adding the element to filtered list
        perfumes.filterTo(filteredNames) {
            //if the existing elements contains the search input
            it.toLowerCase().contains(text.toLowerCase())
        }
        //calling a method of the adapter class and passing the filtered list
        rvAdapter!!.filterList(filteredNames)
    }

}
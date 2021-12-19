package com.example.xmlparsingrssfeedhttpurlconnections
import retrofit2.http.GET
///import com.example.myretrofitexample.model.Feed
import retrofit2.Call



interface FeedAPI {
    @get:GET("/blog/feed/")
    val feed: Call<Feed?>?



    companion object {
        const val BASE_URL = "https://www.perfume.com/blog/"
    }
}
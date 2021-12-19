package com.example.xmlparsingrssfeedhttpurlconnections
import retrofit2.http.GET
///import com.example.myretrofitexample.model.Feed
import retrofit2.Call



interface FeedAPI {
    @get:GET("rss/latest-products")
    val feed: Call<Feed?>?



    companion object {
        const val BASE_URL ="https://www.theperfumeshop.com/blog"
    }
}
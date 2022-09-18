package com.example.retroapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


//https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=19c9716fc4e148f99785fcf9a314fff3
//https://newsapi.org/v2/everything?domains=wsj.com&apiKey=19c9716fc4e148f99785fcf9a314fff3
//
//19c9716fc4e148f99785fcf9a314fff3

const val BASE_URL = "https://newsapi.org/"

const val API_KEY = "19c9716fc4e148f99785fcf9a314fff3"

interface NewsInterface {

    @GET("/v2/top-headlines?apiKey=$API_KEY")
    fun getHeadLines (@Query("country") country : String, @Query("page") page:Int):Call<News>
}

object NewsService{
    val newsInstance : NewsInterface
    init {
        val retofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        newsInstance = retofit.create(NewsInterface::class.java)
    }


}

//https://newsapi.org//v2/top-headlines?apiKey=19c9716fc4e148f99785fcf9a314fff3&country=in&page1
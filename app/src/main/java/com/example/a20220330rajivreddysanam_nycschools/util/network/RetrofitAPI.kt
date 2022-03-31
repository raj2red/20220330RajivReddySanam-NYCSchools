package com.example.a20220330rajivreddysanam_nycschools.util.network

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitAPI {

    val gson= GsonBuilder().setLenient().create()

    val retrofit= Retrofit.Builder()
        .baseUrl("https://data.cityofnewyork.us/resource/")
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()

    var api= retrofit.create(NetworkCall::class.java)

}
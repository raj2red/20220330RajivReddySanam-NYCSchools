package com.example.a20220330rajivreddysanam_nycschools.util.network

import com.example.a20220330rajivreddysanam_nycschools.util.network.data.SchoolAPIResponseItem
import retrofit2.Call
import retrofit2.http.GET


interface NetworkCall {

    @GET("f9bf-2cp4.json")
    fun getSATResponse(): Call<List<SATResponseItem>>

    @GET("s3k6-pzi2.json")
    fun getSchoolsResponse(): Call<List<SchoolAPIResponseItem>>
}
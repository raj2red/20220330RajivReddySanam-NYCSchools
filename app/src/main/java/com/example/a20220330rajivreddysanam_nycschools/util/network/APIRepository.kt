package com.example.a20220330rajivreddysanam_nycschools.util.network

class APIRepository (private val apiService: NetworkCall) {
    suspend fun getSchoolsResponse() = apiService.getSchoolsResponse()
    suspend fun getSATResponse() = apiService.getSATResponse()
}
package com.example.hiltretrofit.network

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetroServiceInstance {

    @GET(value = "repositories")
    fun getDtaFromApi (@Query (value = "q") query: String): Call<RecyclerList>
}
package com.sihaloho.belajarretrofit

import retrofit2.Call
import retrofit2.http.GET

interface Api {
    @GET("posts")
    fun getDraftHistory(): Call<ArrayList<DraftHistoryResponse>>
}
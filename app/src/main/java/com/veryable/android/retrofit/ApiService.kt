package com.veryable.android.retrofit

import com.veryable.android.data.Account
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("veryable.json")
    fun getData(): Call<MutableList<Account>>

}
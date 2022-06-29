package com.veryable.android.retrofit

import android.telecom.Call
import com.veryable.android.data.Account
import retrofit2.http.GET

interface ApiService {

    @GET("veryable.json")
    suspend fun getData(): retrofit2.Call<MutableList<Account>>

}
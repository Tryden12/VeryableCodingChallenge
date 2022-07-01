package com.veryable.android.retrofit

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

object RetroInstance {

    // Base Url
    private const val BASE_URL: String =
        "https://veryable-public-assets.s3.us-east-2.amazonaws.com/" // veryable.json/

    // Create Gson instance
    private val gson: Gson by lazy {
        GsonBuilder().setLenient().create()
    }

    // Create Moshi instance
    private val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()!!

    // Http Client
    private val httpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().build()
    }

    // Create Retro instance
    private val retrofit: Retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    // Create Api Service
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}
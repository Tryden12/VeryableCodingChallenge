package com.veryable.android.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetroInstance {

    // Base Url
    private const val BASE_URL: String =
        "https://veryable-public-assets.s3.us-east-2.amazonaws.com/"

    // Create Moshi instance
    private val moshi = Moshi.Builder()
        .add(KotlinJsonAdapterFactory())
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
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
    }

    // Create Api Service
    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }
}
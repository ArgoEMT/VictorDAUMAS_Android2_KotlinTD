package com.providence.rickandmorty_api_kotlin

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Webservice
{
    private var retrofit: Retrofit? = null

    fun Webservice() {
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getService(): RetrofitInterface? {
        return retrofit!!.create(RetrofitInterface::class.java)
    }
}
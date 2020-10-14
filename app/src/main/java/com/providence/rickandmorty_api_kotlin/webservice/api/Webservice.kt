package com.providence.rickandmorty_api_kotlin.webservice.api

import com.providence.rickandmorty_api_kotlin.URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * @author Victor DAUMAS
 * @version 1.0
 */
class Webservice {
    private var retrofit: Retrofit? = null

    constructor() {
        retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    fun getService(): RetrofitInterface? {
        return retrofit?.create(RetrofitInterface::class.java)
    }
}
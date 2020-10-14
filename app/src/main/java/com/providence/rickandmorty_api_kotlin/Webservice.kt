package com.providence.rickandmorty_api_kotlin

import com.providence.rickandmorty_api_kotlin.webservice.api.RetrofitInterface
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
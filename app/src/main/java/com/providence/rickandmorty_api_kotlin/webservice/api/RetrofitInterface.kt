package com.providence.rickandmorty_api_kotlin.webservice.api

import com.providence.rickandmorty_api_kotlin.model.ListCocktail
import retrofit2.Call
import retrofit2.http.GET

/**
 * @author Victor DAUMAS
 * @version 1.0
 */
interface RetrofitInterface {

    @GET(GET_COCKTAIL_LIST)
    fun getCocktail(): Call<ListCocktail?>?

    companion object
    {
        const val GET_COCKTAIL_LIST = "cocktails/liste_cocktails.php"
    }
}

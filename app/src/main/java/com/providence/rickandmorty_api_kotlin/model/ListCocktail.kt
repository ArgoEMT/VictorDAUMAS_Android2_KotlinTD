package com.providence.rickandmorty_api_kotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class ListCocktail {

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("cocktails")
    @Expose
    private var cocktails: List<Cocktail?>? = null

    fun getTitle(): String? {
        return title
    }

    fun getCocktails(): List<Cocktail?>? {
        return cocktails
    }


}
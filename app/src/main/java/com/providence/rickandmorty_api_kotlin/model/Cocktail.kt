package com.providence.rickandmorty_api_kotlin.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class Cocktail {
    @SerializedName("name")
    @Expose
    private var name: String? = null

    @SerializedName("alcool")
    @Expose
    private var alcool = false

    @SerializedName("ingredients")
    @Expose
    private var ingredients: List<String?>? = null

    fun getName(): String? {
        return name
    }

    fun setName(name: String?) {
        this.name = name
    }

    fun isAlcool(): Boolean {
        return alcool
    }

    fun setAlcool(alcool: Boolean) {
        this.alcool = alcool
    }

    fun getIngredients(): List<String?>? {
        return ingredients
    }

    fun setIngredients(ingredients: List<String?>?) {
        this.ingredients = ingredients
    }

}
package com.providence.rickandmorty_api_kotlin.model

data class Info(
    val count: Int,
    val next: String,
    val pages: Int,
    val prev: String
)
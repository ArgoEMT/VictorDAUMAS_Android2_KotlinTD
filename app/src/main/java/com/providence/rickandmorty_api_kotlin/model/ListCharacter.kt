package com.providence.rickandmorty_api_kotlin.model

data class ListCharacter(
    val info: Info,
    val results: List<Character>
)
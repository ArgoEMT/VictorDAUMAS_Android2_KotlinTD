package com.providence.rickandmorty_api_kotlin.webservice.api

import com.providence.rickandmorty_api_kotlin.model.PaginatedResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Victor DAUMAS
 * @version 1.0
 */
interface RetrofitInterface {
    @GET(GET_ALL_CHARACTER_PATH)
    suspend fun getAllCharacter(
        @Query("page") page: Int
    ): Response<PaginatedResult<Character>>

    companion object {
        const val GET_ALL_CHARACTER_PATH = "character/"
        const val GET_CHARACTER_DETAILS = "character/{id}"
    }
}
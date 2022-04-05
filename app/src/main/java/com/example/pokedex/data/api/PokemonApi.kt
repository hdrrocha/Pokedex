package com.example.pokedex.data.api

import com.example.pokedex.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/")
    suspend fun fetchPokemon(@Query("limit") limit: Int = 10, @Query("offset") offset: Int = 20): PokemonResponse

}
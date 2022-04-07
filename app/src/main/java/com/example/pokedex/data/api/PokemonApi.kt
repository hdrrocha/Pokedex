package com.example.pokedex.data.api

import com.example.pokedex.data.model.PokemonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/")
    suspend fun fetchPokemon(@Query("limit") limit: Int = 100, @Query("offset") offset: Int = 200): PokemonResponse
}
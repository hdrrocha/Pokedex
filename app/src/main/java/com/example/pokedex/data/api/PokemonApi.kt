package com.example.pokedex.data.api

import com.bumptech.glide.load.engine.Resource
import com.example.pokedex.data.model.PokemonResponse
import com.example.pokedex.data.model.SinglePokemonResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PokemonApi {
    @GET("pokemon/")
    suspend fun fetchPokemon(@Query("limit") limit: Int = 100, @Query("offset") offset: Int = 200): PokemonResponse

    @GET("pokemon/{name}/")
    suspend fun getSinglePokemon(
        @Path("name") name: String
    ): SinglePokemonResponse
}
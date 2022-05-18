package com.example.pokedex.domain.repository

import com.example.pokedex.data.model.SinglePokemonResponse

interface SinglePokemonRepository {
    suspend fun getSinglePokemon(name: String): SinglePokemonResponse
}
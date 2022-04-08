package com.example.pokedex.data.repository

import com.example.pokedex.data.api.PokemonApi
import com.example.pokedex.data.model.SinglePokemonResponse
import com.example.pokedex.domain.repository.SinglePokemonRepository

class SinglePokemonRepositoryImp(
    private val pokemonApi: PokemonApi
) : SinglePokemonRepository {
    override suspend fun getSinglePokemon(name: String): SinglePokemonResponse {
        return pokemonApi.getSinglePokemon(name)
    }
}
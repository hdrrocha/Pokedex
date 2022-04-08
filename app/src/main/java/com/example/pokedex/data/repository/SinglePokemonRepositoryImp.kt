package com.example.pokedex.data.repository

import android.util.Log
import com.example.pokedex.data.api.PokemonApi
import com.example.pokedex.data.model.SinglePokemonResponse
import com.example.pokedex.domain.repository.SinglePokemonRepository
import kotlinx.coroutines.flow.flow

class SinglePokemonRepositoryImp(
    private val pokemonApi: PokemonApi
) : SinglePokemonRepository {
    override suspend fun getSinglePokemon(name: String): SinglePokemonResponse {
        Log.i("Helder", "SinglePokemonRepository")
        return  pokemonApi.getSinglePokemon(name)
    }
}
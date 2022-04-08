package com.example.pokedex.domain.usercase.abs

import com.example.pokedex.domain.uimodel.SinglePokemonResponseUi

interface SinglePokemonUseCase {
    suspend fun fetchSinglePokemon(
        name: String
    ): SinglePokemonResponseUi
}
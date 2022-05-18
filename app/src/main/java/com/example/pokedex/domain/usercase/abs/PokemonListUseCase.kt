package com.example.pokedex.domain.usercase.abs

import androidx.paging.PagingData
import com.example.pokedex.domain.uimodel.PokemonUi
import kotlinx.coroutines.flow.Flow

interface PokemonListUseCase {
    fun fetchPokemon(): Flow<PagingData<PokemonUi>>
}
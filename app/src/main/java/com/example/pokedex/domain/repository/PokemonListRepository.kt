package com.example.pokedex.domain.repository

import androidx.paging.PagingData
import com.example.pokedex.data.model.Pokemon
import kotlinx.coroutines.flow.Flow

interface PokemonListRepository {
    fun fetchPokemon(): Flow<PagingData<Pokemon>>
}

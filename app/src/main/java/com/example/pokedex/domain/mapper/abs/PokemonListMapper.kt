package com.example.pokedex.domain.mapper.abs

import androidx.paging.PagingData
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.domain.uimodel.PokemonUi

interface PokemonListMapper {
    fun map(input: PagingData<Pokemon>): PagingData<PokemonUi>
}

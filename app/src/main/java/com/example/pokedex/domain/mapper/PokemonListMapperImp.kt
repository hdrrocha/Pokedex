package com.example.pokedex.domain.mapper

import androidx.paging.PagingData
import androidx.paging.map
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.domain.mapper.abs.PokemonListMapper
import com.example.pokedex.domain.uimodel.PokemonUi

class PokemonListMapperImp : PokemonListMapper {
    override fun map(pokemon: PagingData<Pokemon>) = pokemon.map { pokemon ->
        PokemonUi(
            name = pokemon.name,
            urlId = pokemon.url
        )
    }
}
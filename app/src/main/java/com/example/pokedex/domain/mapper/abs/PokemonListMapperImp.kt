package com.example.pokedex.domain.mapper.abs

import androidx.paging.PagingData
import androidx.paging.map
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.domain.uimodel.PokemonUi

class PokemonListMapperImp : PokemonListMapper {
    override fun map(pokemon: PagingData<Pokemon>) = pokemon.map { photo ->
        PokemonUi(
            name = photo.name,
            urlId = photo.url
        )
    }
}
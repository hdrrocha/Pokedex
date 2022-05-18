package com.example.pokedex.data.repository

import androidx.paging.Pager
import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.domain.repository.PokemonListRepository

class PokemonListRepositoryImp(
    private val pager: Pager<Int, Pokemon>
) : PokemonListRepository {
    companion object {
        const val DEFAULT_LIST_SIZE = 15
    }

    override fun fetchPokemon() = pager.flow
}

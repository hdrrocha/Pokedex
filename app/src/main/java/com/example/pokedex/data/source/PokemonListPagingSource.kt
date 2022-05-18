package com.example.pokedex.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.pokedex.data.api.PokemonApi
import com.example.pokedex.data.model.Pokemon
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PokemonListPagingSource(val api: PokemonApi) : PagingSource<Int, Pokemon>() {

    companion object {
        const val INITIAL_START = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Pokemon>) = state.anchorPosition?.let {
        state.closestPageToPosition(it)?.prevKey
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Pokemon> {
        val start = params.key?.let { it + INITIAL_START } ?: INITIAL_START
        val limit = params.key?.let { it + params.loadSize } ?: params.loadSize

        val data = withContext(Dispatchers.IO) { api.fetchPokemon(start, limit) }

        return LoadResult.Page(
            data.pokemons.orEmpty(),
            prevKey = if (start == INITIAL_START) null else start,
            nextKey = limit
        )
    }
}

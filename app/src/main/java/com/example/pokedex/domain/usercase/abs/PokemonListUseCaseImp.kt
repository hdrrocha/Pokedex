package com.example.pokedex.domain.usercase.abs

import com.example.pokedex.domain.mapper.abs.PokemonListMapper
import com.example.pokedex.domain.repository.PokemonListRepository

import kotlinx.coroutines.flow.map

class PokemonListUseCaseImp(
    private val pokemonListRepository: PokemonListRepository,
    private val mapper: PokemonListMapper
) : PokemonListUseCase {
    override fun fetchPokemon() = pokemonListRepository.fetchPokemon().map { mapper.map(it) }
}


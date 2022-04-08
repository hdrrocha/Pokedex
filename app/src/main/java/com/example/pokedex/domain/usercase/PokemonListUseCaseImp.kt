package com.example.pokedex.domain.usercase

import com.example.pokedex.domain.mapper.abs.PokemonListMapper
import com.example.pokedex.domain.repository.PokemonListRepository
import com.example.pokedex.domain.usercase.abs.PokemonListUseCase

import kotlinx.coroutines.flow.map

class PokemonListUseCaseImp(
    private val pokemonListRepository: PokemonListRepository,
    private val mapper: PokemonListMapper
) : PokemonListUseCase {
    override fun fetchPokemon() = pokemonListRepository.fetchPokemon().map { mapper.map(it) }
}


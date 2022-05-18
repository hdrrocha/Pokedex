package com.example.pokedex.domain.usercase

import com.example.pokedex.domain.mapper.abs.SinglePokemonMapper
import com.example.pokedex.domain.repository.SinglePokemonRepository
import com.example.pokedex.domain.uimodel.SinglePokemonResponseUi
import com.example.pokedex.domain.usercase.abs.SinglePokemonUseCase

class SinglePokemonUseCaseImp(
    private val singlePokemonRepository: SinglePokemonRepository,
    private val mapper: SinglePokemonMapper
) : SinglePokemonUseCase {
    override suspend fun fetchSinglePokemon(name: String): SinglePokemonResponseUi {
        return mapper.map(singlePokemonRepository.getSinglePokemon(name))
    }

}


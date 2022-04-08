package com.example.pokedex.domain.mapper.abs

import com.example.pokedex.data.model.SinglePokemonResponse
import com.example.pokedex.domain.uimodel.SinglePokemonResponseUi

interface SinglePokemonMapper {
    fun map(input: SinglePokemonResponse): SinglePokemonResponseUi
}

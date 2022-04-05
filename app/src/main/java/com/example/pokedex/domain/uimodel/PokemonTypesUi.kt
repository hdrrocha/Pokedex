package com.example.pokedex.domain.uimodel

data class PokemonTypesUi(
    var slot1: String,
    var slot2: String
) {
    companion object {
        fun empty() : PokemonTypesUi = PokemonTypesUi("", "")
    }
}
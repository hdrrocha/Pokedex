package com.example.pokedex.domain.uimodel

data class PokemonAbilitiesUi(
    var slot1: String,
    var slot2: String,
    var slot3: String
) {
    companion object {
        fun empty(): PokemonAbilitiesUi = PokemonAbilitiesUi("", "", "")
    }
}
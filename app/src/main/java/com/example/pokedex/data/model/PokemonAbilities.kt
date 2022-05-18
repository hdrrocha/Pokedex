package com.example.pokedex.data.model

data class PokemonAbilities(
    var slot1: String,
    var slot2: String,
    var slot3: String
) {
    companion object {
        fun empty(): PokemonAbilities = PokemonAbilities("", "", "")
    }
}
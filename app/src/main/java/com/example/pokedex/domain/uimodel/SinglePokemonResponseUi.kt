package com.example.pokedex.domain.uimodel

data class SinglePokemonResponseUi(
    var name: String,
    var order: Int,
    var sprites: PokemonSpritesUi,
    var height: Double,
    var baseExperience: Double,
    var weight: Double,
    var id: Int,
    var locationAreaEncounters: String
)
package com.example.pokedex.data.model

data class PokemonSprites(
    val back_default: String,
    val backFemale: String? = null,
    val back_female: String,
    val back_shiny_female: String? = null,
    val front_default: String,
    val front_female: String? = null,
    val front_shiny: String,
    val front_shiny_female: String? = null

)
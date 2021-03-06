package com.example.pokedex.data.model

import com.google.gson.annotations.SerializedName

data class PokemonResponse(
    @SerializedName("results") val pokemons: List<Pokemon>,
    @SerializedName("stat") val stat: String
)

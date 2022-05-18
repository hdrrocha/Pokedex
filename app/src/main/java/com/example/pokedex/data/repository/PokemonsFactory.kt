package com.example.pokedex.data.repository

import com.example.pokedex.data.model.Pokemon
import com.example.pokedex.domain.uimodel.PokemonUi

object PokemonsFactory {

    val pokemonList get() = listOf(pokemonItem, pokemonItem, pokemonItem, pokemonItem, pokemonItem)

    val pokemonItem
        get() = Pokemon(
            "pokemon",
            "pokeapi.co"
        )

    val pokemonListUI
        get() = listOf(
            pokemonItemUI,
            pokemonItemUI,
            pokemonItemUI,
            pokemonItemUI,
            pokemonItemUI
        )

    val pokemonItemUI
        get() = PokemonUi(
            "pokemon",
            "pokeapi.co"
        )
}

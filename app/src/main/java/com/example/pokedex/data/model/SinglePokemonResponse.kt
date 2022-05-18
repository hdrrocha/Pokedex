package com.example.pokedex.data.model

import me.sargunvohra.lib.pokekotlin.model.Ability
import me.sargunvohra.lib.pokekotlin.model.Move
import me.sargunvohra.lib.pokekotlin.model.Stat

data class SinglePokemonResponse(
    val abilities: List<Ability>,
    val base_experience: Double,
    val forms: List<Species>,
    val game_indices: List<GameIndex>,
    val height: Double,
    val held_items: List<Any?>,
    val id: Int,
    val is_default: Boolean,
    val location_area_encounters: String,
    val moves: List<Move>,
    val name: String,
    val order: Int,
    val past_types: List<Any?>,
    val species: Species,
    val sprites: PokemonSprites,
    val stats: List<Stat>,
    val types: List<PokemonTypes>,
    val weight: Double
)




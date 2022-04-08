package com.example.pokedex.domain.mapper

import com.example.pokedex.data.model.PokemonSprites
import com.example.pokedex.data.model.PokemonStats
import com.example.pokedex.data.model.SinglePokemonResponse
import com.example.pokedex.domain.mapper.abs.SinglePokemonMapper
import com.example.pokedex.domain.uimodel.PokemonSpritesUi
import com.example.pokedex.domain.uimodel.PokemonStatsUi
import com.example.pokedex.domain.uimodel.SinglePokemonResponseUi

class SinglePokemonMapperImp : SinglePokemonMapper {
    override fun map(input: SinglePokemonResponse): SinglePokemonResponseUi {

        return SinglePokemonResponseUi(
            name = input.name,
            order = input.order,
            sprites = mapSprites(input.sprites),
            height = input.height,
            baseExperience = input.base_experience,
            weight = input.weight,
            id = input.id,
            locationAreaEncounters = input.location_area_encounters

        )
    }

    private fun mapSprites(sprites: PokemonSprites): PokemonSpritesUi {
        return PokemonSpritesUi(
            backDefault = sprites.back_default,
            frontDefault = sprites.front_default
        )
    }


    private fun mapStats(stats: List<PokemonStats>?): List<PokemonStatsUi?>? {
        if (stats != null) {
            val outPut: MutableList<PokemonStatsUi?> = mutableListOf()

            for (statsUi in stats) {
                outPut.add(
                    PokemonStatsUi(
                        hp = statsUi.hp,
                        attack = statsUi.attack,
                        defense = statsUi.defense,
                        specialAttack = statsUi.specialAttack,
                        specialDefense = statsUi.specialDefense,
                        speed = statsUi.speed
                    )
                )
            }

            return outPut
        }
        return null
    }

}
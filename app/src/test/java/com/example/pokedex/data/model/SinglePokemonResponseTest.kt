package com.example.pokedex.data.model

import com.example.pokedex.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class SinglePokemonResponseTest : BaseUnitTest() {

    @Test
    fun constructor() = runBlocking {
        val model = SinglePokemonResponse(
            emptyList(),
            0.0,
            emptyList(),
            emptyList(),
            0.0,
            emptyList(),
            0,
            false,
            "any",
            emptyList(),
            "pokemon",
            0,
            emptyList(),
            Species(
                "pokemon",
                "pokeapi.co"
            ),
            PokemonSprites(
                "back_default",
                "backFemale",
                "back_female",
                "back_shiny_female",
                "front_default",
                "front_female",
                "front_shiny",
                "front_shiny_female"
            ),
            emptyList(),
            emptyList(),
            0.0
        )
        Truth.assertThat(model.abilities).isEmpty()
        Truth.assertThat(model.base_experience).isEqualTo(0.0)
        Truth.assertThat(model.forms).isEmpty()
        Truth.assertThat(model.game_indices).isEmpty()
        Truth.assertThat(model.height).isEqualTo(0.0)
        Truth.assertThat(model.held_items).isEmpty()
        Truth.assertThat(model.id).isEqualTo(0)
        Truth.assertThat(model.is_default).isFalse()
        Truth.assertThat(model.location_area_encounters).isEqualTo("pokemon")
        Truth.assertThat(model.moves).isEmpty()
        Truth.assertThat(model.name).isEqualTo("pokemon")
        Truth.assertThat(model.order).isEqualTo(0)
        Truth.assertThat(model.past_types).isEmpty()
        Truth.assertThat(model.species.name).isEqualTo("pokemon")
        Truth.assertThat(model.species.url).isEqualTo("url")
        Truth.assertThat(model.sprites.backFemale).isEqualTo("backFemale")
        Truth.assertThat(model.sprites.back_default).isEqualTo("back_default")
        Truth.assertThat(model.sprites.back_female).isEqualTo("back_female")
        Truth.assertThat(model.sprites.back_shiny_female).isEqualTo("back_shiny_female")
        Truth.assertThat(model.sprites.front_default).isEqualTo("front_default")
        Truth.assertThat(model.sprites.front_female).isEqualTo("front_female")
        Truth.assertThat(model.sprites.front_shiny).isEqualTo("front_shiny")
        Truth.assertThat(model.sprites.front_shiny_female).isEqualTo("front_shiny_female")
        Truth.assertThat(model.stats).isEmpty()
        Truth.assertThat(model.types).isEmpty()
        Truth.assertThat(model.weight).isEqualTo(0.0)

    }
}

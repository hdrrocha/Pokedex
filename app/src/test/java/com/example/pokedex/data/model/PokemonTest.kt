package com.example.pokedex.data.model

import com.example.pokedex.helper.BaseUnitTest
import com.google.common.truth.Truth
import kotlinx.coroutines.runBlocking
import org.junit.Test

class PokemonTest : BaseUnitTest() {
    @Test
    fun constructor() = runBlocking {
        val model = Pokemon("pokemon", "pokeapi.co")
        Truth.assertThat(model.name).isEqualTo("pokemon")
        Truth.assertThat(model.url).isEqualTo("pokeapi.co")
    }
}

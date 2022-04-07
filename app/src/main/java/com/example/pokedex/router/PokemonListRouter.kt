package com.example.pokedex.router

import androidx.navigation.NavController
import com.example.pokedex.router.abs.PokemonListRouterAbs
import com.example.pokedex.ui.fragments.PokemonListFragmentDirections

class PokemonListRouter(
    private val navController: NavController
) : PokemonListRouterAbs {

    override fun goToDetails(id: String) {
        val directions =
            PokemonListFragmentDirections.fragmentPokemonLintToFragmentPokemonDetails(id)
        navController.navigate(directions)
    }

    override fun goBack() {
        navController.navigateUp()
    }
}

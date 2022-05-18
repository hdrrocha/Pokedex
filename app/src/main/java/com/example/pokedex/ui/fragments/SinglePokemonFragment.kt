package com.example.pokedex.ui.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.pokedex.databinding.FragmentPokemonInformationBinding
import com.example.pokedex.domain.uimodel.SinglePokemonResponseUi
import com.example.pokedex.domain.viewmodel.SinglePokemonViewModel
import kotlinx.android.synthetic.main.fragment_pokemon_information.*
import org.koin.android.viewmodel.ext.android.viewModel


class SinglePokemonFragment : Fragment() {

    private var thiscontex: Context? = null
    var dominantColor: Int = 0

    private lateinit var binding: FragmentPokemonInformationBinding

    private val singlePokemonViewModel: SinglePokemonViewModel by viewModel()
    private val args by navArgs<SinglePokemonFragmentArgs>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonInformationBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = singlePokemonViewModel
        }
        if (container != null) {
            thiscontex = container.context
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupObservers()
        singlePokemonViewModel.loadData(args.name)

    }

    private fun setupObservers() {
        singlePokemonViewModel.data.observe(viewLifecycleOwner) {
            loadPokemonDetails(it)
        }
    }

    private fun loadPokemonDetails(pokemon: SinglePokemonResponseUi?) {
        loadImagePokemon(pokemon)

    }

    private fun loadImagePokemon(pokemon: SinglePokemonResponseUi?) {
        Glide.with(this)
            .load(pokemon?.sprites?.frontDefault)
            .into(pokemon_image)
    }


}
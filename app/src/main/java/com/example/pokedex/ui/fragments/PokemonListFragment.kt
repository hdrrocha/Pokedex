package com.example.pokedex.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.paging.PagingData
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.pokedex.databinding.FragmentPokemonListBinding
import com.example.pokedex.domain.viewmodel.PokemonListViewModel
import com.example.pokedex.router.abs.PokemonListRouterAbs
import com.example.pokedex.ui.adapters.PokemonItemsLoadStateAdapter
import com.example.pokedex.ui.adapters.PokemonViewAdapter
import org.koin.android.ext.android.inject
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class PokemonListFragment : Fragment() {

    private val router: PokemonListRouterAbs by inject { parametersOf(findNavController()) }

    private val pokemonListViewModel: PokemonListViewModel by viewModel()

    private lateinit var binding: FragmentPokemonListBinding

    private val pokemonViewAdapter = PokemonViewAdapter()
    private val headerAdapter = PokemonItemsLoadStateAdapter { pokemonViewAdapter.retry() }
    private val footerAdapter = PokemonItemsLoadStateAdapter { pokemonViewAdapter.retry() }
    private var listener: PokemonViewAdapter.OnItemClickListener? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPokemonListBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            viewModel = pokemonListViewModel
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycler()
        setupObservers()
        pokemonListViewModel.loadData()

    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    private fun setupRecycler() {
        listener = object : PokemonViewAdapter.OnItemClickListener {
            override fun onItemClick(id: String) = handleOnClickEvent(id)
        }
        pokemonViewAdapter.onItemClickListener = listener

        pokemonViewAdapter.addLoadStateListener { loadStates ->
            headerAdapter.loadState = loadStates.refresh
            footerAdapter.loadState = loadStates.append
        }

        binding.rvpokemonList.run {
            layoutManager =
                StaggeredGridLayoutManager(2, RecyclerView.VERTICAL).apply {
                    gapStrategy =
                        StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS
                    isAutoMeasureEnabled
                }
            itemAnimator = null

            adapter = ConcatAdapter(headerAdapter, pokemonViewAdapter, footerAdapter)
            setHasFixedSize(true)
        }
        pokemonViewAdapter.submitData(lifecycle, PagingData.empty())
    }

    private fun setupObservers() {
        pokemonListViewModel.data.observe(viewLifecycleOwner) {
            pokemonViewAdapter.submitData(lifecycle, it)
        }
    }

    private fun handleOnClickEvent(id: String) {
        val args by navArgs<PokemonListFragmentArgs>()
        if (args.isComparing) {
            router.goBack()
        } else {
            router.goToDetails(id)
        }
    }
}
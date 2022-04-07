package com.example.pokedex.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.pokedex.domain.uimodel.PokemonUi
import com.example.pokedex.domain.usercase.abs.PokemonListUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch


class PokemonListViewModel(
    private val useCase: PokemonListUseCase
) : ViewModel() {

    private val mutableData = MutableLiveData<PagingData<PokemonUi>>()

    val data get() = mutableData as LiveData<PagingData<PokemonUi>>

    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun loadData() = viewModelScope.launch {
        try {
            loading.value = true
            if (mutableData.value != null) return@launch
            useCase.fetchPokemon().cachedIn(viewModelScope).collect {
                mutableData.value = it
            }

        } catch (e: Exception) {
            error.value = true
            loading.value = false
        } finally {
            loading.value = false
        }
    }
}

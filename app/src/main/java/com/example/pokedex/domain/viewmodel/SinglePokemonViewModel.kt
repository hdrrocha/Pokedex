package com.example.pokedex.domain.viewmodel

import androidx.lifecycle.*
import com.example.pokedex.domain.uimodel.SinglePokemonResponseUi
import com.example.pokedex.domain.usercase.abs.SinglePokemonUseCase
import kotlinx.coroutines.launch


class SinglePokemonViewModel(
    private val useCase: SinglePokemonUseCase
) : ViewModel() {

    private val mutableData = MutableLiveData<SinglePokemonResponseUi>()

    val idPokemonData = Transformations.map(mutableData) {
        it.id.toString()
    }
    val namePokemonData = Transformations.map(mutableData) {
        it.name
    }
    val baseExperiencePokemonData = Transformations.map(mutableData) {
        it.baseExperience.toString()
    }
    val weightPokemonData = Transformations.map(mutableData) {
        it.weight.toString()
    }
    val heightPokemonData = Transformations.map(mutableData) {
        it.height.toString()
    }
    val orderPokemonData = Transformations.map(mutableData) {
        it.order.toString()
    }

    val data get() = mutableData as LiveData<SinglePokemonResponseUi>

    val error = MutableLiveData<Boolean>()
    val loading = MutableLiveData<Boolean>()

    fun loadData(name: String) = viewModelScope.launch {
        try {
            loading.value = true
            mutableData.value = useCase.fetchSinglePokemon(name)
        } catch (e: Exception) {
            error.value = true
            loading.value = false
        } finally {
            loading.value = false
        }
    }
}

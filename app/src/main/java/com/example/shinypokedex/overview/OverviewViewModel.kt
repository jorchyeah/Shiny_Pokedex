package com.example.shinypokedex.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shinypokedex.network.Pokemon
import com.example.shinypokedex.network.PokemonApiFilters
import com.example.shinypokedex.network.PokemonApiService
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    private val _pokemon = MutableLiveData<List<Pokemon>>()

    val response: LiveData<String>
        get() = _response

    val pokemon : LiveData<List<Pokemon>>
        get() = _pokemon

    init {
        getPokemonByRegion(PokemonApiFilters.SHOW_DEMO)
    }

    private fun getPokemonByRegion(filters: PokemonApiFilters) {
        _response.value = "Set API response"
        viewModelScope.launch {
            try {
                _pokemon.value = PokemonApiService
                    .PokemonApi
                    .retrofitService
                    .getPokemon(filters.offset, filters.limit)
                    .results
                _response.value = "Success: Pokemon were retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }

    fun updateFeed(filters: PokemonApiFilters){
        getPokemonByRegion(filters)
    }
}
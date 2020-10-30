package com.example.shinypokedex.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shinypokedex.network.PokemonApiService
import kotlinx.coroutines.launch

class OverviewViewModel : ViewModel() {

    private val _response = MutableLiveData<String>()

    val response: LiveData<String>
        get() = _response

    init {
        getPokemonByRegion()
    }

    private fun getPokemonByRegion() {
        _response.value = "Set API response"
        viewModelScope.launch {
            try {
                val listResult = PokemonApiService
                    .PokemonApi
                    .retrofitService
                    .getPokemon()
                    .results
                _response.value = "Success: ${listResult.size} Pokemon were retrieved"
            } catch (e: Exception) {
                _response.value = "Failure: ${e.message}"
            }
        }
    }
}
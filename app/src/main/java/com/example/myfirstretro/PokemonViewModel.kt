package com.example.myfirstretro

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class PokemonViewModel(val repo: PokemonRepository) : ViewModel() {

    var pokemonList = MutableLiveData<List<Pokemon>>()
    var job : Job? = null
    fun getAllPokemon() {
        job = CoroutineScope(Dispatchers.IO).launch {
            var res = repo.getAllPokemon()
            if (res.isSuccessful) {
                pokemonList.postValue(res.body())
            }
        }
    }

}
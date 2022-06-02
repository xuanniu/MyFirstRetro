package com.example.myfirstretro

import retrofit2.Call

class PokemonRepository(val inter : RetroApiInterface) {
    suspend fun getAllPokemon() = inter.getAllPokemon()
}
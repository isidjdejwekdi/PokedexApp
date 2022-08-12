package com.example.pokedex.domain.repository
import com.example.pokedex.domain.models.Pokemon

interface PokeRepository {

    fun getPokemonByName(name: String): Pokemon

    fun getPokemonById(id : Int): Pokemon

    fun savePokemon(pokemonModel: Pokemon)

    fun getSavedPokemon(): List<Pokemon>

}
package com.example.pokedex.data.repository

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.PokeRepository

class PokeRepositoryImpl(private val pokeRepository: PokeRepository): PokeRepository {

    override fun getPokemonByName(name: String): Pokemon {
        TODO("Not yet implemented")
    }

    override fun getPokemonById(id: Int): Pokemon {
        TODO("Not yet implemented")
    }

    override fun savePokemon(pokemonModel: Pokemon) {
        TODO("Not yet implemented")
    }

    override fun getSavedPokemon(): List<Pokemon> {
        TODO("Not yet implemented")
    }

}
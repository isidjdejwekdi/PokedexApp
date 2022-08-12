package com.example.pokedex.domain.usecase

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.PokeRepository

class FetchPokemonByIdUseCase(private val pokeRepository: PokeRepository) {

    fun execute(id: Int): Pokemon = pokeRepository.getPokemonById(id = id)

}
package com.example.pokedex.domain.usecase

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.PokeRepository

class FetchPokemonByNameUseCase(private val pokeRepository: PokeRepository) {

    fun execute(): Pokemon = pokeRepository.getPokemonByName()

}
package com.example.pokedex.domain.usecase

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.PokeRepository
import io.reactivex.Single

class FetchPokemonByNameOrIdUseCase(private val pokeRepository: PokeRepository) {

    //    fun execute(nameOrId: String):Single<Pokemon> =
//        //pokeRepository.getPokemonByNameOrId(pokemonNameOrId = nameOrId)
//        pokeRepository.getPokemonRx(nameOrId)
//
    fun execute(nameOrId: String): Single<Pokemon> =
        pokeRepository.getPokemonByNameOrId(pokemonNameOrId = nameOrId)
}
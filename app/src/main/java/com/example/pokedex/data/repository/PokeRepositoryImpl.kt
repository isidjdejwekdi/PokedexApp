package com.example.pokedex.data.repository

import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.repository.PokeRepository
import com.example.pokedex.data.remote.NetworkService
import com.example.pokedex.data.storage.DBStorage
import io.reactivex.Single
import io.reactivex.disposables.Disposable

class PokeRepositoryImpl(
    private val dbStorage: DBStorage,
    private val networkService: NetworkService
) : PokeRepository {

    override fun getPokemonByNameOrId(pokemonNameOrId: String): Single<Pokemon> =
        networkService.findPokemon(nameOrId = pokemonNameOrId)


    override fun savePokemon(pokemonModel: Pokemon): Boolean {
        TODO("use dbStorage")
    }

    override fun getPokemonRx(pokemonNameOrId: String): Single<Pokemon> {
        TODO("dfdfdf")
        //pokeRepository.getPokemonByNameOrId(pokemonNameOrId = nameOrId)
    }

    override fun getSavedPokemon(): List<Pokemon> {
        TODO("use dbStorage")
    }


}
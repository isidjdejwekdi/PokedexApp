package com.example.pokedex.domain.repository
import android.database.Observable
import android.text.Editable
import com.example.pokedex.domain.models.Pokemon
import io.reactivex.Single
import io.reactivex.disposables.Disposable

interface PokeRepository {

    fun getPokemonByNameOrId(pokemonNameOrId: String): Single<Pokemon>

    fun savePokemon(pokemonModel: Pokemon) : Boolean

    fun getSavedPokemon(): List<Pokemon>

    fun getPokemonRx(pokemonNameOrId: String): Single<Pokemon>

}
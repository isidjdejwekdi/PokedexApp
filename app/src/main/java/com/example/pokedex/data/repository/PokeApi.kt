package com.example.pokedex.data.repository

import com.example.pokedex.domain.models.Pokemon
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path

interface PokeApi {

    @GET("./pokemon/154")
    fun getAnyPokemon(): Single<Pokemon>

    @GET("pokemon/{pokemonName}") //TODO toLowerCase
    fun getPokemonByName(@Path(value = "pokemonName") name : String): Single<Pokemon>
}
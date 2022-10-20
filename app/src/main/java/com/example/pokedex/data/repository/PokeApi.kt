package com.example.pokedex.data.repository

import com.example.pokedex.domain.models.Pokemon
import io.reactivex.Observable
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path

interface PokeApi {

    @GET("pokemon/{pokemonName}") //TODO toLowerCase, random
    fun getPokemonByNameOrId(
        @Path(value = "pokemonName") nameOrId: String
    ): Single<Pokemon>
}
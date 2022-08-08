package com.example.pokedex.data.remote

import io.reactivex.Single;
import retrofit2.http.GET;

interface PokeApi {

    @GET("./pokemon/154")
    fun getAnyPokemon(): Single<PokemonResponse>
}
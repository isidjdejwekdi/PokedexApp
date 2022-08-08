package com.example.pokedex.data.remote

data class PokemonResponse(val id : Int,
                           val name: String) {
    override fun toString(): String {
        return "id: $id, name: $name"
    }
}
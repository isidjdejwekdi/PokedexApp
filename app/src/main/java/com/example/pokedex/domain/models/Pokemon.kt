package com.example.pokedex.domain.models

import com.google.gson.annotations.SerializedName

class Pokemon(
    val id: Int,
    val name: String,
    val abilities: Array<AbilityExtra>,
    val sprites: Sprite
){

    override fun toString(): String {
        return "Pokemon: name = $name, id = $id, abilities: ${abilities.toList()}"
    }
}
data class AbilityExtra(val ability: Ability, val is_hidden: Boolean, val slot: Int){
    override fun toString(): String {
        return ability.name
    }
}
data class Ability(val name: String, val url: String)
//sprite
data class Sprite(val other: OtherSprite, val front_shiny: String)
data class OtherSprite(val dream_world: DreamWorld, @SerializedName("official-artwork") val artwork: OfficialArtwork)
data class DreamWorld(val front_default: String)
data class OfficialArtwork(val front_default: String)


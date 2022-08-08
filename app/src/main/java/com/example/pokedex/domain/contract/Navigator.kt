package com.example.pokedex.domain.contract

interface Navigator {

    fun goBack()

    fun showPokemonFindScreen()

    fun showGetAnyPokemonScreen()

    fun showFavoritesScreen()

    fun goToMenu()
}
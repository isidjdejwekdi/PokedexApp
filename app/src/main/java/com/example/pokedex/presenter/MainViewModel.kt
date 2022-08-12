package com.example.pokedex.presenter

import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.lang.NumberFormatException

class MainViewModel : ViewModel() {

    private val resultPokemonMutableLive = MutableLiveData<Int>()
    val resultPokemonLive: LiveData<Int> = resultPokemonMutableLive


    fun findPokemon(textToFind: Editable) {
        val textStr = textToFind.toString()
        if (isNumber(textStr)) {    //is text a number
            val textInt = textStr.toInt()
            if (isNumberOfPokemon(textInt)) //is number is in the range
                fetchPokemonByID(textInt)
            else showIncorrectIdDialog()    //id is not in range
        } else {
            fetchPokemonByName(textStr)
        }

    }

    private fun showIncorrectIdDialog() {
        Log.e(TAG, "Pokemon ID is arranged in $MIN_POKEMON_ID to $MAX_POKEMON_ID")
    }

    private fun showIncorrectNameDialog() {
        Log.e(TAG, "Such pokemon does not exist")
    }

    private fun fetchPokemonByID(id: Int) {
        //TODO fetch
        Log.e(TAG, "fetch pokemon with id = $id")
    }

    private fun fetchPokemonByName(name: String) {
        //TODO fetch
        Log.e(TAG, "fetch pokemon with name = $name")
    }

    private fun isNumber(textToFind: String): Boolean {
        return try {
            textToFind.toInt()
            true
        } catch (ex: NumberFormatException) {
            false
        }
    }

    private fun isNumberOfPokemon(textInt: Int): Boolean {

        return textInt in MIN_POKEMON_ID..MAX_POKEMON_ID
    }

    fun findRandomPokemon() {

    }

    fun getFavoritesList() {

    }

    fun resetFavoritesList() {

    }

    companion object {
        const val MIN_POKEMON_ID = 0
        const val MAX_POKEMON_ID = 100
        const val TAG = "ViewModel"
        //TODO change min and max id constants to correct id
    }

    override fun onCleared() {
        Log.e("AAA", "VM Cleared")
        super.onCleared()
    }

}
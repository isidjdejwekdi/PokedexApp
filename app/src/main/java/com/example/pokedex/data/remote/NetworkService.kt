package com.example.pokedex.data.remote

import android.app.Application
import android.content.Context
import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokedex.app.PokeApp
import com.example.pokedex.app.appComponent
import com.example.pokedex.data.repository.PokeApi
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.presenter.MainViewModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import java.lang.NumberFormatException
import javax.inject.Inject

enum class FetchResults { NOT_IN_RANGE_ID, FETCH_ERROR, OK }
/*
* Doing a fetch to pokeapi v2 and getting a pokemon with determined id or name
* or random pokemon
 */
class NetworkService(private val context: Context) {
    @Inject
    lateinit var pokeApi: PokeApi
    private val appComponent = context.appComponent
    private val mutableLivePokemon = MutableLiveData<Pokemon>()
    val livePokemon: LiveData<Pokemon> = mutableLivePokemon

    init {
        appComponent.inject(this)
    }

    fun findPokemon(nameOrId: String): Single<Pokemon> {
        return pokeApi.getPokemonByNameOrId(nameOrId)
    }

/*    private fun isInt(textToFind: String): Boolean {
        return try {
            textToFind.toInt()
            true
        } catch (ex: NumberFormatException) {
            false
        }
    }*/

/*    private fun isIdOfPokemon(textInt: Int): Boolean {
        return textInt in MainViewModel.MIN_POKEMON_ID..MainViewModel.MAX_POKEMON_ID
    }*/

    companion object {
        private const val TAG = "Network"
        const val MIN_POKEMON_ID = 1
        const val MAX_POKEMON_ID = 905
        //TODO change min and max id constants to correct id

    }
}
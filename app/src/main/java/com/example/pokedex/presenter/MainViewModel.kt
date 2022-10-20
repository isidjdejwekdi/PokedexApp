package com.example.pokedex.presenter

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pokedex.data.remote.NetworkService
import com.example.pokedex.data.repository.PokeRepositoryImpl
import com.example.pokedex.data.storage.DBStorage
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.domain.usecase.FetchPokemonByNameOrIdUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val app: Application) : AndroidViewModel(app) {

    private var componentDisposable = CompositeDisposable()
    private var resultPokemonMutableLive = MutableLiveData<Pokemon>()//TODO var -> val
    val resultPokemonLive: LiveData<Pokemon> = resultPokemonMutableLive

    private val networkService: NetworkService = NetworkService(app.applicationContext)
    private val dbStorage: DBStorage = DBStorage(app.applicationContext)
    private val pokeRepositoryImpl = PokeRepositoryImpl(
        dbStorage = dbStorage,
        networkService = networkService
    )
    private val fetchPokemonByNameOrIdUseCase = FetchPokemonByNameOrIdUseCase(
        pokeRepository = pokeRepositoryImpl
    )

    fun findBtnPressed(p: String) {
        findPokemon(p)
    }

    private fun findPokemon(pokemonNameOrId: String) {
        val dispose = fetchPokemonByNameOrIdUseCase.execute(pokemonNameOrId)
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                resultPokemonMutableLive.value = it
            }, {

            })
        componentDisposable.add(dispose)
    }

    private fun showIncorrectIdDialog() {
        Log.e(
            TAG,
            "Pokemon ID is arranged in ${NetworkService.MIN_POKEMON_ID} to ${NetworkService.MAX_POKEMON_ID}"
        )
    }

    private fun showIncorrectNameDialog() {
        Log.e(TAG, "Such pokemon does not exist")
    }

    fun findRandomPokemon() {

    }

    fun getFavoritesList() {

    }

    fun resetFavoritesList() {

    }

    companion object {
        const val TAG = "ViewModel"
    }

    override fun onCleared() {
        Log.e("AAA", "VM Cleared")
        componentDisposable.dispose()
        super.onCleared()
    }

}
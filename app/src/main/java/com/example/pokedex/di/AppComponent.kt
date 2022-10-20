package com.example.pokedex.di

import com.example.pokedex.data.remote.NetworkService
import com.example.pokedex.presenter.MainActivity
import com.example.pokedex.presenter.fragments.FindByFragment
import com.example.pokedex.presenter.fragments.FindRandomFragment
import com.example.pokedex.presenter.fragments.MenuFragment
import dagger.Component

@Component(modules = [RemoteModule::class])
interface AppComponent {

    fun inject(networkService: NetworkService)
    fun inject(activity: MainActivity)
    fun inject(fragment: MenuFragment)
    fun inject(fragment: FindByFragment)
    fun inject(fragment: FindRandomFragment)
}
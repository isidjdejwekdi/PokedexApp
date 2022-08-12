package com.example.pokedex.di

import com.example.pokedex.data.repository.PokeApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class RemoteModule {
    private lateinit var pokeApi: PokeApi

    @Provides
    fun providePokeService(): PokeApi = configureRetrofit()

    private fun configureRetrofit(): PokeApi { //Dagger
        val httpLoggingInterceptor = HttpLoggingInterceptor()//Logging
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)//logging
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://pokeapi.co/api/v2/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()

        return retrofit.create(PokeApi::class.java)
    }
}
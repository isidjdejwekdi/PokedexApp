package com.example.pokedex.presenter

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pokedex.R
import com.example.pokedex.app.appComponent
import com.example.pokedex.data.model.CustomMenu
import com.example.pokedex.data.remote.PokeApi
import com.example.pokedex.databinding.ActivityMainBinding
import com.example.pokedex.domain.contract.HasCustomMenu
import com.example.pokedex.domain.contract.HasCustomTitle
import com.example.pokedex.domain.contract.Navigator
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity(), Navigator {
    private lateinit var binding: ActivityMainBinding
    private val compositeDisposable = CompositeDisposable()
    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.navHost_fragment_container)!!
    private lateinit var vm: MainViewModel
    private lateinit var navController: NavController

    @Inject
    lateinit var pokeService: PokeApi

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("AAA", "onCreate")
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHost_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)

        appComponent.inject(this)
/*        compositeDisposable.add(
            pokeService.getAnyPokemon()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    Toast.makeText(this, it.name, Toast.LENGTH_LONG).show()
                }, {
                    Log.e("TAG", "ERROR")
                })
        )*/
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    /*private fun updateUI() {
        val fragment = currentFragment

        if (fragment is HasCustomTitle){
            binding.toolbar.title = getString(fragment.getCustomTitleRes())
            //binding.toolbar.title = getString(fragment.getCustomTitleRes())
        } else {
            binding.toolbar.title = getString(R.string.app_name)
            //binding.toolbar.title = getString(R.string.app_name)

            if (supportFragmentManager.backStackEntryCount > 0){
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setDisplayShowHomeEnabled(true)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
                supportActionBar?.setDisplayShowHomeEnabled(false)
            }

        }
        if (fragment is HasCustomMenu){
            createCustomActionBar(fragment.getCustomMenu())
        } else {
            binding.toolbar.menu.clear()
        }
    }*/

    /*private fun createCustomActionBar(customMenu: CustomMenu){
        binding.toolbar.menu.clear()

        val menuItem = binding.toolbar.menu.add(customMenu.textRes)

        val iconDrawable = DrawableCompat.wrap(ContextCompat.getDrawable(
            this,
            customMenu.iconRes)!!)

        iconDrawable.setTint(Color.WHITE)
        menuItem.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS)
        menuItem.icon = iconDrawable
        menuItem.setOnMenuItemClickListener {
            customMenu.onCustomAction.run()
            return@setOnMenuItemClickListener true
        }
    }*/

    override fun goBack() {
        onBackPressed()
    }

    override fun showPokemonFindScreen() {
        TODO("Not yet implemented")
    }

    override fun showGetAnyPokemonScreen() {
        TODO("Not yet implemented")
    }

    override fun showFavoritesScreen() {
        TODO("Not yet implemented")
    }

    override fun goToMenu() {
        TODO("Not yet implemented")
    }

    override fun onResume() {
        Log.e("AAA", "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e("AAA", "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e("AAA", "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e("AAA", "onDestroy")
        compositeDisposable.dispose()
        super.onDestroy()
    }
}
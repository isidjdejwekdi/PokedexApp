package com.example.pokedex.presenter

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pokedex.R
import com.example.pokedex.app.appComponent
import com.example.pokedex.data.repository.PokeApi
import com.example.pokedex.databinding.ActivityMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    @Inject
    lateinit var pokeApi: PokeApi
    //private val compositeDisposable = CompositeDisposable()
    /*private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.navHost_fragment_container)!!*/
    private lateinit var vm: MainViewModel

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.Theme_Pokedex)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.navHost_fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        setupActionBarWithNavController(navController)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        vm.resultPokemonLive.observe(this) {
            Log.e(MainViewModel.TAG, it.toString())
        }

        appComponent.inject(this)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }


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

    override fun onResume() {
        Log.e(TAG, "onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.e(TAG, "onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.e(TAG, "onStop")
        super.onStop()
    }

    override fun onDestroy() {
        Log.e(TAG, "onDestroy")
        //compositeDisposable.dispose()
        super.onDestroy()
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
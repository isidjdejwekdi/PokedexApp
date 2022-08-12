package com.example.pokedex.presenter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.pokedex.R
import com.example.pokedex.app.appComponent
import com.example.pokedex.data.repository.PokeApi
import com.example.pokedex.databinding.ActivityMainBinding
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
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
        /*compositeDisposable.add(
            pokeService.getPokemonByName("pikachu")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({

                    Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
                    Log.e(TAG, it.toString())

                }, {
                    Log.e(TAG, "ERROR")
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
        compositeDisposable.dispose()
        super.onDestroy()
    }

    companion object{
        private const val TAG = "AAA"
    }
}
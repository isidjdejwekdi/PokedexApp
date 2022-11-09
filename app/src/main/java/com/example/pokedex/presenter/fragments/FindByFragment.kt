package com.example.pokedex.presenter.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentFindByBinding
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.presenter.MainViewModel

class FindByFragment : Fragment() {
    private lateinit var binding: FragmentFindByBinding
    private val viewModel: MainViewModel by activityViewModels()
    private lateinit var pokemonName: String
    private  val fetchObserver = Observer<Pokemon> {
        val dialogPokemon = PokemonCard()
        dialogPokemon.show(parentFragmentManager, "po")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.e("AAAfind", "onCreate")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindByBinding.inflate(inflater, container, false)

        binding.findBtn.setOnClickListener() {
            pokemonName = binding.findTextView.text.toString()
            if (pokemonName != "")
                viewModel.findBtnPressed(pokemonName)

        }

        viewModel.resultPokemonMutableLive.observe(viewLifecycleOwner, fetchObserver)

        Log.e("AAAfind", "onCreateView");
        Log.e("BACK", parentFragmentManager.backStackEntryCount.toString())



        return binding.root
    }

    private fun shoUpIfoDialog() {
        Toast.makeText(context, "Pokemon ID is arranged in 0 to 100", Toast.LENGTH_LONG).show()
    }

    override fun onAttach(context: Context) {
        Log.e("AAAfind", "onAttach")
        super.onAttach(context)
    }


    override fun onDetach() {
        Log.e("AAAfind", "onDetach")
        super.onDetach()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.e("AAAfind", "onDestroyView")
        viewModel.resultPokemonMutableLive.removeObserver(fetchObserver)
    }

    override fun onDestroy() {
        Log.e("AAAfind", "onDestroy")
        super.onDestroy()
    }
}
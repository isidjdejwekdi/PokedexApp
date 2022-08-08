package com.example.pokedex.presenter.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentMenuBinding

class MenuFragment : Fragment() {
lateinit var binding: FragmentMenuBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.e("AAAmenu", "onCreateView")
        binding = FragmentMenuBinding.inflate(inflater, container, false)

        binding.favoritesButton.setOnClickListener{
            favoritesBtnPressed()
        }

        binding.findByBtn.setOnClickListener{
            findByBtnPressed()
        }

        binding.findRandomBtn.setOnClickListener{
            findRandomBtnPressed()
        }

        Log.e("BACK", parentFragmentManager.backStackEntryCount.toString())

        return binding.root
    }

    private fun findRandomBtnPressed(){
        //Navigation.findNavController(binding.root).navigate(R.id.actionMenuToFindRandom)
        findNavController().navigate(R.id.actionMenuToFindRandom)
    }

    private fun findByBtnPressed(){

        //findNavController().navigate(R.id.actionMenuToFindRandom)
        findNavController().navigate(R.id.actionMenuToFindBy)
    }

    private fun favoritesBtnPressed(){
        //Navigation.findNavController(binding.root).navigate(R.id.actionMenuToFindRandom)
        //findNavController().navigate(R.id.actionMenuToFindRandom)
        findNavController().navigate(R.id.actionMenuToFavorites) //global?
    }

    override fun onAttach(context: Context) {
        Log.e("AAAmenu", "onAttach $this")

        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("AAAmenu", "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onDetach() {
        Log.e("AAAmenu", "onDetach")
        super.onDetach()
    }

    override fun onDestroyView() {
        Log.e("AAAmenu", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e("AAAmenu", "onDestroy")
        super.onDestroy()
    }



}
package com.example.pokedex.presenter.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentFavoritesBinding
import com.example.pokedex.domain.contract.HasCustomMenu
import com.example.pokedex.domain.contract.HasCustomTitle

class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFavoritesBinding.inflate(inflater, container, false)

        return binding.root
    }

}
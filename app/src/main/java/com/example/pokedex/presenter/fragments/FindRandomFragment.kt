package com.example.pokedex.presenter.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentFindRandomBinding
import com.example.pokedex.databinding.FragmentMenuBinding

class FindRandomFragment : Fragment() {
    lateinit var binding: FragmentFindRandomBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindRandomBinding.inflate(inflater, container, false)
        binding.backBtn.setOnClickListener{
            Navigation.findNavController(binding.root).navigate(R.id.actionFindRandomToMenu)
        }


        return binding.root
    }


}
package com.example.pokedex.presenter.fragments

import android.app.Dialog
import android.os.Bundle
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.activityViewModels
import com.example.pokedex.R
import com.example.pokedex.databinding.PokemonCardBinding
import com.example.pokedex.domain.models.Pokemon
import com.example.pokedex.presenter.MainViewModel
import com.squareup.picasso.Picasso


class PokemonCard() : DialogFragment() {

    lateinit var binding: PokemonCardBinding
    private val viewModel: MainViewModel by activityViewModels()
    private val currentPokemon: Pokemon by lazy { viewModel.resultPokemonMutableLive.value!! }
    private lateinit var starScaleAnimation: Animation

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val form: View = requireActivity().layoutInflater
            .inflate(R.layout.pokemon_card, null)

        val dialog = Dialog(requireActivity())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(form)
        dialog.window?.setGravity(Gravity.CENTER)

/*        val p = dialog.window?.attributes
        if (p != null) {
            p.width = ViewGroup.LayoutParams.MATCH_PARENT
            p.height = ViewGroup.LayoutParams.MATCH_PARENT
        }*/
        val width = resources.getDimensionPixelSize(R.dimen.card_width)
        val height = resources.getDimensionPixelSize(R.dimen.card_height)

        dialog.window?.setLayout(width, height)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)
        return dialog
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PokemonCardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvId.text = currentPokemon.id.toString()
        binding.tvName.text = currentPokemon.name
        binding.tvAbilities.text = currentPokemon.abilities.toList().toString()
        Picasso.get().load(currentPokemon.sprites.other.artwork.front_default).into(binding.ivPokemonImage)

    }


    private fun initPokemon() {

    }

}

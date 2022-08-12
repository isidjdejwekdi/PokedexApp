package com.example.pokedex.presenter.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.pokedex.R
import com.example.pokedex.databinding.FragmentFindByBinding
import com.example.pokedex.presenter.MainViewModel

class FindByFragment : Fragment() {
    private lateinit var binding: FragmentFindByBinding
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFindByBinding.inflate(inflater, container, false)

        Log.e("AAAfind", "onCreateView");

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.backBtn.setOnClickListener {
            findNavController().navigate(R.id.actionFindByToMenu)
        }

        binding.findBtn.setOnClickListener{
            if (!binding.findTextView.text.equals("")){
                viewModel.findPokemon(binding.findTextView.text)

            }
        }
    }

    private fun shoUpIfoDialog(){
        Toast.makeText(context, "Pokemon ID is arranged in 0 to 100", Toast.LENGTH_LONG).show()
    }

/*    override fun getCustomMenu(): CustomMenu {
        return CustomMenu(
            textRes = R.string.menu_text_1,
            iconRes = androidx.appcompat.R.drawable.abc_action_bar_item_background_material,
            onCustomAction = Runnable {
                onConfimPressed()
            }
        )
    }*/

    fun onConfimPressed() {

    }

    override fun onAttach(context: Context) {
        Log.e("AAAfind", "onAttach")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.e("AAAfind", "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onDetach() {
        Log.e("AAAfind", "onDetach")
        super.onDetach()
    }

    override fun onDestroyView() {
        Log.e("AAAfind", "onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.e("AAAfind", "onDestroy")
        super.onDestroy()
    }
}
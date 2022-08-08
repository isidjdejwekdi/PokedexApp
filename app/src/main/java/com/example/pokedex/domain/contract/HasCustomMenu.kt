package com.example.pokedex.domain.contract

import androidx.fragment.app.Fragment
import com.example.pokedex.data.model.CustomMenu

fun Fragment.navigator(): Navigator{
    return requireActivity() as Navigator
}

interface HasCustomMenu {

    fun getCustomMenu(): CustomMenu
}
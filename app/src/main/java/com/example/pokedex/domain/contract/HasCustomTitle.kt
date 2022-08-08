package com.example.pokedex.domain.contract

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

interface HasCustomTitle {

    fun getCustomTitleRes(): Int
}

/*
class CustomAction(
    @StringRes val textRes: Int,
    @DrawableRes val iconRes: Int,
    val onCustomAction: Runnable
)*/

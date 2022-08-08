package com.example.pokedex.data.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class CustomMenu(@DrawableRes val iconRes: Int,
                      @StringRes val textRes: Int,
                      val onCustomAction : Runnable)
package com.islamicfoundation.mbcmlp.theme

import androidx.appcompat.app.AppCompatDelegate
import com.islamicfoundation.mbcmlp.SharedPref

class ThemeProvider(
    private val sharedPref: SharedPref
) {

    companion object {
        private const val PREF_THEME = "pref_theme"
    }

    fun getCurrentTheme(): Int = sharedPref.read(
        PREF_THEME, AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
    )

    fun updateTheme(theme: Int) {
        sharedPref.write(PREF_THEME, theme)
    }

}
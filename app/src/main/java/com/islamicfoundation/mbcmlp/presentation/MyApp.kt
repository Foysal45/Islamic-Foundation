package com.islamicfoundation.mbcmlp.presentation

import androidx.appcompat.app.AppCompatDelegate
import androidx.multidex.MultiDexApplication
import com.islamicfoundation.mbcmlp.SharedPref
import com.islamicfoundation.mbcmlp.di.WrapperEntryPoint
import com.islamicfoundation.mbcmlp.lang.LanguageProvider
import com.islamicfoundation.mbcmlp.theme.ThemeProvider
import dagger.hilt.android.EntryPointAccessors
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class MyApp : MultiDexApplication() {

    @Inject
    lateinit var sharedPref: SharedPref

    @Inject
    lateinit var themeProvider: ThemeProvider

    lateinit var languageProvider: LanguageProvider

    override fun onCreate() {
        super.onCreate()
        languageProvider = EntryPointAccessors.fromApplication(this, WrapperEntryPoint::class.java)
            .languageProvider()

        val theme = themeProvider.getCurrentTheme()
        AppCompatDelegate.setDefaultNightMode(theme)

    }
}
package com.islamicfoundation.mbcmlp.presentation.activities.main

import com.islamicfoundation.mbcmlp.lang.LanguageProvider
import com.islamicfoundation.mbcmlp.presentation.fragment.base.BaseViewModel
import com.islamicfoundation.mbcmlp.util.UserFactory
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val userFactory: UserFactory,
    private val languageProvider: LanguageProvider
) : BaseViewModel() {


    fun hasLoggedIn(): Boolean = userFactory.getAccessToken().isNotEmpty()

    fun doLogout() {
        userFactory.clear()
    }





}
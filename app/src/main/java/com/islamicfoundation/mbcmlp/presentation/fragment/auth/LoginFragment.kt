package com.islamicfoundation.mbcmlp.presentation.fragment.auth

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.viewModels
import com.islamicfoundation.mbcmlp.*
import com.islamicfoundation.mbcmlp.databinding.FragmentLoginBinding
import com.islamicfoundation.mbcmlp.lang.LanguageChangeListener
import com.islamicfoundation.mbcmlp.lang.LanguageProvider
import com.islamicfoundation.mbcmlp.presentation.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    R.layout.fragment_login
) {

    @Inject
    lateinit var languageProvider: LanguageProvider

    companion object {
        private const val TAG = "LoginFragment"
    }
    override val viewModel by viewModels<LoginViewModel>()

    override fun initializeViewBinding(view: View) = FragmentLoginBinding.bind(view)




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN) //for FullScreen View Except appbar or title bar

        }
    }

package com.islamicfoundation.mbcmlp.presentation.fragment.auth

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import com.islamicfoundation.mbcmlp.*
import com.islamicfoundation.mbcmlp.databinding.FragmentLoginBinding
import com.islamicfoundation.mbcmlp.lang.LanguageChangeListener
import com.islamicfoundation.mbcmlp.lang.LanguageProvider
import com.islamicfoundation.mbcmlp.presentation.activities.main.MainActivity
import com.islamicfoundation.mbcmlp.presentation.fragment.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class LoginFragment : BaseFragment<LoginViewModel, FragmentLoginBinding>(
    R.layout.fragment_login
) {
    @Inject
    lateinit var languageProvider: LanguageProvider

    private var languageChangeListener: LanguageChangeListener? = null
    companion object {
        private const val TAG = "LoginFragment"
    }
    override val viewModel by viewModels<LoginViewModel>()

    override fun initializeViewBinding(view: View) = FragmentLoginBinding.bind(view)

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            languageChangeListener = context as LanguageChangeListener?
        } catch (e: Exception) {
            Log.e(TAG, "onAttach: ${e.message}")
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         activity?.window?.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN) //for FullScreen View Except appbar or title bar

        setupListeners()
        subscribeObservers()

        if (BuildConfig.DEBUG) {
            binding.userIdInput.setText("01957206205")
            binding.userPasswordInput.setText("s1234")
        }
    }

    private fun setupListeners() {
        binding.userIdInput.addTextChangedListener { text: Editable? ->
            text?.toString()?.let {
                viewModel.onLoginEvent(LoginFormEvent.PhoneChanged(it))
            }
        }

        binding.userPasswordInput.addTextChangedListener { text: Editable? ->
            text?.toString()?.let {
                viewModel.onLoginEvent(LoginFormEvent.PasswordChanged(it))
            }
        }

        binding.btnLogin.setOnClickListener {
            viewModel.onLoginEvent(LoginFormEvent.Submit)
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
    }


    private fun subscribeObservers() {
        viewModel.error.observe(viewLifecycleOwner) { error ->
            if (error != null) {
                showError(error)
            } else {
               // binding.tvError.hide()
            }
        }

        viewModel.validationEvent.observe(viewLifecycleOwner) { event ->
            when (event) {
                is ValidationEvent.Failure -> {
                    showError(event.text)
                    navigateToMainFragment()
                }
                ValidationEvent.Success -> {
                   // binding.tvError.text = ""
                    navigateToMainFragment()
                }
            }
        }
    }

    private fun showError(text: UiText) {
//        binding.tvError.text = text.asString(requireContext())
//        if (!binding.tvError.isVisible()) {
//            binding.tvError.show()
//        }
    }

    private fun navigateToMainFragment() {
        requireActivity().startActivity(
            Intent(requireActivity(), MainActivity::class.java)
        )
        requireActivity().finish()
    }



}
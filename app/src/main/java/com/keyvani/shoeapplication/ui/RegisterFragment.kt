package com.keyvani.shoeapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isNotEmpty
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.keyvani.shoeapplication.R
import com.keyvani.shoeapplication.databinding.FragmentRegisterBinding


class RegisterFragment : Fragment() {

    private lateinit var binding: FragmentRegisterBinding




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {

            btnSignUp.setOnClickListener {
                val name = edtName.text.toString()
                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()
                if(name.isNotEmpty() || email.isNotEmpty()|| password.isNotEmpty()){
                    view.findNavController().navigate(
                        RegisterFragmentDirections
                            .actionRegisterFragmentToWelcomeFragment()
                    )
                }else{
                    Snackbar.make(it, getString(R.string.fillAllFields), Snackbar.LENGTH_SHORT).show()
                }

            }
            btnSignIn.setOnClickListener {
                val name = edtName.text.toString()
                val email = edtEmail.text.toString()
                val password = edtPassword.text.toString()
                if(name.isNotEmpty() || email.isNotEmpty()|| password.isNotEmpty()){
                    view.findNavController().navigate(
                        RegisterFragmentDirections
                            .actionRegisterFragmentToWelcomeFragment()
                    )
                }else{
                    Snackbar.make(it, getString(R.string.fillAllFields), Snackbar.LENGTH_SHORT).show()
                }

            }
        }
    }


}
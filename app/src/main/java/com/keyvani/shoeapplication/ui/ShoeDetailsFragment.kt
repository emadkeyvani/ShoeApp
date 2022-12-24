package com.keyvani.shoeapplication.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.keyvani.shoeapplication.databinding.FragmentShoeDetailsBinding


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnCancel.setOnClickListener{
                view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            }
            btnSave.setOnClickListener{
                view.findNavController().navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            }
        }
    }


}
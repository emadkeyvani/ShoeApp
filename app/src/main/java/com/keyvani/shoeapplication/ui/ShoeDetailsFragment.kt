package com.keyvani.shoeapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.keyvani.shoeapplication.R
import com.keyvani.shoeapplication.databinding.FragmentShoeDetailsBinding
import com.keyvani.shoeapplication.model.Shoe
import com.keyvani.shoeapplication.viewmodel.ShoeViewModel


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding

   // private val shoeViewModel: ShoeViewModel by activityViewModels()

   private lateinit var shoeViewModel : ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        binding.shoeViewModel = shoeViewModel
        binding.lifecycleOwner = this

        binding.apply {
            btnCancel.setOnClickListener {
                view.findNavController()
                    .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            }
            btnSave.setOnClickListener {
                if(edtShoeName.text.isNotEmpty() || edtSize.text.isNotEmpty()|| edtCompany.text.isNotEmpty()||edtCompany.text.isNotEmpty()){
                    shoeViewModel?.addShoe(shoeViewModel!!.getShoeDetails())
                    view.findNavController()
                        .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
                }else{
                    Snackbar.make(it, getString(R.string.fillAllFields), Snackbar.LENGTH_SHORT).show()
                }
            }
        }
    }

}
package com.keyvani.shoeapplication.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.google.android.material.snackbar.Snackbar
import com.keyvani.shoeapplication.R
import com.keyvani.shoeapplication.databinding.FragmentShoeDetailsBinding
import com.keyvani.shoeapplication.model.Shoe
import com.keyvani.shoeapplication.viewmodel.ShoeViewModel


class ShoeDetailsFragment : Fragment() {
    private lateinit var binding: FragmentShoeDetailsBinding

    private val shoeViewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.apply {
            btnCancel.setOnClickListener {
                view.findNavController()
                    .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
            }
            btnSave.setOnClickListener {
                val name = edtShoeName.text.toString()
                val size = edtSize.text.toString()
                val company = edtCompany.text.toString()
                val desc= edtDescription.text.toString()
                if(name.isNotEmpty() || size.isNotEmpty()|| company.isNotEmpty()||desc.isNotEmpty()){
                    shoeViewModel.addShoe(getShoeDetails(name,size,company,desc))
                    view.findNavController()
                        .navigate(ShoeDetailsFragmentDirections.actionShoeDetailsFragmentToShoeListFragment())
                }else{
                    Snackbar.make(it, getString(R.string.fillAllFields), Snackbar.LENGTH_SHORT).show()
                }


            }
        }
    }

    private fun getShoeDetails(name:String,size:String,company:String,desc:String): Shoe {
        val shoe = Shoe("", 0.0, "", "")
        shoe.name = name
        shoe.size = size.toDouble()
        shoe.company = company
        shoe.description = desc
        return shoe
    }


}
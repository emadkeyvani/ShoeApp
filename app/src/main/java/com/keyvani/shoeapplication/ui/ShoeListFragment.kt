package com.keyvani.shoeapplication.ui

import android.os.Bundle
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.keyvani.shoeapplication.R
import com.keyvani.shoeapplication.databinding.FragmentShoeListBinding
import com.keyvani.shoeapplication.model.Shoe
import com.keyvani.shoeapplication.viewmodel.ShoeViewModel


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding

    private val shoeViewModel: ShoeViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shoeViewModel.shoeList.observe(viewLifecycleOwner, Observer { newShoeList ->
            updateShoeList(newShoeList)
        })
        binding.apply {

            fabAddDetails.setOnClickListener {
                view.findNavController().navigate(
                    ShoeListFragmentDirections
                        .actionShoeListFragmentToShoeDetailsFragment()
                )
            }

            val menuHost: MenuHost = requireActivity()

            menuHost.addMenuProvider(object : MenuProvider {
                override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                    menuInflater.inflate(R.menu.main_menu, menu)
                }

                override fun onMenuItemSelected(item: MenuItem): Boolean {
                    return when (item.itemId) {
                        R.id.shoeListFragment -> {
                            Navigation.findNavController(requireView())
                                .navigate(R.id.action_global_registerFragment)
                            true
                        }

                        else -> false
                    }
                }
            }, viewLifecycleOwner, Lifecycle.State.RESUMED)
        }
    }

    private fun updateShoeList(shoesList: List<Shoe>) {
        val shoesLayout =
            binding.root.findViewById<LinearLayout>(R.id.shoeListLayout)
        shoesList.forEach { shoe ->

            val lp = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT

            )
            val shoeItemTextView: TextView =
                TextView(requireContext()).apply {
                    lp.gravity = Gravity.START
                    layoutParams = lp
                }

            shoeItemTextView.text = "${shoe.name + " "}  ${shoe.company + " "} ${shoe.size.toString() + " "} ${shoe.description + " "}"
            shoesLayout.addView(shoeItemTextView)
        }
    }

}
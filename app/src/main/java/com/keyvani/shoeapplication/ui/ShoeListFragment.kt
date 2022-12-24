package com.keyvani.shoeapplication.ui

import android.os.Bundle
import android.view.*
import androidx.core.view.MenuHost
import androidx.core.view.MenuProvider
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.keyvani.shoeapplication.R
import com.keyvani.shoeapplication.databinding.FragmentShoeListBinding


class ShoeListFragment : Fragment() {
    private lateinit var binding: FragmentShoeListBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentShoeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            btnReadMore.setOnClickListener {
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

}
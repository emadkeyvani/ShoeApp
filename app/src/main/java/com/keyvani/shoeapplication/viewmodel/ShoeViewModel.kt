package com.keyvani.shoeapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keyvani.shoeapplication.model.Shoe

class ShoeViewModel : ViewModel() {

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val initialShoeList = mutableListOf<Shoe>(
        Shoe("Bolt", 42.0, "Skechers", "Men  shoes for running"),
        Shoe("Sapphire", 41.5, "Adidas", "Men classic  shoes")
    )

    init {
        _shoeList.value = mutableListOf()
        initialList()
    }

    private fun initialList() {
        initialShoeList.forEach { shoe: Shoe ->
            addShoe(shoe)
        }
    }

    fun addShoe(shoe: Shoe) {
        _shoeList.value?.add(shoe)
    }


}
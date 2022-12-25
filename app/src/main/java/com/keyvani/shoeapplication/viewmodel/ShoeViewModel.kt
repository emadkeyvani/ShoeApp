package com.keyvani.shoeapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keyvani.shoeapplication.model.Shoe

class ShoeViewModel : ViewModel() {

    var shoeName: MutableLiveData<String> = MutableLiveData()
    var shoeDesc: MutableLiveData<String> = MutableLiveData()
    var shoeSize: MutableLiveData<String> = MutableLiveData()
    var company: MutableLiveData<String> = MutableLiveData()

    private val _shoeList = MutableLiveData<MutableList<Shoe>>()

    val shoeList: LiveData<MutableList<Shoe>>
        get() = _shoeList

    private val initialShoeList = mutableListOf(
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

 fun getShoeDetails(): Shoe {
        val shoe = Shoe("", 0.0, "", "")
        shoe.name = shoeName.value.toString()
        shoe.size = shoeSize.value.toString().toDouble()
        shoe.company = company.value.toString()
        shoe.description = shoeDesc.value.toString()
        return shoe
    }

}
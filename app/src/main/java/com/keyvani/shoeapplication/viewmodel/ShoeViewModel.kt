package com.keyvani.shoeapplication.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.keyvani.shoeapplication.model.Shoe

class ShoeViewModel : ViewModel() {

    private val _eventShoeAddFinish = MutableLiveData<Boolean>()
    val eventShoeAddFinish: LiveData<Boolean>
        get() = _eventShoeAddFinish

    private var _shoeAdd: MutableLiveData<Boolean> = MutableLiveData()
    val shoeAdd: LiveData<Boolean>
        get() = _shoeAdd

    private var _shoeList = MutableLiveData<MutableList<Shoe>>()
    val shoeList: MutableLiveData<MutableList<Shoe>>
        get() = _shoeList

    var shoeName: MutableLiveData<String> = MutableLiveData()


    var shoeCompany: MutableLiveData<String> = MutableLiveData()

    var shoeSize: MutableLiveData<String> = MutableLiveData()

    var shoeDetail: MutableLiveData<String> = MutableLiveData()

    init {
        shoeList.value = mutableListOf()
        shoeName.value = "UdacityShoe"
        shoeCompany.value = "Udacity"
        shoeSize.value = "11.0"
        shoeDetail.value = "UdacityDetail"
        _shoeAdd.value = true
        _eventShoeAddFinish.value = true

    }

    fun onSaveDetail() {

        val shoe = shoeSize.value?.let {
            Shoe(
                shoeName.value.toString(),
                it.toDouble(),
                shoeCompany.value.toString(),
                shoeDetail.value.toString()
            )
        }
        shoe?.let {
            val updatedList = _shoeList.value
            updatedList?.add(it)
            shoeList.value = updatedList?.toMutableList()
        }

    }

    fun onChooseComplete() {
        _eventShoeAddFinish.value = false
    }


}
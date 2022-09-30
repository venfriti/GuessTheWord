package com.udacity.shoestore.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.udacity.shoestore.models.Shoe

class ListingViewModel : ViewModel() {

    private var shoesList = mutableListOf<Shoe>()

    private var _shoes =MutableLiveData<List<Shoe>>()
    val shoes: LiveData<List<Shoe>>
        get() = _shoes


    fun onSave(name: String, size: String, company: String, description: String){
        val newItem = Shoe(name, size, company, description)
        newItem.let { item ->
            shoesList.add(item)
            _shoes.value=shoesList
        }
    }

}
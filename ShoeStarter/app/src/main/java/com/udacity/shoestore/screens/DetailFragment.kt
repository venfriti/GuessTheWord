package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.models.Shoe
import com.udacity.shoestore.databinding.FragmentDetailBinding
import com.udacity.shoestore.viewmodels.ListingViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    lateinit var viewModelData: ListingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_detail, container, false
        )

        binding.listDetailsShoe = Shoe()

        binding.saveButton.setOnClickListener { view: View? ->
            saveShoeDetails()
        }

        viewModelData = ViewModelProvider(requireActivity())[ListingViewModel::class.java]

        binding.cancelButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_detailFragment2_to_listingFragment)
        )
        return binding.root
    }

    private fun saveShoeDetails() {

        val bindingList = binding.listDetailsShoe
        val name = bindingList?.name.toString()
        val size = bindingList?.size.toString()
        val company = bindingList?.company.toString()
        val description = bindingList?.description.toString()

        if ( name.isEmpty() || size.isEmpty() || company.isEmpty() || description.isEmpty()){
            Toast.makeText(context, "Fill in all the information", Toast.LENGTH_SHORT).show()
        }
        else {
            viewModelData.onSave("Name: $name", "Size: $size", "Company: $company", "Description: $description" )

            findNavController().navigate(R.id.action_detailFragment2_to_listingFragment)
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show()
        }
    }

}
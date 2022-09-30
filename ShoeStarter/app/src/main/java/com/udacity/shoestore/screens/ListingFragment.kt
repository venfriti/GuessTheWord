package com.udacity.shoestore.screens

import android.os.Bundle
import android.view.*
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.AddedViewBinding
import com.udacity.shoestore.databinding.FragmentListingBinding
import com.udacity.shoestore.viewmodels.ListingViewModel
import com.udacity.shoestore.models.Shoe
import kotlinx.android.synthetic.main.added_view.*
import kotlinx.android.synthetic.main.fragment_detail.*

class ListingFragment : Fragment() {

    private lateinit var binding: FragmentListingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_listing, container, false)
        setHasOptionsMenu(true)

        binding.floatingActionButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_listingFragment_to_detailFragment2)
        )

        val viewModel = ViewModelProvider(requireActivity())[ListingViewModel::class.java]

        viewModel.shoes.observe(viewLifecycleOwner, Observer{ item ->
            shoeListView(item)
        })

        binding.lifecycleOwner=viewLifecycleOwner

        return binding.root
    }

    private fun shoeListView(item: List<Shoe>?) {
        item?.forEach{
            val bindings = AddedViewBinding.inflate(LayoutInflater.from(requireContext()), binding.linearLayout, false)
            with(bindings){
                shoeNames.text=it.name
                sizeNames.text=it.size
                companyNames.text=it.company
                descriptionNames.text=it.description
            }
            binding.linearLayout?.addView(bindings.root)
        }

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.overflow_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController())
                ||super.onOptionsItemSelected(item)
    }
}
package com.udacity.shoestore.screens

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_title, container, false)

        binding.loginButton.setOnClickListener (
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment2_to_welcomeFragment)
        )

        binding.registerButton.setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_titleFragment2_to_welcomeFragment)
        )

        return binding.root
    }

}
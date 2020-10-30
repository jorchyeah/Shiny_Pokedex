package com.example.shinypokedex.overview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.shinypokedex.R
import com.example.shinypokedex.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentOverviewBinding>(
                inflater,
                R.layout.fragment_overview,
                container,
                false
        )
        return binding.root
    }
}
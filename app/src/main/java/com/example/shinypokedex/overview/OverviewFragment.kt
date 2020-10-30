package com.example.shinypokedex.overview

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shinypokedex.R
import com.example.shinypokedex.databinding.FragmentOverviewBinding

class OverviewFragment : Fragment() {

    private val viewModel: OverviewViewModel by lazy {
        ViewModelProvider(this).get(OverviewViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentOverviewBinding>(
            inflater,
            R.layout.fragment_overview,
            container,
            false
        )

        binding.lifecycleOwner = this

        binding.viewModel = viewModel

        binding.pokemonRecycler.adapter = OverviewAdapter()

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.overview_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }
}
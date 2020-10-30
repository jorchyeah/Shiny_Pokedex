package com.example.shinypokedex.overview

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.shinypokedex.R
import com.example.shinypokedex.databinding.FragmentOverviewBinding
import com.example.shinypokedex.network.PokemonApiFilters

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
        inflater.inflate(R.menu.overview_menu, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        viewModel.updateFeed(
            when (item.itemId) {
                R.id.show_kanto -> PokemonApiFilters.SHOW_KANTO
                R.id.show_johto -> PokemonApiFilters.SHOW_JOHTO
                R.id.show_hoenn -> PokemonApiFilters.SHOW_HOENN
                R.id.show_sinnoh -> PokemonApiFilters.SHOW_SINNOH
                R.id.show_unova -> PokemonApiFilters.SHOW_UNOVA
                R.id.show_kalos -> PokemonApiFilters.SHOW_KALOS
                R.id.show_alola -> PokemonApiFilters.SHOW_ALOLA
                R.id.show_galar -> PokemonApiFilters.SHOW_GALAR
                else -> PokemonApiFilters.SHOW_DEMO
            }
        )
        return true
    }
}
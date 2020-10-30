package com.example.shinypokedex

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shinypokedex.network.Pokemon
import com.example.shinypokedex.overview.OverviewAdapter

@BindingAdapter("listData")
fun bindRecyclerViewData(recyclerView: RecyclerView, data: List<Pokemon>?) {
    val adapter = recyclerView.adapter as OverviewAdapter
    adapter.submitList(data)
}
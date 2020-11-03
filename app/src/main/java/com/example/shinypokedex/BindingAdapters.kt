package com.example.shinypokedex

import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.shinypokedex.network.Pokemon
import com.example.shinypokedex.overview.OverviewAdapter

@BindingAdapter("listData")
fun bindRecyclerViewData(recyclerView: RecyclerView, data: List<Pokemon>?) {
    val adapter = recyclerView.adapter as OverviewAdapter
    adapter.submitList(data)
}

@BindingAdapter("imgUrl")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {
        val imgUri = imgUrl
            .toUri()
            .buildUpon()
            .scheme("https")
            .build()

        Glide.with(imgView.context)
            .asGif()
            .load(imgUri)
            .apply(
                RequestOptions
                    .placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(imgView)
    }
}
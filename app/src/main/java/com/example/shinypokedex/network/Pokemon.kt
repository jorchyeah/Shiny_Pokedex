package com.example.shinypokedex.network

data class JsonResponse(val results: List<Pokemon>)
data class Pokemon(
    val name: String,
    val url: String,
    val uri: String = "https://raw.githubusercontent.com/tdmalone/pokecss-media/master/graphics/pokemon/front-shiny/${name}.gif"
)
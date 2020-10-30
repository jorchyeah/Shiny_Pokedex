package com.example.shinypokedex.network

data class JsonResponse(val results: List<Pokemon>)
data class Pokemon(val name: String, val url: String)
package com.example.shinypokedex.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private val BASE_URL = "https://pokeapi.co/api/v2/"

private val moshi = Moshi
    .Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit
    .Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

enum class PokemonApiFilters(val offset: Int, val limit: Int) {
    SHOW_DEMO(offset = 0, limit = 10),
    SHOW_KANTO(offset = 0, limit = 151),
    SHOW_JOHTO(offset = 151, limit = 100),
    SHOW_HOENN(offset = 251, limit = 135),
    SHOW_SINNOH(offset = 386, limit = 107),
    SHOW_UNOVA(offset = 494, limit = 155),
    SHOW_KALOS(offset = 649, limit = 72),
    SHOW_ALOLA(offset = 721, limit = 88),
    SHOW_GALAR(offset = 809, limit = 89),
    SHOW_ALL(offset = 0, limit = 898)
}

interface PokemonApiService {
    @GET("pokemon")
    suspend fun getPokemon(
        @Query("offset") offset: Int,
        @Query("limit") limit: Int
    ): JsonResponse

    object PokemonApi {
        val retrofitService: PokemonApiService by lazy {
            retrofit.create(PokemonApiService::class.java)
        }
    }
}
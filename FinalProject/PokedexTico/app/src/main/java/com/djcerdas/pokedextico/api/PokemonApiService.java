package com.djcerdas.pokedextico.api;

import com.djcerdas.pokedextico.model.PokemonList;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonApiService {
    @GET("pokemon/")
        Call<List<PokemonList>> getPokemonList(@Query("offset") int offset, @Query("limit") int limit);
}

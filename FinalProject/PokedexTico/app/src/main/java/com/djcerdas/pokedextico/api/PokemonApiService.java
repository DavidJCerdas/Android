package com.djcerdas.pokedextico.api;

import com.djcerdas.pokedextico.model.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonApiService {
    @GET("pokemon/{offset}/{limit}")
        Call<List<Pokemon>> getPokemon(@Query("offset") int offset, @Query("limit") int limit);
}

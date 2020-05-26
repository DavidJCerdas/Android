package com.djcerdas.pokedextico.api;

import com.djcerdas.pokedextico.model.Pokemon;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PokemonApiGetOne {
    @GET("api/v2/pokemon/{pokemonName}")
    Call<List<Pokemon>> getPokemon(@Query("pokemonName") String pokemonName);
}

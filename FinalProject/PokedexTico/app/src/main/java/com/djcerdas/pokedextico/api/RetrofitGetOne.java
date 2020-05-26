package com.djcerdas.pokedextico.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitGetOne {
    PokemonApiGetOne pokemonApiGetOne;

    public RetrofitGetOne(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonApiGetOne pokemonApiGetOne = retrofit.create(PokemonApiGetOne.class);
    }

    public PokemonApiGetOne getPokemonApiGetOne() {
        return pokemonApiGetOne;
    }
}

/*
*
* package com.djcerdas.pokedextico.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitProvider {

    PokemonApiService pokemonApiService;

    public RetrofitProvider(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        PokemonApiService pokemonApiService = retrofit.create(PokemonApiService.class);
    }

    public PokemonApiService getPokemonApiService() {
        return pokemonApiService;
    }
}

* */
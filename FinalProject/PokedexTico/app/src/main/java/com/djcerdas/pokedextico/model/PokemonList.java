package com.djcerdas.pokedextico.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonList {
    @SerializedName("results")
    private List<PokemonInfo> pokemonInfoList;

    public List<PokemonInfo> getPokemonInfoList() {
        return pokemonInfoList;
    }

}


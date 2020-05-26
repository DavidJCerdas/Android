package com.djcerdas.pokedextico.model;

import com.google.gson.annotations.SerializedName;

public class PokemonList {
    @SerializedName("Name")
    private String name;
    @SerializedName("url")
    private String url;

    public String getUrl() {
        return url;
    }

    public String getName() {
        return name;
    }
}

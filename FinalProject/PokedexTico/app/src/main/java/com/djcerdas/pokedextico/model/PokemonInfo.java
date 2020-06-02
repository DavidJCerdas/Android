package com.djcerdas.pokedextico.model;
import com.google.gson.annotations.SerializedName;

public class PokemonInfo {
    public PokemonInfo(String name, String url, Boolean isFavorite) {
        this.name = name;
        this.url = url;
        this.isFavorite = isFavorite;
    }

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("is_favorite")
    private Boolean isFavorite;



    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public Boolean getFavorite() {
        return isFavorite;
    }
}
package com.djcerdas.pokedextico.model;
import com.google.gson.annotations.SerializedName;

public class PokemonInfo {
    public PokemonInfo(Integer id, String name, String url, Boolean isFavorite) {
        this.pokemonID = id;
        this.name = name;
        this.url = url;
        this.isFavorite = isFavorite;
    }

    private int pokemonID;

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("is_favorite")
    private Boolean isFavorite;

    public Integer getPokemonID() {
        return pokemonID;
    }

    public void setPokemonID(int pokemonID) {
        this.pokemonID = pokemonID;
    }

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
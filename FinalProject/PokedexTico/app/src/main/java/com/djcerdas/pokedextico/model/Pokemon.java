package com.djcerdas.pokedextico.model;

import com.google.gson.annotations.SerializedName;

// ej. https://pokeapi.co/api/v2/pokemon/bulbasaur
public class Pokemon {
    @SerializedName("name")
    private String 	name;
    @SerializedName("id")
    private int id;
    @SerializedName("weight")
    private int weight;

    private String spritesFrontDefault;
    private String[] move;
    private String[] type;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public String getSpritesFrontDefault() {
        return spritesFrontDefault;
    }

    public String[] getMove() {
        return move;
    }

    public String[] getType() {
        return type;
    }
}

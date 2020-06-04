package com.djcerdas.pokedextico;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.djcerdas.pokedextico.adapter.PokemonAdapter;
import com.djcerdas.pokedextico.model.PokemonInfo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        recyclerView = findViewById(R.id.recycler_view_layout);
        initRecyclerView();

    }

    private void initRecyclerView() {
        fillMockData();
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private void fillMockData(){
        List<PokemonInfo> pokemons = new ArrayList<>();
        PokemonInfo pokemonInfo = new PokemonInfo("Pokemon Name X", "url del pokemon 1", Boolean.TRUE);
        pokemons.add(pokemonInfo);
        pokemonInfo = new PokemonInfo("Pokemon Name Y", "url del pokemon 2", Boolean.TRUE);
        pokemons.add(pokemonInfo);
        pokemonInfo = new PokemonInfo("Pokemon Name Z", "url del pokemon 3", Boolean.TRUE);
        pokemons.add(pokemonInfo);
        pokemonInfo = new PokemonInfo("Pokemon Name H", "url del pokemon 4", Boolean.TRUE);
        pokemons.add(pokemonInfo);

        pokemonAdapter = new PokemonAdapter(pokemons);

    }

    @Override
    protected void onResume() {
        super.onResume();
        this.getPokemonList();
    }

    private void getPokemonList() {

    }
}



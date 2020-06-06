package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.djcerdas.pokedextico.Listener.OnPokemonClicked;
import com.djcerdas.pokedextico.R;
import com.djcerdas.pokedextico.adapter.PokemonAdapter;
import com.djcerdas.pokedextico.model.PokemonInfo;

import java.util.ArrayList;
import java.util.List;

public class RecycleViewFragment extends Fragment implements OnPokemonClicked {

    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter(this::onClicked);

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.recycler_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        super.onCreate(savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view_layout);
        initRecyclerView();
    }

    private void initRecyclerView() {
        fillMockData();
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

    private void fillMockData() {
        List<PokemonInfo> pokemons = new ArrayList<>();
        PokemonInfo pokemonInfo = new PokemonInfo("Pokemon Name X", "url del pokemon 1", Boolean.TRUE);
        pokemons.add(pokemonInfo);
        pokemonInfo = new PokemonInfo("Pokemon Name Y", "url del pokemon 2", Boolean.TRUE);
        pokemons.add(pokemonInfo);
        pokemonInfo = new PokemonInfo("Pokemon Name Z", "url del pokemon 3", Boolean.TRUE);
        pokemons.add(pokemonInfo);
        pokemonInfo = new PokemonInfo("Pokemon Name HO HO HO", "url del pokemon 4", Boolean.TRUE);
        pokemons.add(pokemonInfo);
        pokemonAdapter.setPokemonInfoList(pokemons);
    }


    @Override
    public void onResume() {
        super.onResume();
        this.getPokemonList();
    }

    private void getPokemonList() {
    }

    @Override
    public void onClicked(PokemonInfo pokemonInfo) {
        Log.d("Fragment - Item Clicked", pokemonInfo.getName());
    }
}

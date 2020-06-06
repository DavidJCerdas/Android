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
import com.djcerdas.pokedextico.api.RetrofitProvider;
import com.djcerdas.pokedextico.model.PokemonInfo;
import com.djcerdas.pokedextico.model.PokemonList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecycleViewFragment extends Fragment implements OnPokemonClicked {
    private int POKEMONTOQUERY = 35;
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

        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApiService().getPokemonList(0, POKEMONTOQUERY).enqueue(new Callback<PokemonList>() {
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.isSuccessful()) {
                    for (int creature = 0; creature < POKEMONTOQUERY; creature++) {
                        PokemonInfo pokemonInfo = new PokemonInfo(response.body().getPokemonInfoList().get(creature).getName(), response.body().getPokemonInfoList().get(creature).getUrl().toString(), Boolean.FALSE);
                        pokemons.add(pokemonInfo);
                    }
                    Log.d("POKERROR", pokemons.get(0).getName() + ", URL:" + pokemons.get(0).getUrl() + ", Is Favorite:" + pokemons.get(0).getFavorite());
                } else {
                    Log.d("POKERROR", "Not able to fill pokemons with the data from getPokemonApiService()");
                }
                pokemonAdapter.setPokemonInfoList(pokemons);
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable error) {
                Log.e("POKERROR", error.getLocalizedMessage());
            }
        });


    }


    @Override
    public void onResume() {
        super.onResume();

    }


    @Override
    public void onClicked(PokemonInfo pokemonInfo) {
        Log.d("Fragment - Item Clicked", pokemonInfo.getName());
    }
}

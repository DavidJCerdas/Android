package com.djcerdas.pokedextico.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.djcerdas.pokedextico.api.RetrofitProvider;
import com.djcerdas.pokedextico.model.PokemonInfo;
import com.djcerdas.pokedextico.model.PokemonList;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonViewModel extends ViewModel {
    private int POKEMONTOQUERY = 40;

    private RetrofitProvider retrofitProvider = new RetrofitProvider();


    public PokemonViewModel(RetrofitProvider provider) {
        this.retrofitProvider = provider;
    }

    private MutableLiveData<PokemonList> pokemonList = new MutableLiveData<PokemonList>();
    private MutableLiveData<PokemonList> pokemonNull = new MutableLiveData<PokemonList>();


    public void getPokemonList() {
        List<PokemonInfo> pokemons = new ArrayList<>();

        retrofitProvider.getPokemonApiService().getPokemonList(0, POKEMONTOQUERY).enqueue(new Callback<PokemonList>() {
            @Override
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.isSuccessful()) {
                    response.body();
                } else {
                    pokemonList.postValue(null);
                }
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable t) {
                pokemonList.postValue(null);
            }
        });
    }

    public LiveData<PokemonList> getPokemonListLiveData() {
        return pokemonList;
    }
}

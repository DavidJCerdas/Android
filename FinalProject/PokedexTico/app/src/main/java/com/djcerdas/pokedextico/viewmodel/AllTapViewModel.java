package com.djcerdas.pokedextico.viewmodel;

import android.util.Log;

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


public class AllTapViewModel<list> extends ViewModel {
    private int POKEMONTOQUERY = 35;


    public LiveData<List<PokemonInfo>> getPokemonList() {
        return pokemonList;
    }

    private MutableLiveData<List<PokemonInfo>> pokemonList = new MutableLiveData<List<PokemonInfo>>();

    public void getpokemonListFromServer() {
        List<PokemonInfo> pokemons = new ArrayList<>();
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApiService().getPokemonList(0, POKEMONTOQUERY).enqueue(new Callback<PokemonList>() {
            public void onResponse(Call<PokemonList> call, Response<PokemonList> response) {
                if (response.isSuccessful()) {
                    for (int creature = 0; creature < POKEMONTOQUERY; creature++) {
                        PokemonInfo pokemonInfo = new PokemonInfo(creature + 1, response.body().getPokemonInfoList().get(creature).getName().substring(0, 1).toUpperCase() + response.body().getPokemonInfoList().get(creature).getName().substring(1), response.body().getPokemonInfoList().get(creature).getUrl(), Boolean.FALSE);
                        pokemons.add(pokemonInfo);
                    }
                } else {
                    Log.d("POKERROR", "Not able to fill pokemons with the data from getPokemonApiService()");
                }
                pokemonList.postValue(pokemons);
            }

            @Override
            public void onFailure(Call<PokemonList> call, Throwable error) {
                Log.e("POKERROR", error.getLocalizedMessage());
            }
        });
    }
}
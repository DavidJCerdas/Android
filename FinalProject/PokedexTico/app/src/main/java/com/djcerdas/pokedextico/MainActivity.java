package com.djcerdas.pokedextico;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.djcerdas.pokedextico.api.RetrofitProvider;
import com.djcerdas.pokedextico.model.PokemonList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPokemonList();
    }

    private void getPokemonList(){
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApiService().getPokemonList(0,25).enqueue(new Callback<List<PokemonList>>() {
            @Override
            public void onResponse(Call<List<PokemonList>> call, Response<List<PokemonList>> response) {
                if(response.isSuccessful()){
                    Log.d("POKEMON:", response.body().get(0).getName()+"");
                }else{
                    Log.e("SERVER_ERROR", "getPokemonApiService() response was not successful.");
                }
            }

            @Override
            public void onFailure(Call<List<PokemonList>> call, Throwable error) {
                Log.e("SERVER_ERROR", "getPokemonApiService() response was not successful.");
            }
        });
    }
    }



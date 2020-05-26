package com.djcerdas.pokedextico;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.djcerdas.pokedextico.api.RetrofitGetOne;
import com.djcerdas.pokedextico.api.RetrofitProvider;
import com.djcerdas.pokedextico.model.Pokemon;

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

    // Get pokemon list
    private void getPokemonList(){
        RetrofitProvider retrofitProvider = new RetrofitProvider();
        retrofitProvider.getPokemonApiService().getPokemon(0,25).enqueue(new Callback<List<Pokemon>>() {
            @Override
            public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
                if(response.isSuccessful()){
                    Log.d("POKEMON:", "response.message()");
                }else{
                    Log.e("SERVER_ERROR", "getPokemonApiService() response was not successful.");
                }
            }

            @Override
            public void onFailure(Call<List<Pokemon>> call, Throwable error) {
                Log.e("SERVER_ERROR", error.getLocalizedMessage());
            }
        });
    }
    // Get a single Pokemon
    private void getOnPokemon(){
        RetrofitGetOne retrofitgetone = new RetrofitGetOne();
        retrofitgetone.getPokemonApiGetOne().getPokemon("bulbasaur");
    }

}

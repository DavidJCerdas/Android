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
        this.getPokemonList();
    }

    private void getPokemonList(){

    }
    }



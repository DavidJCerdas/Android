package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.djcerdas.pokedextico.databinding.MenuPokedexBinding;

public class MenuPokedex extends Fragment {
    private MenuPokedexBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
    }

    private void setContentView(View view) {
    }

}

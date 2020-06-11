package com.djcerdas.pokedextico.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.djcerdas.pokedextico.fragment.NullDisplayFragment;
import com.djcerdas.pokedextico.fragment.PokemonTrainerInfo;
import com.djcerdas.pokedextico.fragment.RecycleViewFragment;

public class PokemonViewPage2Adapter extends FragmentStateAdapter {

    public PokemonViewPage2Adapter(@NonNull Fragment fragment) {
        super(fragment);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment showFragment;
        if (position == 0) {
            showFragment = new RecycleViewFragment();
        } else if (position == 1) {
            showFragment = new NullDisplayFragment();
        } else if (position == 2) {
            showFragment = new PokemonTrainerInfo();
        } else {
            showFragment = new NullDisplayFragment();
        }
        return showFragment;
    }

    @Override
    public int getItemCount() {
        return 3;
    }

}

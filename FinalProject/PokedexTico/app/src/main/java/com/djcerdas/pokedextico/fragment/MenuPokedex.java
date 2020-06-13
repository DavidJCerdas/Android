package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.djcerdas.pokedextico.R;
import com.djcerdas.pokedextico.adapter.PokemonViewPage2Adapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuPokedex extends Fragment {

    private ArrayList<String> tabName = new ArrayList<>();

    PokemonViewPage2Adapter pokemonViewPage2Adapter;

    @BindView(R.id.tabLayoutMenuPokedex)
    TabLayout tabLayoutMenuPokedex;

    @BindView(R.id.pagerMenuPokedex)
    ViewPager2 viewPager2MenuPokedex;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.menu_pokedex, container, false);
        ButterKnife.bind(this, view);
        pokemonViewPage2Adapter = new PokemonViewPage2Adapter(this);
        viewPager2MenuPokedex.setAdapter(pokemonViewPage2Adapter);

        List<String> tittle = getTitles();

        new TabLayoutMediator(tabLayoutMenuPokedex, viewPager2MenuPokedex, ((tab, position) -> tab.setText(tittle.get(position)))).attach();

        // Get the trainer name from the login fragment
        String trainerName = MenuPokedexArgs.fromBundle(getArguments()).getTrainerName();

        return view;
    }

    private List<String> getTitles() {
        List<String> tittle = new ArrayList<>();
        tittle.add("Pokemons");
        tittle.add("Favorites");
        tittle.add("Trainer Info");
        return tittle;
    }

}

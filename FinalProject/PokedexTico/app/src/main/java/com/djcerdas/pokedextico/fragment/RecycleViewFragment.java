package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.djcerdas.pokedextico.Listener.OnPokemonClicked;
import com.djcerdas.pokedextico.R;
import com.djcerdas.pokedextico.adapter.PokemonAdapter;
import com.djcerdas.pokedextico.model.PokemonInfo;
import com.djcerdas.pokedextico.model.PokemonList;
import com.djcerdas.pokedextico.viewmodel.AllTapViewModel;

import java.util.List;


public class RecycleViewFragment extends Fragment implements OnPokemonClicked {
    private RecyclerView recyclerView;
    private PokemonAdapter pokemonAdapter = new PokemonAdapter(this::onClicked);
    private TextView pokemonName;
    private AllTapViewModel viewModel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewModel = new ViewModelProvider(this).get(AllTapViewModel.class);
    }

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
        pokemonName = view.findViewById(R.id.pokemon_name);
        viewModel.getpokemonListFromServer();
        viewModel.getPokemonList().observe(this.getViewLifecycleOwner(), new Observer() {
            @Override
            public void onChanged(Object o) {
                pokemonAdapter.setPokemonInfoList((List<PokemonInfo>) o);
            }
        });
        initRecyclerView();
    }

    private void initRecyclerView() {
        recyclerView.setAdapter(pokemonAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
    }

//    @Override
//    public void onResume() {
//        super.onResume();
//
//    }

    @Override
    public void onClicked(PokemonInfo pokemonInfo) {
        Integer pokemonID = pokemonInfo.getPokemonID();
        String pokemonName = pokemonInfo.getName();
        NavDirections action = RecycleViewFragmentDirections.recycleViewToShowPokemonFragment(pokemonName, pokemonID);
        NavHostFragment.findNavController(RecycleViewFragment.this).navigate(action);

    }
}

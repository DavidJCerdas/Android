package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.djcerdas.pokedextico.R;

public class MenuPokedex extends Fragment {
    private TextView print_var;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.menu_pokedex,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        print_var = view.findViewById(R.id.print_var);

        // Make the calculation of the weight on the Moon
       String trainerName = MenuPokedexArgs.fromBundle(getArguments()).getTrainerName();
       print_var.setText(trainerName);
        }
}

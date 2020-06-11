package com.djcerdas.pokedextico.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.fragment.NavHostFragment;
import com.djcerdas.pokedextico.R;
import com.google.android.material.textfield.TextInputEditText;


public class LoginFragment extends Fragment {

    private Button loginButton;
    private TextInputEditText trainerNameData;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_user, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        loginButton = view.findViewById(R.id.loginButton);
        trainerNameData = view.findViewById(R.id.DisplaytrainerName);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action;
                action = LoginFragmentDirections.loginToMenuPokedex();
                NavHostFragment.findNavController(LoginFragment.this).navigate(action);
                ;
            }
        });
    }
}


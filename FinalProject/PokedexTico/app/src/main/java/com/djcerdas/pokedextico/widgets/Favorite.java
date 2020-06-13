package com.djcerdas.pokedextico.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.djcerdas.pokedextico.R;


public class Favorite extends ConstraintLayout {
    public Favorite(Context context) {
        super(context);
        init(context, null, 0, 0);
    }

    public Favorite(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0, 0);
    }

    public Favorite(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr, 0);
    }

    // To inflate the View
    public void init(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        View view = LayoutInflater.from(context).inflate(R.layout.fragment_favorite, this, true);
        TextView pokemonNameView = view.findViewById(R.id.pokemon_name);
        ImageView favoriteView = view.findViewById(R.id.is_favorite);


        if (attrs != null) {
            TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Favorite, defStyleAttr, defStyleRes);
            String pokemonName = typedArray.getString(R.styleable.Favorite_pokemon_name);
            pokemonNameView.setText(pokemonName);
            favoriteView.setBackground(typedArray.getDrawable(R.styleable.Favorite_favorite));

            typedArray.recycle();
        }
    }
}

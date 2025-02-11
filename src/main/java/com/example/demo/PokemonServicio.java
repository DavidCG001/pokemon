package com.example.demo;

import java.util.List;

public interface PokemonServicio {

    public List<Pokemon> listarPokemon();

    public Pokemon guardarPokemon(Pokemon pokemon);

    public Pokemon obtenerPokemon(Integer id);

    public Pokemon actualizarPokemon(Pokemon pokemon);

    public void borrarPokemon(Integer id);

    // Nuevo método para obtener Pokémon de un entrenador
    public List<Pokemon> listarPokemonPorEntrenador(Integer entrenadorId);
}

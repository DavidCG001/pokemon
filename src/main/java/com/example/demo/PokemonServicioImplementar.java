package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonServicioImplementar implements PokemonServicio {

    @Autowired
    private PokemonRepository repositorio;

    @Override
    public List<Pokemon> listarPokemon() {
        return repositorio.findAll();
    }

    @Override
    public Pokemon guardarPokemon(Pokemon pokemon) {
        return repositorio.save(pokemon);
    }

    @Override
    public Pokemon obtenerPokemon(Integer id) {
        return repositorio.findById(id).orElse(null);
    }

    @Override
    public Pokemon actualizarPokemon(Pokemon pokemon) {
        return repositorio.save(pokemon);
    }

    @Override
    public void borrarPokemon(Integer id) {
        repositorio.deleteById(id);
    }

    // Nuevo método para obtener Pokémon por entrenador
    @Override
    public List<Pokemon> listarPokemonPorEntrenador(Integer entrenadorId) {
        return repositorio.findByEntrenadorId(entrenadorId);
    }
}



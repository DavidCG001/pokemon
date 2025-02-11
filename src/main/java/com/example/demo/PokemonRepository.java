package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

    // Método para encontrar los Pokémon de un entrenador específico
    List<Pokemon> findByEntrenadorId(Integer entrenadorId);
}

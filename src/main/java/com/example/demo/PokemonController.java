package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class PokemonController {

    @Autowired
    private PokemonServicio servicio;

    @Autowired
    private EntrenadorServicio entrenadorServicio; // Necesitas el servicio de Entrenador

    // Mostrar la lista de Pokémon
    @GetMapping({ "/pokemones", "/" })
    public String listarPokemones(Model modelo) {
        modelo.addAttribute("pokemones", servicio.listarPokemon());
        return "pokemon"; // pokemon.html
    }

    // Mostrar el formulario para crear un nuevo Pokémon
    @GetMapping("/pokemones/crear")
    public String formulario(Model modelo) {
        modelo.addAttribute("pokemon", new Pokemon());
        modelo.addAttribute("entrenadores", entrenadorServicio.listarEntrenadores()); // Para mostrar los entrenadores disponibles
        return "crear"; // crear.html
    }

    // Guardar un nuevo Pokémon
    @PostMapping("/pokemones")
    public String guardarPokemon(@Valid @ModelAttribute("pokemon") Pokemon pokemon, BindingResult result) {
        if (result.hasErrors()) {
            return "crear"; // Si hay errores, vuelve al formulario de creación
        }
        servicio.guardarPokemon(pokemon);
        return "redirect:/pokemones"; // Redirige a la lista de Pokémon
    }

    // Mostrar el formulario para editar un Pokémon existente
    @GetMapping("/pokemones/editar/{id}")
    public String formularioEditar(@PathVariable Integer id, Model modelo) {
        Pokemon pokemon = servicio.obtenerPokemon(id);
        modelo.addAttribute("pokemon", pokemon);
        modelo.addAttribute("entrenadores", entrenadorServicio.listarEntrenadores()); // Para mostrar los entrenadores disponibles en la edición
        return "editar"; // editar.html
    }

    // Actualizar un Pokémon existente
    @PostMapping("/pokemones/{id}")
    public String actualizar(@PathVariable Integer id, @Valid @ModelAttribute("pokemon") Pokemon pokemon,
                             BindingResult result) {
        if (result.hasErrors()) {
            return "editar"; // Si hay errores, vuelve al formulario de edición
        }
        // Actualización más simple sin necesidad de setear manualmente cada campo
        Pokemon actualizarPokemon = servicio.obtenerPokemon(id);
        actualizarPokemon.setNombre(pokemon.getNombre());
        actualizarPokemon.setTipo(pokemon.getTipo());
        actualizarPokemon.setNivel(pokemon.getNivel());
        actualizarPokemon.setHabilidad(pokemon.getHabilidad());
        actualizarPokemon.setEntrenador(pokemon.getEntrenador()); // Relacionamos al entrenador actualizado
        servicio.actualizarPokemon(actualizarPokemon);
        return "redirect:/pokemones"; // Redirige a la lista de Pokémon
    }

    // Eliminar un Pokémon
    @GetMapping("/pokemones/{id}")
    public String eliminar(@PathVariable Integer id) {
        servicio.borrarPokemon(id);
        return "redirect:/pokemones"; // Redirige a la lista después de eliminar
    }

    // Mostrar los detalles de un Pokémon
    @GetMapping("/pokemones/detalles/{id}")
    public String findById(Model model, @PathVariable Integer id) {
        model.addAttribute("pokemon", servicio.obtenerPokemon(id));
        return "detalles"; // detalles.html
    }

    // Mostrar los Pokémon de un entrenador específico
    @GetMapping("/entrenadores/{id}/pokemones")
    public String listarPokemonesPorEntrenador(@PathVariable Integer id, Model modelo) {
        // Obtener el entrenador por su id
        Entrenador entrenador = entrenadorServicio.obtenerEntrenador(id);

        // Obtener la lista de Pokémon asociados al entrenador
        modelo.addAttribute("entrenador", entrenador);
        modelo.addAttribute("pokemones", servicio.listarPokemonPorEntrenador(id)); // Método para obtener los Pokémon del entrenador

        return "pokemonesPorEntrenador"; // pokemonesPorEntrenador.html
    }

}

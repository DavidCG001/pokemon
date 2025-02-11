package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Controller
public class EntrenadorController {

    @Autowired
    private EntrenadorServicio servicio;

    // Listar todos los entrenadores
    @GetMapping("/entrenadores")
    public String listarEntrenadores(Model modelo) {
        modelo.addAttribute("entrenadores", servicio.listarEntrenadores());
        return "entrenadores"; // entrenadores.html
    }

    // Crear un nuevo entrenador
    @GetMapping("/entrenadores/crear")
    public String formularioCrear(Model modelo) {
        modelo.addAttribute("entrenador", new Entrenador());
        return "crearEntrenador"; // crearEntrenador.html
    }

    // Guardar un nuevo entrenador
    @PostMapping("/entrenadores")
    public String guardarEntrenador(@Valid @ModelAttribute("entrenador") Entrenador entrenador, BindingResult result) {
        if (result.hasErrors()) {
            return "crearEntrenador"; // Si hay errores, vuelve al formulario de creación
        }
        servicio.guardarEntrenador(entrenador);
        return "redirect:/entrenadores"; // Redirige a la lista de entrenadores
    }

    // Editar un entrenador existente
    @GetMapping("/entrenadores/editar/{id}")
    public String formularioEditar(@PathVariable Integer id, Model modelo) {
        modelo.addAttribute("entrenador", servicio.obtenerEntrenador(id));
        return "editarEntrenador"; // editarEntrenador.html
    }

    // Actualizar un entrenador existente
    @PostMapping("/entrenadores/{id}")
    public String actualizarEntrenador(@PathVariable Integer id, @Valid @ModelAttribute("entrenador") Entrenador entrenador, BindingResult result) {
        if (result.hasErrors()) {
            return "editarEntrenador"; // Si hay errores, vuelve al formulario de edición
        }
        entrenador.setId(id);
        servicio.actualizarEntrenador(entrenador);
        return "redirect:/entrenadores"; // Redirige a la lista de entrenadores
    }

    // Eliminar un entrenador
    @GetMapping("/entrenadores/{id}")
    public String eliminarEntrenador(@PathVariable Integer id) {
        servicio.borrarEntrenador(id);
        return "redirect:/entrenadores"; // Redirige a la lista de entrenadores
    }
}

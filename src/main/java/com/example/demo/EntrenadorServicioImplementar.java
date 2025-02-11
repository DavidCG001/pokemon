package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntrenadorServicioImplementar implements EntrenadorServicio {

    @Autowired
    private EntrenadorRepository repositorio; // Inyección del repositorio de Entrenador

    // Listar todos los entrenadores
    @Override
    public List<Entrenador> listarEntrenadores() {
        return repositorio.findAll(); // Devuelve todos los entrenadores
    }

    // Guardar un nuevo entrenador
    @Override
    public Entrenador guardarEntrenador(Entrenador entrenador) {
        return repositorio.save(entrenador); // Guarda el entrenador en la base de datos
    }

    // Obtener un entrenador por ID
    @Override
    public Entrenador obtenerEntrenador(Integer id) {
        return repositorio.findById(id).orElse(null); // Retorna el entrenador por su ID o null si no existe
    }

    // Actualizar un entrenador existente
    @Override
    public Entrenador actualizarEntrenador(Entrenador entrenador) {
        return repositorio.save(entrenador); // Guarda el entrenador actualizado
    }

    // Eliminar un entrenador por ID
    @Override
    public void borrarEntrenador(Integer id) {
        repositorio.deleteById(id); // Elimina el entrenador por su ID
    }
}

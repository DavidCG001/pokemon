package com.example.demo;

import java.util.List;

public interface EntrenadorServicio {

    List<Entrenador> listarEntrenadores(); // Listar todos los entrenadores

    Entrenador guardarEntrenador(Entrenador entrenador); // Guardar un nuevo entrenador

    Entrenador obtenerEntrenador(Integer id); // Obtener un entrenador por su ID

    Entrenador actualizarEntrenador(Entrenador entrenador); // Actualizar un entrenador existente

    void borrarEntrenador(Integer id); // Eliminar un entrenador por su ID
}

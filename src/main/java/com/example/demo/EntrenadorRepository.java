package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EntrenadorRepository extends JpaRepository<Entrenador, Integer> {
    // JpaRepository ya provee métodos CRUD como save(), findAll(), findById(), deleteById(), etc.
}
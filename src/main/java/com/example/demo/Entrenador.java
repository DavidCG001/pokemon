package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "entrenador")
public class Entrenador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @Column(name = "nombre", nullable = false)
    private String nombre;

    // Constructor sin argumentos
    public Entrenador() {
    }

    // Constructor con todos los argumentos
    public Entrenador(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    // Getter para el id
    public Integer getId() {
        return id;
    }

    // Setter para el id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    // Setter para el nombre
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Método toString
    @Override
    public String toString() {
        return "Entrenador{id=" + id + ", nombre='" + nombre + "'}";
    }
}

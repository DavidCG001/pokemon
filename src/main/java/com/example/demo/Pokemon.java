package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "pokemon")
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Min(value = 1, message = "El nivel debe ser al menos 1")
    @Column(name = "nivel")
    private int nivel;

    @Column(name = "habilidad")
    private String habilidad;

    // Relación ManyToOne con la clase Entrenador
    @ManyToOne
    @JoinColumn(name = "entrenador_id", nullable = false)  // Esto crea una columna 'entrenador_id' en la tabla Pokemon
    private Entrenador entrenador;

    // Constructor vacío
    public Pokemon() {
    }

    // Constructor con parámetros
    public Pokemon(Integer id, String nombre, String tipo, int nivel, String habilidad, Entrenador entrenador) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.habilidad = habilidad;
        this.entrenador = entrenador;
    }

    // Constructor sin id, ya que normalmente lo generamos automáticamente
    public Pokemon(String nombre, String tipo, int nivel, String habilidad, Entrenador entrenador) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.nivel = nivel;
        this.habilidad = habilidad;
        this.entrenador = entrenador;
    }

    // Getters y Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getHabilidad() {
        return habilidad;
    }

    public void setHabilidad(String habilidad) {
        this.habilidad = habilidad;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Pokemon [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", nivel=" + nivel + ", habilidad=" + habilidad + ", entrenador=" + entrenador.getNombre() + "]";
    }

//    spring.datasource.url=jdbc:mysql://localhost:3306/pokemon_db


}

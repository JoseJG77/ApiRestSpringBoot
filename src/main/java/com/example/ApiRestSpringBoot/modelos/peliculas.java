package com.example.ApiRestSpringBoot.modelos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String pelicula;
    String director;
    String genero;

    public peliculas() {
    }

    public peliculas(String pelicula, String director, String genero) {
        this.id = id;
        this.pelicula = pelicula;
        this.director = director;
        this.genero = genero;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPelicula() {
        return pelicula;
    }

    public void setPelicula(String pelicula) {
        this.pelicula = pelicula;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}

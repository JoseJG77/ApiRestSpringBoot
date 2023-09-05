package com.example.ApiRestSpringBoot.repositorios;

import com.example.ApiRestSpringBoot.modelos.peliculas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PeliculasRepositorio extends JpaRepository<peliculas, Long> {
}

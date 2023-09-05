package com.example.ApiRestSpringBoot.controladores;
import org.springframework.http.MediaType;
import com.example.ApiRestSpringBoot.modelos.peliculas;
import com.example.ApiRestSpringBoot.repositorios.PeliculasRepositorio;
import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:5500")
public class PeliculaController {

    PeliculasRepositorio repositorio = null;

    public PeliculaController(PeliculasRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    @GetMapping("/api/peliculas")
    public List<peliculas> obtenerPeliculas(){

       return repositorio.findAll();

    }

    @GetMapping("/api/peliculas/{id}")
    public ResponseEntity<Object> obtenerPeliculaPorId(@PathVariable Long id){

        Optional<peliculas> opt = repositorio.findById(id);
        if(opt.isEmpty()){
           return ResponseEntity.badRequest().build();
        }
        else {
            return ResponseEntity.ok(opt.get());
        }

    }
    @CrossOrigin("http://127.0.0.1:5500")
    @PostMapping("/api/guardar")
    public ResponseEntity<peliculas> guardarPelicula(@RequestBody peliculas pelicula) {
        if (pelicula.getId() != null){
            return ResponseEntity.badRequest().build();
        }

        repositorio.save(pelicula);
        return ResponseEntity.ok(pelicula);

    }

    @CrossOrigin("http://127.0.0.1:5500")
    @PutMapping("/api/actualizar")
    public ResponseEntity<peliculas> actualizarPelicula(@RequestBody peliculas pelicula) {
        if (pelicula.getId() == null || repositorio.existsById(pelicula.getId())){
            return ResponseEntity.badRequest().build();
        }

        repositorio.save(pelicula);
        return ResponseEntity.ok(pelicula);

    }



    @DeleteMapping("/api/borrar/{id}")
    public ResponseEntity<peliculas> borrarPelicula(@PathVariable Long id) {
        if (id == null || repositorio.existsById(id)) {
            return ResponseEntity.badRequest().build();
        }

        repositorio.deleteById(id);
        return ResponseEntity.noContent().build();

    }
}

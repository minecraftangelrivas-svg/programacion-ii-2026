package com.estudiante.semana13bibliotecaapi.controller;

import com.estudiante.semana13bibliotecaapi.Entity.Libro;
import com.estudiante.semana13bibliotecaapi.repository.LibroRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
@CrossOrigin(origins = "*")
public class LibroController {

    private final LibroRepository libroRepository;


    public LibroController(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @GetMapping
    public ResponseEntity<List<Libro>> obtenerTodos() {
        List<Libro> libros = libroRepository.findAll();
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> obtenerPorId(@PathVariable Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        if (libro.isPresent()) {
            return ResponseEntity.ok(libro.get());
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }

    @PostMapping
    public ResponseEntity<Libro> crearLibro(@RequestBody Libro libro) {
        Libro nuevoLibro = libroRepository.save(libro);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoLibro); // 201 Created
    }

    @PutMapping("/{id}")
    public ResponseEntity<Libro> actualizarLibro(@PathVariable Long id, @RequestBody Libro libroActualizado) {
        if (!libroRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // 404 Not Found si no existe
        }
        libroActualizado.setId(id); // Asegura que se actualice el ID correcto
        Libro libroGuardado = libroRepository.save(libroActualizado);
        return ResponseEntity.ok(libroGuardado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLibro(@PathVariable Long id) {
        if (!libroRepository.existsById(id)) {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
        libroRepository.deleteById(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    @GetMapping("/categoria/{categoria}")
    public ResponseEntity<List<Libro>> obtenerPorCategoria(@PathVariable String categoria) {
        List<Libro> libros = libroRepository.findByCategoria(categoria);
        return ResponseEntity.ok(libros);
    }

    @GetMapping("/disponibles")
    public ResponseEntity<List<Libro>> obtenerDisponibles() {
        List<Libro> libros = libroRepository.findByDisponibleTrue();
        return ResponseEntity.ok(libros);
    }
}
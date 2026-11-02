package com.estudiante.reservasdeareascomnes.controller;

import com.estudiante.reservasdeareascomnes.DTO.ReservaRespuestaDTO;
import com.estudiante.reservasdeareascomnes.DTO.ReservaSolicitudDTO;
import com.estudiante.reservasdeareascomnes.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @PostMapping
    public ResponseEntity<ReservaRespuestaDTO> crearReserva(@Valid @RequestBody ReservaSolicitudDTO dto) {
        return new ResponseEntity<>(reservaService.crearReserva(dto), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ReservaRespuestaDTO>> obtenerTodas() {
        return ResponseEntity.ok(reservaService.obtenerTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReservaRespuestaDTO> obtenerPorId(@PathVariable Long id) {
        return ResponseEntity.ok(reservaService.obtenerPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReservaRespuestaDTO> actualizar(@PathVariable Long id, @Valid @RequestBody ReservaSolicitudDTO dto) {
        return ResponseEntity.ok(reservaService.actualizarReserva(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelar(@PathVariable Long id) {
        reservaService.cancelarReserva(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/buscar-por-fecha")
    public ResponseEntity<List<ReservaRespuestaDTO>> buscarPorFecha(
            @RequestParam("fecha") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate fecha) {
        return ResponseEntity.ok(reservaService.buscarPorFecha(fecha));
    }

    @GetMapping("/buscar-por-residente")
    public ResponseEntity<List<ReservaRespuestaDTO>> buscarPorResidente(@RequestParam("nombre") String nombre) {
        return ResponseEntity.ok(reservaService.buscarPorResidente(nombre));
    }
}
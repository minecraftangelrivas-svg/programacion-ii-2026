package com.estudiante.reservasdeareascomnes.service;

import com.estudiante.reservasdeareascomnes.DTO.ReservaRespuestaDTO;
import com.estudiante.reservasdeareascomnes.DTO.ReservaSolicitudDTO;
import jakarta.validation.Valid;


import java.time.LocalDate;
import java.util.List;

public interface ReservaService {

    ReservaRespuestaDTO crearReserva(ReservaSolicitudDTO solicitudDTO);

    List<ReservaRespuestaDTO> obtenerTodas();

    ReservaRespuestaDTO obtenerPorId(Long id);

    List<ReservaRespuestaDTO> buscarPorFecha(LocalDate fecha);

    List<ReservaRespuestaDTO> buscarPorResidente(String nombre);

    ReservaRespuestaDTO actualizarReserva(Long id, ReservaSolicitudDTO solicitudDTO);

    void cancelarReserva(Long id);
}
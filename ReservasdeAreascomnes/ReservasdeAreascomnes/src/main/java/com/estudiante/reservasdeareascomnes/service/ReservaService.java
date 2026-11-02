package com.estudiante.reservasdeareascomnes.service;

import com.estudiante.reservasdeareascomnes.DTO.ReservaRespuestaDTO;
import com.estudiante.reservasdeareascomnes.DTO.ReservaSolicitudDTO;


import java.time.LocalDate;
import java.util.List;

public interface ReservaService {
    ReservaRespuestaDTO crearReserva(ReservaSolicitudDTO requestDTO);
    List<ReservaRespuestaDTO> obtenerTodas();
    ReservaRespuestaDTO obtenerPorId(Long id);
    ReservaRespuestaDTO actualizarReserva(Long id, ReservaSolicitudDTO requestDTO);
    void cancelarReserva(Long id);
    List<ReservaRespuestaDTO> buscarPorFecha(LocalDate fecha);
    List<ReservaRespuestaDTO> buscarPorResidente(String residenteNombre);
}
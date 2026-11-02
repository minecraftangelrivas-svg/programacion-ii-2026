package com.estudiante.reservasdeareascomnes.service.impl;

import com.estudiante.reservasdeareascomnes.DTO.ReservaRespuestaDTO;
import com.estudiante.reservasdeareascomnes.DTO.ReservaSolicitudDTO;
import com.estudiante.reservasdeareascomnes.Entity.AreaComun;
import com.estudiante.reservasdeareascomnes.Entity.Reserva;
import com.estudiante.reservasdeareascomnes.exception.ReglaExcepcion;
import com.estudiante.reservasdeareascomnes.exception.noEncontrada;
import com.estudiante.reservasdeareascomnes.repository.AreaComunRepository;
import com.estudiante.reservasdeareascomnes.repository.ReservaRepository;
import com.estudiante.reservasdeareascomnes.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    @Autowired
    private ReservaRepository reservaRepository;

    @Autowired
    private AreaComunRepository areaComunRepository;

    @Override
    public ReservaRespuestaDTO crearReserva(ReservaSolicitudDTO dto) {
        if (!dto.getHoraFin().isAfter(dto.getHoraInicio())) {
            throw new ReglaExcepcion("La hora de fin debe ser posterior a la hora de inicio.");
        }

        AreaComun area = areaComunRepository.findById(dto.getAreaId())
                .orElseThrow(() -> new noEncontrada("El área común solicitada no existe."));

        Reserva reserva = new Reserva();
        reserva.setArea(area);
        reserva.setResidenteNombre(dto.getResidenteNombre());
        reserva.setResidenteApartamento(dto.getResidenteApartamento());
        reserva.setFecha(dto.getFecha());
        reserva.setHoraInicio(dto.getHoraInicio());
        reserva.setHoraFin(dto.getHoraFin());
        reserva.setCantidadAsistentes(dto.getCantidadAsistentes());
        reserva.setEstado("CONFIRMADA");

        return mapearADTO(reservaRepository.save(reserva));
    }

    @Override
    public List<ReservaRespuestaDTO> obtenerTodas() {
        return reservaRepository.findAll().stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReservaRespuestaDTO obtenerPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new noEncontrada("Reserva con ID " + id + " no encontrada."));
        return mapearADTO(reserva);
    }

    @Override
    public ReservaRespuestaDTO actualizarReserva(Long id, ReservaSolicitudDTO dto) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new noEncontrada("Reserva no encontrada."));

        AreaComun area = areaComunRepository.findById(dto.getAreaId())
                .orElseThrow(() -> new noEncontrada("Área común no encontrada."));

        reserva.setArea(area);
        reserva.setResidenteNombre(dto.getResidenteNombre());
        reserva.setResidenteApartamento(dto.getResidenteApartamento());
        reserva.setFecha(dto.getFecha());
        reserva.setHoraInicio(dto.getHoraInicio());
        reserva.setHoraFin(dto.getHoraFin());
        reserva.setCantidadAsistentes(dto.getCantidadAsistentes());

        return mapearADTO(reservaRepository.save(reserva));
    }

    @Override
    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new noEncontrada("Reserva no encontrada."));
        reserva.setEstado("CANCELADA");
        reservaRepository.save(reserva);
    }

    @Override
    public List<ReservaRespuestaDTO> buscarPorFecha(LocalDate fecha) {
        return reservaRepository.findByFecha(fecha).stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReservaRespuestaDTO> buscarPorResidente(String residenteNombre) {
        return reservaRepository.findByResidenteNombreContainingIgnoreCase(residenteNombre).stream()
                .map(this::mapearADTO)
                .collect(Collectors.toList());
    }

    private ReservaRespuestaDTO mapearADTO(Reserva reserva) {
        ReservaRespuestaDTO dto = new ReservaRespuestaDTO();
        dto.setId(reserva.getId());
        dto.setAreaId(reserva.getArea().getId());
        dto.setAreaNombre(reserva.getArea().getNombre());
        dto.setResidenteNombre(reserva.getResidenteNombre());
        dto.setResidenteApartamento(reserva.getResidenteApartamento());
        dto.setFecha(reserva.getFecha());
        dto.setHoraInicio(reserva.getHoraInicio());
        dto.setHoraFin(reserva.getHoraFin());
        dto.setCantidadAsistentes(reserva.getCantidadAsistentes());
        dto.setEstado(reserva.getEstado());
        return dto;
    }
}
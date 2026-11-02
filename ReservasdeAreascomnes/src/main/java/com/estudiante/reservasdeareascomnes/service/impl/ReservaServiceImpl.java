package com.estudiante.reservasdeareascomnes.service.impl;
import com.estudiante.reservasdeareascomnes.service.ReservaService;
import com.estudiante.reservasdeareascomnes.DTO.ReservaRespuestaDTO;
import com.estudiante.reservasdeareascomnes.DTO.ReservaSolicitudDTO;
import com.estudiante.reservasdeareascomnes.Entity.AreaComun;
import com.estudiante.reservasdeareascomnes.Entity.Reserva;
import com.estudiante.reservasdeareascomnes.exception.ReglaExcepcion;
import com.estudiante.reservasdeareascomnes.exception.noEncontrada;
import com.estudiante.reservasdeareascomnes.repository.AreaComunRepository;
import com.estudiante.reservasdeareascomnes.repository.ReservaRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservaServiceImpl implements ReservaService {

    private final ReservaRepository reservaRepository;
    private final AreaComunRepository areaComunRepository;

    @Autowired
    public ReservaServiceImpl(ReservaRepository reservaRepository, AreaComunRepository areaComunRepository) {
        this.reservaRepository = reservaRepository;
        this.areaComunRepository = areaComunRepository;
    }

    @Override
    @Transactional
    public ReservaRespuestaDTO crearReserva(ReservaSolicitudDTO solicitudDTO) {
        if (!solicitudDTO.getHoraFin().isAfter(solicitudDTO.getHoraInicio())) {
            throw new ReglaExcepcion("La hora de fin debe ser posterior a la hora de inicio.");
        }

        AreaComun area = areaComunRepository.findById(solicitudDTO.getAreaId())
                .orElseThrow(() -> new noEncontrada("El área común solicitada no existe."));

        if (solicitudDTO.getCantidadAsistentes() > area.getCapacidad()) {
            throw new ReglaExcepcion("La cantidad de asistentes supera la capacidad del área.");
        }

        boolean hayTraslape = reservaRepository.existeTraslapeHorario(
                solicitudDTO.getAreaId(),
                solicitudDTO.getFecha(),
                solicitudDTO.getHoraInicio(),
                solicitudDTO.getHoraFin()
        );

        if (hayTraslape) {
            throw new ReglaExcepcion("El área común ya cuenta con una reserva confirmada en ese rango de horario.");
        }

        Reserva nuevaReserva = new Reserva();
        nuevaReserva.setResidenteNombre(solicitudDTO.getResidenteNombre());
        nuevaReserva.setResidenteApartamento(solicitudDTO.getResidenteApartamento());
        nuevaReserva.setFecha(solicitudDTO.getFecha());
        nuevaReserva.setHoraInicio(solicitudDTO.getHoraInicio());
        nuevaReserva.setHoraFin(solicitudDTO.getHoraFin());
        nuevaReserva.setCantidadAsistentes(solicitudDTO.getCantidadAsistentes());
        nuevaReserva.setEstado("CONFIRMADA");
        nuevaReserva.setArea(area);

        Reserva guardada = reservaRepository.save(nuevaReserva);
        return mapearEntidadARespuesta(guardada);
    }

    @Override
    @Transactional
    public ReservaRespuestaDTO actualizarReserva(Long id, ReservaSolicitudDTO solicitudDTO) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new noEncontrada("Reserva con ID " + id + " no encontrada."));

        AreaComun area = areaComunRepository.findById(solicitudDTO.getAreaId())
                .orElseThrow(() -> new noEncontrada("El área común solicitada no existe."));

        if (!solicitudDTO.getHoraFin().isAfter(solicitudDTO.getHoraInicio())) {
            throw new ReglaExcepcion("La hora de fin debe ser posterior a la hora de inicio.");
        }

        if (solicitudDTO.getCantidadAsistentes() > area.getCapacidad()) {
            throw new ReglaExcepcion("La cantidad de asistentes supera la capacidad del área.");
        }

        reserva.setArea(area);
        reserva.setResidenteNombre(solicitudDTO.getResidenteNombre());
        reserva.setResidenteApartamento(solicitudDTO.getResidenteApartamento());
        reserva.setFecha(solicitudDTO.getFecha());
        reserva.setHoraInicio(solicitudDTO.getHoraInicio());
        reserva.setHoraFin(solicitudDTO.getHoraFin());
        reserva.setCantidadAsistentes(solicitudDTO.getCantidadAsistentes());

        Reserva guardada = reservaRepository.save(reserva);
        return mapearEntidadARespuesta(guardada);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaRespuestaDTO> obtenerTodas() {
        return reservaRepository.findAll().stream()
                .map(this::mapearEntidadARespuesta)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ReservaRespuestaDTO obtenerPorId(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new noEncontrada("Reserva con ID " + id + " no encontrada."));
        return mapearEntidadARespuesta(reserva);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaRespuestaDTO> buscarPorFecha(LocalDate fecha) {
        return reservaRepository.findByFecha(fecha).stream()
                .map(this::mapearEntidadARespuesta)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<ReservaRespuestaDTO> buscarPorResidente(String nombre) {
        return reservaRepository.findByResidenteNombreContainingIgnoreCase(nombre).stream()
                .map(this::mapearEntidadARespuesta)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void cancelarReserva(Long id) {
        Reserva reserva = reservaRepository.findById(id)
                .orElseThrow(() -> new noEncontrada("Reserva con ID " + id + " no encontrada."));
        reserva.setEstado("CANCELADA");
        reservaRepository.save(reserva);
    }

    private ReservaRespuestaDTO mapearEntidadARespuesta(Reserva reserva) {
        ReservaRespuestaDTO dto = new ReservaRespuestaDTO();
        dto.setId(reserva.getId());
        dto.setResidenteNombre(reserva.getResidenteNombre());
        dto.setResidenteApartamento(reserva.getResidenteApartamento());
        dto.setFecha(reserva.getFecha());
        dto.setHoraInicio(reserva.getHoraInicio());
        dto.setHoraFin(reserva.getHoraFin());
        dto.setCantidadAsistentes(reserva.getCantidadAsistentes());
        dto.setEstado(reserva.getEstado());
        if (reserva.getArea() != null) {
            dto.setAreaId(reserva.getArea().getId());
            dto.setAreaNombre(reserva.getArea().getNombre());
        }
        return dto;
    }
}
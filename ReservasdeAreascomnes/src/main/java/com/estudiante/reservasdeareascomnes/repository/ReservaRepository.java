package com.estudiante.reservasdeareascomnes.repository;

import com.estudiante.reservasdeareascomnes.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByFecha(LocalDate fecha);

    List<Reserva> findByResidenteNombreContainingIgnoreCase(String residenteNombre);

    @Query("SELECT COUNT(r) > 0 FROM Reserva r WHERE r.area.id = :areaId " +
            "AND r.fecha = :fecha " +
            "AND r.estado != 'CANCELADA' " +
            "AND (:horaInicio < r.horaFin AND :horaFin > r.horaInicio)")
    boolean existeTraslapeHorario(@Param("areaId") Long areaId,
                                  @Param("fecha") LocalDate fecha,
                                  @Param("horaInicio") LocalTime horaInicio,
                                  @Param("horaFin") LocalTime horaFin);
}
package com.estudiante.reservasdeareascomnes.repository;

import com.estudiante.reservasdeareascomnes.Entity.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    List<Reserva> findByFecha(LocalDate fecha);

    List<Reserva> findByResidenteNombreContainingIgnoreCase(String residenteNombre);
}
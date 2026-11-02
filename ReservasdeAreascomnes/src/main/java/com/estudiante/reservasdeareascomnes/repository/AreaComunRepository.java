package com.estudiante.reservasdeareascomnes.repository;

import com.estudiante.reservasdeareascomnes.Entity.AreaComun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AreaComunRepository extends JpaRepository<AreaComun, Long> {
}
package com.estudiante.reservasdeareascomnes.controller;


import com.estudiante.reservasdeareascomnes.Entity.AreaComun;
import com.estudiante.reservasdeareascomnes.repository.AreaComunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/areas")
public class AreaComunController {

    @Autowired
    private AreaComunRepository areaComunRepository;

    @GetMapping
    public List<AreaComun> listarTodas() {
        return areaComunRepository.findAll();
    }

    @PostMapping
    public AreaComun crearArea(@RequestBody AreaComun area) {
        return areaComunRepository.save(area);
    }
}
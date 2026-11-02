package com.estudiante.reservasdeareascomnes.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaRespuestaDTO {

    private Long id;
    private Long areaId;
    private String areaNombre;
    private String residenteNombre;
    private String residenteApartamento;
    private LocalDate fecha;
    private LocalTime horaInicio;
    private LocalTime horaFin;
    private Integer cantidadAsistentes;
    private String estado;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }

    public String getAreaNombre() { return areaNombre; }
    public void setAreaNombre(String areaNombre) { this.areaNombre = areaNombre; }

    public String getResidenteNombre() { return residenteNombre; }
    public void setResidenteNombre(String residenteNombre) { this.residenteNombre = residenteNombre; }

    public String getResidenteApartamento() { return residenteApartamento; }
    public void setResidenteApartamento(String residenteApartamento) { this.residenteApartamento = residenteApartamento; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public LocalTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalTime getHoraFin() { return horaFin; }
    public void setHoraFin(LocalTime horaFin) { this.horaFin = horaFin; }

    public Integer getCantidadAsistentes() { return cantidadAsistentes; }
    public void setCantidadAsistentes(Integer cantidadAsistentes) { this.cantidadAsistentes = cantidadAsistentes; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }
}
package com.estudiante.reservasdeareascomnes.DTO;

import jakarta.validation.constraints.*;
        import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaSolicitudDTO {

    @NotNull(message = "El ID del área es obligatorio.")
    private Long areaId;

    @NotBlank(message = "El nombre del residente no puede estar vacío.")
    private String residenteNombre;

    @NotBlank(message = "El apartamento del residente es obligatorio.")
    private String residenteApartamento;

    @NotNull(message = "La fecha de la reserva es obligatoria.")
    @FutureOrPresent(message = "La fecha de reserva no puede ser una fecha pasada.")
    private LocalDate fecha;

    @NotNull(message = "La hora de inicio es obligatoria.")
    private LocalTime horaInicio;

    @NotNull(message = "La hora de fin es obligatoria.")
    private LocalTime horaFin;

    @NotNull(message = "La cantidad de asistentes es necesaria.")
    @Min(value = 1, message = "La cantidad de asistentes debe ser al menos 1.")
    private Integer cantidadAsistentes;


    public Long getAreaId() { return areaId; }
    public void setAreaId(Long areaId) { this.areaId = areaId; }

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
}
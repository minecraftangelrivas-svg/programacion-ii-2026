package com.estudiante.reservasdeareascomnes.Entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "reservas")
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id", nullable = false)
    private AreaComun area;

    @Column(name = "residente_nombre", nullable = false, length = 100)
    private String residenteNombre;

    @Column(name = "residente_apartamento", nullable = false, length = 20)
    private String residenteApartamento;

    @Column(nullable = false)
    private LocalDate fecha;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime horaInicio;

    @Column(name = "hora_fin", nullable = false)
    private LocalTime horaFin;

    @Column(name = "cantidad_asistentes", nullable = false)
    private Integer cantidadAsistentes;

    @Column(nullable = false, length = 20)
    private String estado = "CONFIRMADA";


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public AreaComun getArea() { return area; }
    public void setArea(AreaComun area) { this.area = area; }

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
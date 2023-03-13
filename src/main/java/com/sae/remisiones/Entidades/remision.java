package com.sae.remisiones.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "remision")

public class remision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_remision")
    private int id_remision;

    //relacion 1 a 1 con la tabla solicitud_remision
    @OneToOne
    @JoinColumn(name = "id_solicitud_remision")
    private solicitud_remision id_solicitud_remision;

    //relacion 1 a 1 con la tabla primera_escucha
    @OneToOne
    @JoinColumn(name = "id_primera_escucha")
    private primera_escucha id_primera_escucha;

    @Column(name = "fecha_envio_remision")
    private LocalDate fecha_envio_remision;
    
    @Column(name = "remision_efectiva")
    private boolean remision_efectiva;

    public int getId_remision() {
        return id_remision;
    }

    public solicitud_remision getId_solicitud_remision() {
        return id_solicitud_remision;
    }

    public primera_escucha getId_primera_escucha() {
        return id_primera_escucha;
    }

    public LocalDate getFecha_envio_remision() {
        return fecha_envio_remision;
    }

    public Boolean getRemision_efectiva() {
        return remision_efectiva;
    }

    public void setId_remision(int id_remision) {
        this.id_remision = id_remision;
    }

    public void setId_solicitud_remision(solicitud_remision id_solicitud_remision) {
        this.id_solicitud_remision = id_solicitud_remision;
    }

    public void setId_primera_escucha(primera_escucha id_primera_escucha) {
        this.id_primera_escucha = id_primera_escucha;
    }

    public void setFecha_envio_remision(LocalDate fecha_envio_remision) {
        this.fecha_envio_remision = fecha_envio_remision;
    }

    public void setRemision_efectivo(boolean remision_efectiva) {
        this.remision_efectiva = remision_efectiva;
    }
    
}

package com.sae.remisiones.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "primera_escucha")

public class primera_escucha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_primera_escucha")
    private int id_primera_escucha;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_primera_escucha")
    private LocalDate fecha_primera_escucha;
    
    @Column(name = "realizada")
    private boolean realizada;

    public primera_escucha() {
    }

    public primera_escucha(String observacion, boolean realizada) {
        this.observacion = observacion;
        this.fecha_primera_escucha = LocalDate.now();
        this.realizada = realizada;
    }

    public int getId_primera_escucha() {
        return id_primera_escucha;
    }

    public String getObservacion() {
        return observacion;
    }

    public LocalDate getFecha_primera_escucha() {
        return fecha_primera_escucha;
    }

    public Boolean getRealizada() {
        return realizada;
    }

    public void setId_primera_escucha(int id_primera_escucha) {
        this.id_primera_escucha = id_primera_escucha;
    }

    public void setFecha_primera_escucha(LocalDate fecha_primera_escucha) {
        this.fecha_primera_escucha = fecha_primera_escucha;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }
    
}
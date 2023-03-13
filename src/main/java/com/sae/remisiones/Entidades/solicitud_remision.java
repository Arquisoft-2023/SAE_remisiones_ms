package com.sae.remisiones.Entidades;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "solicitud_remision")

public class solicitud_remision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_solicitud_remision")
    private int id_solicitud_remision;

    //relacion muchos a 1 con la tabla tipo_remision
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_remision")
    private tipo_remision id_tipo_remision;

    @Column(name = "usuario_un_estudiante")
    private String usuarion_un_estudiante;

    @Column(name = "usuario_un_docente")
    private String usuarion_un_docente;

    @Column(name = "fecha_solicitud_remision")
    private LocalDate fecha_solicitud_remision;

    @Column(name = "justificacion")
    private String justificacion;
    
    @Column(name = "estado")
    private boolean estado;

    public solicitud_remision( tipo_remision id_tipo_remision, String usuarion_un_estudiante,
            String usuarion_un_docente, LocalDate fecha_solicitud_remision, String justificacion, boolean estado) {
        this.id_tipo_remision = id_tipo_remision;
        this.usuarion_un_estudiante = usuarion_un_estudiante;
        this.usuarion_un_docente = usuarion_un_docente;
        this.fecha_solicitud_remision = fecha_solicitud_remision;
        this.justificacion = justificacion;
        this.estado = estado;
    }

    public solicitud_remision() {
    }

    public int getId_solicitud_remision() {
        return id_solicitud_remision;
    }

    public tipo_remision getId_tipo_remision() {
        return id_tipo_remision;
    }

    public String getUsuarion_un_estudiante() {
        return usuarion_un_estudiante;
    }

    public String getUsuarion_un_docente() {
        return usuarion_un_docente;
    }

    public LocalDate getFecha_solicitud_remision() {
        return fecha_solicitud_remision;
    }

    public String getJustificacion() {
        return justificacion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setId_solicitud_remision(int id_solicitud_remision) {
        this.id_solicitud_remision = id_solicitud_remision;
    }

    public void setId_tipo_remision(tipo_remision id_tipo_remision) {
        this.id_tipo_remision = id_tipo_remision;
    }

    public void setUsuarion_un_estudiante(String usuarion_un_estudiante) {
        this.usuarion_un_estudiante = usuarion_un_estudiante;
    }

    public void setUsuarion_un_docente(String usuarion_un_docente) {
        this.usuarion_un_docente = usuarion_un_docente;
    }

    public void setFecha_solicitud_remision(LocalDate fecha_solicitud_remision) {
        this.fecha_solicitud_remision = fecha_solicitud_remision;
    }

    public void setJustificacion(String justificacion) {
        this.justificacion = justificacion;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }
}
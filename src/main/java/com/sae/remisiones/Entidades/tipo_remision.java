package com.sae.remisiones.Entidades;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "tipo_remision")

public class tipo_remision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_tipo_remision")
    private int id_tipo_remision;

    

    public tipo_remision(int id_tipo_remision, String tipo_remision) {
        this.tipo_remision = tipo_remision;
    }

    public tipo_remision() {
    }

    @Column(name = "tipo_remision")
    private String tipo_remision;
    
    public int getId_tipo_remision() {
        return id_tipo_remision;
    }

    public String getTipo_remision() {
        return tipo_remision;
    }

    public void setId_tipo_remision(int id_tipo_remision) {
        this.id_tipo_remision = id_tipo_remision;
    }

    public void setTipo_remision(String tipo_remision) {
        this.tipo_remision = tipo_remision;
    }
}
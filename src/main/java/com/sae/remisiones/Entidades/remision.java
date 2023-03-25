package com.sae.remisiones.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;


@Entity
@Table(name = "remision")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class remision {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_remision")
    private int idRemision;

    //relacion 1 a 1 con la tabla solicitud_remision
    @OneToOne
    @JoinColumn(name = "id_solicitud_remision")
    private solicitud_remision solicitudRemision;

    //relacion 1 a 1 con la tabla primera_escucha
    @OneToOne
    @JoinColumn(name = "id_primera_escucha")
    private primera_escucha primeraEscucha;

    @Column(name = "fecha_envio_remision")
    private LocalDate fechaEnvioRemision;
    
    @Column(name = "remision_efectiva")
    private boolean remisionEfectiva;
    
}

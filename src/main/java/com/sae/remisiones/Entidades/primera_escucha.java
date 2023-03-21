package com.sae.remisiones.Entidades;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.GenerationType;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "primera_escucha")

public class primera_escucha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_primera_escucha")
    private int idPrimeraEscucha;

    @Column(name = "observacion")
    private String observacion;

    @Column(name = "fecha_primera_escucha")
    private LocalDate fechaPrimeraEscucha;
    
    @Column(name = "realizada")
    private boolean realizada;
    
}
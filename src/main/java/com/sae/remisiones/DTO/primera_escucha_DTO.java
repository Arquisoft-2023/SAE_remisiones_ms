package com.sae.remisiones.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class primera_escucha_DTO {
    
    private int idPrimeraEscucha;

    private String observacion;

    private LocalDate fechaPrimeraEscucha;
    
    private boolean realizada;

    public primera_escucha_DTO(LocalDate fechaPrimeraEscucha) {
        this.observacion = "Pendiente primera escucha";
        this.fechaPrimeraEscucha = fechaPrimeraEscucha;
        this.realizada = false;
    }

    public primera_escucha_DTO(String observacion, boolean realizada) {
        this.observacion = observacion;
        this.realizada = realizada;
    }

    
    
}

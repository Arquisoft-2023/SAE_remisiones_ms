package com.sae.remisiones.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class primera_escucha_DTO {
    
    private int idPrimeraEscucha;

    private String observacion;

    private LocalDate fechaPrimeraEscucha;
    
    private boolean realizada;

    public primera_escucha_DTO(String observacion, LocalDate fechaPrimeraEscucha) {
        this.observacion = observacion;
        this.fechaPrimeraEscucha = fechaPrimeraEscucha;
        this.realizada = false;
    }

    
    
}

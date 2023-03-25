package com.sae.remisiones.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class remision_DTO {
    
    private int idRemision;

    private int idSolicitudRemision;

    private String observacionPrimeraEscucha;

    private LocalDate fechaPrimeraEscucha;
    
    private boolean remisionEfectiva;

}

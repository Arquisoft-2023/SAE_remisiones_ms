package com.sae.remisiones.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class remision_DTO_reporte {
    
    private int idRemision;

    private int idSolicitudRemision;

    private String usuarioUnEstudiante;

    private String programaCurricular;

    private String usuarioUnDocente;

    private String tipoRemision;
    
    private String justificacionSolicitud;

    private int idPrimeraEscucha;

    private String observacionPrimeraEscucha;

    private boolean PrimeraEscuchaRealizada;

    private LocalDate fechaEnvioRemision;
    
    private boolean remisionEfectiva;
}

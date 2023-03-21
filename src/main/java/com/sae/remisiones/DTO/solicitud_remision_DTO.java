package com.sae.remisiones.DTO;


//import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;


@Data
public class solicitud_remision_DTO {
    
    //@NotEmpty
    private int idSolicitudRemision;

    //@NotEmpty
    private int idTipoRemision;

    //@NotEmpty
    private String tipoRemision;

    //@NotEmpty
    private String usuarioUnEstudiante;

    //@NotEmpty
    private String usuarioUnDocente;

    //@NotEmpty
    private LocalDate fechaSolicitudRemision;

    //@NotEmpty
    private String justificacion;

    //@NotEmpty
    private Boolean estado;

    
}

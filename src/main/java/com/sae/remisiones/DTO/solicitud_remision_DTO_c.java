package com.sae.remisiones.DTO;


//import jakarta.validation.constraints.NotEmpty;
import lombok.Data;


@Data
public class solicitud_remision_DTO_c {
    
    //@NotEmpty
    private int idSolicitudRemision;

    //@NotEmpty
    private int idTipoRemision;

    //@NotEmpty
    private String usuarioUnEstudiante;

    //@NotEmpty
    private String programaCurricular;

    //@NotEmpty
    private String usuarioUnDocente;

    //@NotEmpty
    private String justificacion;
    
}

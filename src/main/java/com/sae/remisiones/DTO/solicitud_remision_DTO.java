package com.sae.remisiones.DTO;


//import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDate;

import com.sae.remisiones.Entidades.tipo_remision;;

@Data
public class solicitud_remision_DTO {
    
    //@NotEmpty
    private int id_solicitud_remision;

    //@NotEmpty
    private tipo_remision tipo_remision;

    //@NotEmpty
    private String usuario_un_estudiante;

    //@NotEmpty
    private String usuario_un_docente;

    //@NotEmpty
    private LocalDate fecha;

    //@NotEmpty
    private String justificacion;

    //@NotEmpty
    private Boolean estado;

    
}

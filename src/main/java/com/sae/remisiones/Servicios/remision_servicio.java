package com.sae.remisiones.Servicios;

import com.sae.remisiones.DTO.remision_DTO_reporte;
import com.sae.remisiones.Entidades.remision;

public interface remision_servicio {
    
    //crear solicitud
    remision saveSolicitud(remision_DTO_reporte remision_DTO);

    //actualizar solicitud
    remision updateSolicitud (int remisionId, remision_DTO_reporte remision_DTO);

}

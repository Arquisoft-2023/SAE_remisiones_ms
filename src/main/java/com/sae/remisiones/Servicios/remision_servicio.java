package com.sae.remisiones.Servicios;

import com.sae.remisiones.DTO.remision_DTO_reporte;

import java.util.List;

import com.sae.remisiones.DTO.remision_DTO;
import com.sae.remisiones.Entidades.remision;



public interface remision_servicio {
    
    //crear solicitud
    remision saveRemision(remision_DTO remision_DTO);

    //actualizar solicitud
    remision updateRemision (int idRemision, remision_DTO remision_DTO);

    remision findByIdRemision(int id);

    List<remision_DTO_reporte> findAllRemisiones();

    List<remision_DTO_reporte> findAllRemisionesByUsuarioUn(String usuarioUn);

    List<remision_DTO_reporte> findAllRemisionesByRemisionEfectiva();

    void deleteByIdRemision(int id);
}

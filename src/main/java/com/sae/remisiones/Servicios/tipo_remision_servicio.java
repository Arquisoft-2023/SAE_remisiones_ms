package com.sae.remisiones.Servicios;

import java.util.List;

import com.sae.remisiones.DTO.tipo_remision_DTO;
import com.sae.remisiones.Entidades.tipo_remision;

public interface tipo_remision_servicio {
    
    tipo_remision findByIdTipoRemision(int id);

    Boolean existsByIdTipoRemision(int id);

    tipo_remision saveTipoRemision(tipo_remision_DTO tipo_remision_DTO);

    tipo_remision updateTipoRemision(int id, tipo_remision_DTO tipo_remision_DTO);


    List<tipo_remision> findAll();

    void deleteByIdTipoRemision(int id);
} 

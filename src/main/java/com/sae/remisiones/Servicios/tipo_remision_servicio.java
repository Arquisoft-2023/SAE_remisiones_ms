package com.sae.remisiones.Servicios;

import java.util.List;

import com.sae.remisiones.DTO.tipo_remision_DTO;
import com.sae.remisiones.Entidades.tipo_remision;

public interface tipo_remision_servicio {
    
    tipo_remision findById(int id);

    Boolean existsById(int id);

    tipo_remision save(tipo_remision_DTO tipo_remision_DTO);

    tipo_remision update(int id, tipo_remision_DTO tipo_remision_DTO);


    List<tipo_remision> findAll();

    void deleteById(int id);
} 

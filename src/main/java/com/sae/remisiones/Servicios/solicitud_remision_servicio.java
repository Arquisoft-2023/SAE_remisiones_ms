package com.sae.remisiones.Servicios;

import java.util.List;
import com.sae.remisiones.DTO.solicitud_remision_DTO;
import com.sae.remisiones.Entidades.solicitud_remision;

public interface solicitud_remision_servicio {
    
    solicitud_remision saveSolicitud(solicitud_remision_DTO solicitud_remision_DTO);

    solicitud_remision updateRequest(int solicitud_remision, solicitud_remision_DTO solicitud_remision_DTO);

    void deleteRequest(solicitud_remision_DTO solicitud_remision_DTO);

    void deleteByIdRequest(int id);

    solicitud_remision findByIdRequest(int id);

    List<solicitud_remision> findAllRequest();

    List<solicitud_remision> findAllRequestsByStatusRequest(Boolean statusRequest);

    List<solicitud_remision> findRequestsByTipo(int tipoid);

}   

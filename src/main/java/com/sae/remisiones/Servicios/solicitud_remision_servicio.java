package com.sae.remisiones.Servicios;

import java.util.List;
import com.sae.remisiones.DTO.solicitud_remision_DTO;
import com.sae.remisiones.Entidades.solicitud_remision;

public interface solicitud_remision_servicio {
    
    //crear solicitud
    solicitud_remision saveSolicitud(solicitud_remision_DTO solicitud_remision_DTO);

    //actualizar solicitud
    solicitud_remision updateSolicitud (int solicitud_remision, solicitud_remision_DTO solicitud_remision_DTO);

    //eliminar solicitud por ID
    void deleteByIdRequest(int id);

    //encontrar solicitud por ID de solicitud
    solicitud_remision findByIdSolicitudRemision(int id);

    //listar todas las solicitudes
    List<solicitud_remision_DTO> findAllSolicitudes();

    //listar todas las solicitudes segun su estado
    List<solicitud_remision> findAllSolicitudesByEstado(Boolean estado);

    //listar todas las solicitudes de un estudiantes
    List<solicitud_remision> findAllSolicitudesByUsuarioUnEstudiante(String usuarioUnEstudiante);

    //listar todas las solicitudes de un docente
    List<solicitud_remision> findAllSolicitudesByUsuarioUnDocente(String usuarioUnDocente);

    //listar todas las solicitudes segun su tipo de remision
    List<solicitud_remision> findAllSolicitudesByTipoRemision(String tipoRemision);
}   

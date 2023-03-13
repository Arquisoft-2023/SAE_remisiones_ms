package com.sae.remisiones.Servicios;

import java.util.List;
import java.util.Optional;

import com.sae.remisiones.Entidades.solicitud_remision;

public interface solicitud_remision_servicio {
    
    public abstract solicitud_remision crear_solicitud_remision(solicitud_remision solicitud_remision);
    public abstract void eliminar_solicitud_remision(int id);
    public abstract List<solicitud_remision> listar_solicitudes();
    public abstract Optional<solicitud_remision> buscar_por_id(int id);
}   

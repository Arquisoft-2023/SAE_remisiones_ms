package com.sae.remisiones.Servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.repositorios.solicitud_remision_repositorio;

@Service
public class solicitud_remision_servicio_impl implements solicitud_remision_servicio{

    @Autowired
    private solicitud_remision_repositorio solicitud_remision_repositorio;

    @Override
    public Optional<solicitud_remision> buscar_por_id(int id) {
        return solicitud_remision_repositorio.findById(id);
    }

    @Override
    public solicitud_remision crear_solicitud_remision(solicitud_remision solicitud_remision) {
        return solicitud_remision_repositorio.save(solicitud_remision);
    }

    @Override
    public void eliminar_solicitud_remision(int id) {
        solicitud_remision_repositorio.deleteById(id);
    }

    @Override
    public List<solicitud_remision> listar_solicitudes() {
        return solicitud_remision_repositorio.findAll();
    }
    
}

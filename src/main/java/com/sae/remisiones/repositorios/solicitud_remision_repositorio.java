package com.sae.remisiones.repositorios;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Entidades.tipo_remision;

@Repository
public interface solicitud_remision_repositorio extends JpaRepository<solicitud_remision, Integer> {
    //List<solicitud_remision> findByTipo(tipo_remision tipo_remision);
    List<solicitud_remision> findByEstado(Boolean statusRequest);
    List<solicitud_remision> findAllByTipoSolicitud(tipo_remision tipo_remision);
    solicitud_remision findByIdSolicitudRemision(int id);

}
package com.sae.remisiones.Repositorios;

import java.util.List;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Entidades.tipo_remision;

@Repository
public interface solicitud_remision_repositorio extends JpaRepository<solicitud_remision, Integer> {

    List<solicitud_remision> findByTipoRemision(tipo_remision tipoRemision);
    List<solicitud_remision> findByEstado(Boolean estado);
    List<solicitud_remision> findByUsuarioUnEstudiante(String usuarioUnEstudiante);
    List<solicitud_remision> findByUsuarioUnDocente(String usuarioUnDocente);
    List<solicitud_remision> findByTipoRemision(String tipoRemision);
    solicitud_remision findByIdSolicitudRemision(int id);

}
package com.sae.remisiones.repositorios;

import java.util.List;
import java.util.Optional;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sae.remisiones.Entidades.solicitud_remision;

@Repository
public interface solicitud_remision_repositorio extends JpaRepository<solicitud_remision, Integer> {
    // Métodos personalizados si es necesario
    /*
    @Query(value = "select buscarid_solicitudes_remision()", nativeQuery = true)
    List<solicitud_remision> lista_solicitudes_remision();
    
    @Query(value = "SELECT id_solicitud_remision, usuario_un_estudiante FROM public.buscarid_solicitudes_remision()", nativeQuery = true)
    List<Object[]> lista_solicitudes_remisiona();
    */
    List<solicitud_remision>findAll();
    Optional<solicitud_remision> findById(int id);

}
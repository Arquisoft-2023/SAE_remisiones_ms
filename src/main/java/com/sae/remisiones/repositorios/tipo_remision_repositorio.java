package com.sae.remisiones.repositorios;


//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sae.remisiones.Entidades.tipo_remision;

@Repository
public interface tipo_remision_repositorio extends JpaRepository<tipo_remision, Integer> {
    // Métodos personalizados si es necesario
    /*
    @Query(value = "select buscar_tipos_remision()", nativeQuery = true)
    List<tipo_remision> lista_solicitudes_remision();
    */
    
    
}
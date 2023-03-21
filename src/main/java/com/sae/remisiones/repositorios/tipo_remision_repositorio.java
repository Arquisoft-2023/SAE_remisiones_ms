package com.sae.remisiones.Repositorios;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sae.remisiones.Entidades.tipo_remision;

@Repository
public interface tipo_remision_repositorio extends JpaRepository<tipo_remision, Integer> {
    tipo_remision findByIdTipoRemision(int id);
}

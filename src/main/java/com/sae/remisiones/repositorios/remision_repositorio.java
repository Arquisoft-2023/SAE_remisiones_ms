package com.sae.remisiones.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sae.remisiones.Entidades.remision;

import java.util.List;

@Repository
@Transactional
public interface remision_repositorio extends JpaRepository<remision, Long> {
    remision findByIdRemision(int id);
    List<remision> findByRemisionEfectiva(Boolean RemisionEfectiva);
}

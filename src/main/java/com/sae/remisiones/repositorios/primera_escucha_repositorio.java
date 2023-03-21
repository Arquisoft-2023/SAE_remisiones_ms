package com.sae.remisiones.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sae.remisiones.Entidades.primera_escucha;

@Repository
@Transactional
public interface primera_escucha_repositorio extends JpaRepository<primera_escucha, Integer> {
    primera_escucha findByIdPrimeraEscucha(int id);
}

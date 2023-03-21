package com.sae.remisiones.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.Entidades.primera_escucha;
import com.sae.remisiones.Repositorios.primera_escucha_repositorio;

@Service
public class primera_escucha_servicio_impl implements primera_escucha_servicio{

    @Autowired
    private primera_escucha_repositorio primera_escucha_repositorio;

    @Override
    public primera_escucha crearPrimeraEscucha(primera_escucha primera_escucha) {
        return primera_escucha_repositorio.save(primera_escucha);
    }
    
}

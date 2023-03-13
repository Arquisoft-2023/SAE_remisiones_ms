package com.sae.remisiones.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.Entidades.tipo_remision;
import com.sae.remisiones.repositorios.tipo_remision_repositorio;

@Service
public class tipo_remision_servicio_impl implements tipo_remision_servicio{

    @Autowired
    private tipo_remision_repositorio tipo_remision_repositorio;

    @Override
    public List<tipo_remision> listaTipoRemision() {
        return tipo_remision_repositorio.findAll();
    }
    
    
}

package com.sae.remisiones.Servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.DTO.tipo_remision_DTO;
import com.sae.remisiones.Entidades.tipo_remision;
import com.sae.remisiones.Mapper.tipo_remision_mapper;
import com.sae.remisiones.repositorios.tipo_remision_repositorio;


@Service
public class tipo_remision_servicio_impl implements tipo_remision_servicio{

    @Autowired
    tipo_remision_repositorio tipo_remision_repositorio;
    @Autowired
    tipo_remision_mapper tipo_remision_mapper;

    @Override
    public void deleteById(int id) {
        tipo_remision_repositorio.deleteById(id);
        
    }

    @Override
    public Boolean existsById(int id) {
        return tipo_remision_repositorio.existsById(id);
    }

    @Override
    public List<tipo_remision> findAll() {
        return tipo_remision_repositorio.findAll();
    }

    @Override
    public tipo_remision findById(int id) {
        tipo_remision tipo_remision = tipo_remision_repositorio.findById(id);
        return tipo_remision;   
    }

    @Override
    public tipo_remision save(tipo_remision_DTO tipo_remision_DTO) {
        tipo_remision tipo_remision = tipo_remision_mapper.convertDTOToObject(tipo_remision_DTO);
        return tipo_remision_repositorio.save(tipo_remision);
    }

    @Override
    public tipo_remision update(int id, tipo_remision_DTO tipo_remision_DTO) {
        tipo_remision tipo_remision = tipo_remision_repositorio.findById(id);
        tipo_remision.setTipo_remision(tipo_remision_DTO.getTipo_remision());
        return null;
    } 
    
}

package com.sae.remisiones.Servicios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.DTO.primera_escucha_DTO;
import com.sae.remisiones.Entidades.primera_escucha;
import com.sae.remisiones.Repositorios.primera_escucha_repositorio;

import java.util.List;

import com.sae.remisiones.Mapper.primera_escucha_mapper;

@Service
public class primera_escucha_servicio_impl implements primera_escucha_servicio{

    @Autowired
    private primera_escucha_repositorio primera_escucha_repositorio;
    @Autowired
    primera_escucha_mapper primera_escucha_mapper;

    @Override
    public void deleteByIdPrimeraEscucha(int id) {
        primera_escucha_repositorio.deleteById(id);
        
    }

    @Override
    public List<primera_escucha> findAll() {
        return primera_escucha_repositorio.findAll();
    }

    @Override
    public primera_escucha findByIdPrimeraEscucha(int id) {
        primera_escucha primera_escucha = primera_escucha_repositorio.findByIdPrimeraEscucha(id);
        return primera_escucha;   
    }

    @Override
    public primera_escucha savePrimeraEscucha(primera_escucha_DTO primera_escucha_DTO) {
        primera_escucha primera_escucha = primera_escucha_mapper.convertDTOToObject(primera_escucha_DTO);
        primera_escucha_repositorio.save(primera_escucha);
        return primera_escucha;
    }

    @Override
    public primera_escucha updatePrimeraEscucha(int id, primera_escucha_DTO primera_escucha_DTO) {
        primera_escucha primera_escucha = primera_escucha_repositorio.findByIdPrimeraEscucha(id);
        primera_escucha.setFechaPrimeraEscucha(primera_escucha_DTO.getFechaPrimeraEscucha());
        primera_escucha.setObservacion(primera_escucha_DTO.getObservacion());
        primera_escucha.setRealizada(primera_escucha_DTO.isRealizada());
        return null;
    } 
    
}

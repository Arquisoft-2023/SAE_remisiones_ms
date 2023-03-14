package com.sae.remisiones.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sae.remisiones.DTO.tipo_remision_DTO;
import com.sae.remisiones.Entidades.tipo_remision;

@Component
public class tipo_remision_mapper {
    public tipo_remision_DTO convertToDto(tipo_remision tipo_remision){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipo_remision, tipo_remision_DTO.class);
    }

    public tipo_remision convertDTOToObject(tipo_remision_DTO tipo_remision_DTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(tipo_remision_DTO, tipo_remision.class);
    }
}

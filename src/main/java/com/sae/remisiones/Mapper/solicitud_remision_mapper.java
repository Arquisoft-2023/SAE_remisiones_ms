package com.sae.remisiones.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sae.remisiones.DTO.solicitud_remision_DTO;
import com.sae.remisiones.Entidades.solicitud_remision;

@Component
public class solicitud_remision_mapper {
    public solicitud_remision_DTO convertToDto(solicitud_remision solicitud_remision){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(solicitud_remision, solicitud_remision_DTO.class);
    }

    public solicitud_remision convertDTOToObject(solicitud_remision_DTO solicitud_remision_DTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(solicitud_remision_DTO, solicitud_remision.class);
    }
}

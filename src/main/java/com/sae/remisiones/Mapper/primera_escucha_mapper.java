package com.sae.remisiones.Mapper;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import com.sae.remisiones.DTO.primera_escucha_DTO;
import com.sae.remisiones.Entidades.primera_escucha;


@Component
public class primera_escucha_mapper {
    public primera_escucha_DTO convertToDto(primera_escucha primera_escucha){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(primera_escucha, primera_escucha_DTO.class);
    }

    public primera_escucha convertDTOToObject(primera_escucha_DTO primera_escucha_DTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(primera_escucha_DTO, primera_escucha.class);
    }
}

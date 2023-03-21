package com.sae.remisiones.Servicios;

import com.sae.remisiones.DTO.primera_escucha_DTO;
import com.sae.remisiones.Entidades.primera_escucha;

import java.util.List;

public interface primera_escucha_servicio {

    primera_escucha findByIdPrimeraEscucha(int id);

    primera_escucha savePrimeraEscucha(primera_escucha_DTO primera_escucha_DTO);

    primera_escucha updatePrimeraEscucha(int id, primera_escucha_DTO primera_escucha_DTO);

    List<primera_escucha> findAll();

    void deleteByIdPrimeraEscucha(int id);
}

package com.sae.remisiones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sae.remisiones.Entidades.primera_escucha;
import com.sae.remisiones.Servicios.primera_escucha_servicio_impl;

@Controller
@RequestMapping("/primera_escucha")

public class primera_escucha_controlador {
    
    @Autowired
    private primera_escucha_servicio_impl primera_escucha_servicio_impl;

    @PostMapping("/crear")
    public ResponseEntity<primera_escucha> createCar(@RequestBody primera_escucha primera_escucha) {
        return new ResponseEntity<>(primera_escucha_servicio_impl.crear_primera_escucha(primera_escucha), HttpStatus.CREATED);
    }
}

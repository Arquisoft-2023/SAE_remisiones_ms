package com.sae.remisiones.Controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sae.remisiones.DTO.primera_escucha_DTO;
import com.sae.remisiones.Entidades.primera_escucha;
import com.sae.remisiones.Servicios.primera_escucha_servicio_impl;

@Controller
@RequestMapping("/primera_escucha")

public class primera_escucha_controlador {
    
    @Autowired
    private primera_escucha_servicio_impl primera_escucha_servicio;

    @GetMapping("/lista")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(primera_escucha_servicio.findAll(), HttpStatus.OK);
    }

    @GetMapping({ "/buscar/{id}" })
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        primera_escucha primera_escucha = primera_escucha_servicio.findByIdPrimeraEscucha(id);
        return new ResponseEntity<primera_escucha>(primera_escucha, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody primera_escucha_DTO primera_escucha_DTO) {
        primera_escucha primera_escucha = primera_escucha_servicio.savePrimeraEscucha(primera_escucha_DTO);
        return new ResponseEntity<primera_escucha>(primera_escucha, HttpStatus.CREATED);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<?> elimina(@PathVariable("id")int id) {
        primera_escucha_servicio.deleteByIdPrimeraEscucha(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
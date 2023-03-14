package com.sae.remisiones.controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sae.remisiones.DTO.tipo_remision_DTO;
import com.sae.remisiones.Entidades.tipo_remision;
import com.sae.remisiones.Servicios.tipo_remision_servicio;

@RestController
@RequestMapping("/tipo_remision")

public class tipo_remision_controlador {

    @Autowired
    tipo_remision_servicio tipo_remision_servicio;

    

    
    @GetMapping("/lista")
    public ResponseEntity<?> findAll() {
        return new ResponseEntity<>(tipo_remision_servicio.findAll(), HttpStatus.OK);
    }
    
    

    @GetMapping({ "/buscar/{id}" })
    public ResponseEntity<?> findById(@PathVariable("id") int id) {
        tipo_remision tipo_remision = tipo_remision_servicio.findById(id);
        return new ResponseEntity<tipo_remision>(tipo_remision, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody tipo_remision_DTO tipo_remision_DTO) {
        tipo_remision tipo_remision = tipo_remision_servicio.save(tipo_remision_DTO);
        return new ResponseEntity<tipo_remision>(tipo_remision, HttpStatus.CREATED);
    }


}
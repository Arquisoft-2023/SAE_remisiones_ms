package com.sae.remisiones.controladores;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sae.remisiones.DTO.solicitud_remision_DTO;
import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Servicios.solicitud_remision_servicio;


@Controller
@RequestMapping("/solicitud_remision")

public class solicitud_remision_controlador {

    @Autowired 
    solicitud_remision_servicio solicitud_remision_servicio;

    

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody solicitud_remision_DTO solicitud_remision_DTO) {
        solicitud_remision solicitud_remision = solicitud_remision_servicio.saveSolicitud(solicitud_remision_DTO);
        return new ResponseEntity<solicitud_remision>(solicitud_remision, HttpStatus.CREATED);
    }
    
    @GetMapping("/lista")
    public ResponseEntity<?> findAllRequest() {
        return new ResponseEntity<>(solicitud_remision_servicio.findAllRequest(), HttpStatus.OK);
    }

    @GetMapping(value = "/lista/{id}")
    public ResponseEntity<?> findRequestsByTipo(@PathVariable int id) {
        return new ResponseEntity<>(solicitud_remision_servicio.findRequestsByTipo(id), HttpStatus.OK);
    }

    @DeleteMapping( "/eliminar/{id}")
    public ResponseEntity<?> elimina(@PathVariable("id")int id) {
        solicitud_remision_servicio.deleteByIdRequest(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping({ "/{solicitud_remision_id}" })
    public ResponseEntity<?> update(@PathVariable("solicitud_remision_id") int solicitud_remision_id, @RequestBody solicitud_remision_DTO solicitud_remision_DTO) {
        solicitud_remision solicitud_remision = solicitud_remision_servicio.updateRequest(solicitud_remision_id, solicitud_remision_DTO );
        return new ResponseEntity<solicitud_remision>(solicitud_remision, HttpStatus.CREATED);
    }
}

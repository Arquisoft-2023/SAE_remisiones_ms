package com.sae.remisiones.controladores;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Servicios.solicitud_remision_servicio;


@RestController
@RequestMapping("/solicitud_remision")

public class solicitud_remision_controlador {

    @Autowired solicitud_remision_servicio solicitud_remision_servicio;

    @PostMapping("/crear")
    public ResponseEntity<solicitud_remision> guarda(@RequestBody solicitud_remision solicitud_remision){
        solicitud_remision solicitud_remision_temporal = solicitud_remision_servicio.crear_solicitud_remision(solicitud_remision);
        try {
            return ResponseEntity.created(new URI("/solicitud_remision/crear"+solicitud_remision_temporal.getId_solicitud_remision())).body(solicitud_remision_temporal);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        
    }
    @GetMapping("/lista")
    public ResponseEntity<List<solicitud_remision>> listaTipoRemision() {
            List<solicitud_remision> lista = solicitud_remision_servicio.listar_solicitudes();
            return new ResponseEntity<>(lista,HttpStatus.OK);
    }

    @DeleteMapping( "/eliminar/{id}")
    public ResponseEntity<?> elimina(@PathVariable("id")int id) {
        solicitud_remision_servicio.eliminar_solicitud_remision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}

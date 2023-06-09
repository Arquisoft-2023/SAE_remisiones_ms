package com.sae.remisiones.Controladores;

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

import com.sae.remisiones.DTO.solicitud_remision_DTO_c;
import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Servicios.solicitud_remision_servicio;


@Controller
@RequestMapping("/solicitud_remision")

public class solicitud_remision_controlador {

    @Autowired 
    solicitud_remision_servicio solicitud_remision_servicio;

    

    @PostMapping("/crear")
    public ResponseEntity<?> save(@RequestBody solicitud_remision_DTO_c solicitud_remision_DTO_c) {
        solicitud_remision solicitud_remision = solicitud_remision_servicio.saveSolicitud(solicitud_remision_DTO_c);
        return new ResponseEntity<solicitud_remision>(solicitud_remision, HttpStatus.CREATED);
    }
    
    @GetMapping("/lista")
    public ResponseEntity<?> findAllRequest() {
        return new ResponseEntity<>(solicitud_remision_servicio.findAllSolicitudes(), HttpStatus.OK);
    }

    @GetMapping(value = "/lista/{usuarioUnEstudiante}")
    public ResponseEntity<?> findSolicitudByUsuarioUnEstudiante(@PathVariable String usuarioUnEstudiante) {
        return new ResponseEntity<>(solicitud_remision_servicio.findAllSolicitudesByUsuarioUnEstudiante(usuarioUnEstudiante), HttpStatus.OK);
    }

    @GetMapping(value = "/lista/{usuarioUnDocente}")
    public ResponseEntity<?> findSolicitudByUsuarioUnDocente(@PathVariable String usuarioUnDocente) {
        return new ResponseEntity<>(solicitud_remision_servicio.findAllSolicitudesByUsuarioUnDocente(usuarioUnDocente), HttpStatus.OK);
    }

    @DeleteMapping( "/eliminar/{id}")
    public ResponseEntity<?> elimina(@PathVariable("id")int id) {
        solicitud_remision_servicio.deleteByIdSolicitud(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/actulizar/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody solicitud_remision_DTO_c solicitud_remision_DTO_c){
        solicitud_remision_servicio.updateSolicitud(id, solicitud_remision_DTO_c);
        return new ResponseEntity<solicitud_remision>(HttpStatus.NO_CONTENT);
    }
}

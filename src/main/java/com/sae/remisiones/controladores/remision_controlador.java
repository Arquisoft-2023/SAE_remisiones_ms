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
import com.sae.remisiones.Servicios.remision_servicio;
import com.sae.remisiones.DTO.remision_DTO;
import com.sae.remisiones.Entidades.remision;

@Controller
@RequestMapping("/remision")
public class remision_controlador {
    
    @Autowired
    remision_servicio remision_servicio;

    @PostMapping("/crear")
    public ResponseEntity<?> saveRemision(@RequestBody remision_DTO remision_DTO) {
        remision remision = remision_servicio.saveRemision(remision_DTO);
        return new ResponseEntity<remision>(remision, HttpStatus.CREATED);
    }

    @GetMapping("/lista")
    public ResponseEntity<?> findAllRemisiones() {
        return new ResponseEntity<>(remision_servicio.findAllRemisiones(), HttpStatus.OK);
    }

    @GetMapping("/listaUsuarioUn/{usuarioUn}")
    public ResponseEntity<?> findAllRemisionesByUsuarioUn(@PathVariable String usuarioUn) {
        return new ResponseEntity<>(remision_servicio.findAllRemisionesByUsuarioUn(usuarioUn), HttpStatus.OK);
    }

    @GetMapping("/listaRemisionesEfectivas")
    public ResponseEntity<?> findAllRemisionesByRemisionEfectiva() {
        return new ResponseEntity<>(remision_servicio.findAllRemisionesByRemisionEfectiva(), HttpStatus.OK);
    }

    @DeleteMapping( "/eliminar/{id}")
    public ResponseEntity<?> elimina(@PathVariable("id")int id) {
        remision_servicio.deleteByIdRemision(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

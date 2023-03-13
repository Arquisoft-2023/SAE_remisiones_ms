package com.sae.remisiones.controladores;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sae.remisiones.Entidades.tipo_remision;
import com.sae.remisiones.Servicios.tipo_remision_servicio;

@RestController
@RequestMapping("/tipo_remision")

public class tipo_remision_controlador {

    @Autowired
    tipo_remision_servicio tipo_remision_servicio;
    
    @GetMapping("/lista")
    public ResponseEntity<List<tipo_remision>> listaTipoRemision() {
            List<tipo_remision> lista = tipo_remision_servicio.listaTipoRemision();
            return new ResponseEntity<>(lista,HttpStatus.OK);
    }


}
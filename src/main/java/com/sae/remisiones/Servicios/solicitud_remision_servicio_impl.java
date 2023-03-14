package com.sae.remisiones.Servicios;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.DTO.solicitud_remision_DTO;
import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Entidades.tipo_remision;
import com.sae.remisiones.Mapper.solicitud_remision_mapper;
import com.sae.remisiones.repositorios.solicitud_remision_repositorio;

@Service
public class solicitud_remision_servicio_impl implements solicitud_remision_servicio{

    @Autowired
    private solicitud_remision_repositorio solicitud_remision_repositorio;
    @Autowired
    private solicitud_remision_mapper solicitud_remision_mapper;
    @Autowired
    private tipo_remision_servicio tipo_remision_servicio;
    @Override


    public void deleteByIdRequest(int id) {
        solicitud_remision solicitud_remision = this.findByIdRequest(id);
        solicitud_remision_repositorio.delete(solicitud_remision);
    }
    @Override
    public void deleteRequest(solicitud_remision_DTO solicitud_remision_DTO) {
        solicitud_remision solicitud_remision = this.findByIdRequest(solicitud_remision_DTO.getId_solicitud_remision());
        solicitud_remision_repositorio.delete(solicitud_remision);
    }
    @Override
    public List<solicitud_remision> findAllRequest() {
        return solicitud_remision_repositorio.findAll();
    }
    @Override
    public List<solicitud_remision> findAllRequestsByStatusRequest(Boolean estado) {
        return solicitud_remision_repositorio.findByEstado(estado);
    }
    @Override
    public solicitud_remision findByIdRequest(int id) {
        solicitud_remision solicitud_remision = solicitud_remision_repositorio.findByIdSolicitudRemision(id);
        return solicitud_remision;
    }
    @Override
    public List<solicitud_remision> findRequestsByTipo(int tipoid) {
        tipo_remision tipo_remision = tipo_remision_servicio.findById(tipoid);
        return solicitud_remision_repositorio.findAllByTipoSolicitud(tipo_remision);
    }
    @Override
    public solicitud_remision saveSolicitud(solicitud_remision_DTO solicitud_remision_DTO) {
        tipo_remision tipo_remision = tipo_remision_servicio.findById(solicitud_remision_DTO.getTipo_remision().getId_tipo_remision());

        LocalDate fecha_solicitud_remision = LocalDate.now();
        solicitud_remision_DTO.setFecha(fecha_solicitud_remision);
        solicitud_remision_DTO.setEstado(false);
        solicitud_remision_DTO.setTipo_remision(tipo_remision);

        solicitud_remision solicitud_remision = solicitud_remision_mapper.convertDTOToObject(solicitud_remision_DTO);
        return solicitud_remision_repositorio.save(solicitud_remision);
    }

    @Override
    public solicitud_remision updateRequest(int solicitud_remision_id, solicitud_remision_DTO solicitud_remision_DTO) {
        solicitud_remision solicitud_remision = this.findByIdRequest(solicitud_remision_id);
        LocalDate fecha = LocalDate.now();
        solicitud_remision.setFecha(fecha);
        solicitud_remision.setEstado(true);
        solicitud_remision.setJustificacion(solicitud_remision_DTO.getJustificacion());
        solicitud_remision.setUsuarioUnDocente(solicitud_remision_DTO.getUsuario_un_docente());
        solicitud_remision.setUsuarioUnEstudiante(solicitud_remision_DTO.getUsuario_un_estudiante());

        return solicitud_remision_repositorio.save(solicitud_remision);
    }

    
    
}

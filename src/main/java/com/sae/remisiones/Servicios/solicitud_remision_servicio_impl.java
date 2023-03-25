package com.sae.remisiones.Servicios;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.DTO.solicitud_remision_DTO;
import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Entidades.tipo_remision;
import com.sae.remisiones.Repositorios.solicitud_remision_repositorio;

@Service
public class solicitud_remision_servicio_impl implements solicitud_remision_servicio{

    @Autowired
    private solicitud_remision_repositorio solicitud_remision_repositorio;
    @Autowired
    private tipo_remision_servicio tipo_remision_servicio;

    @Override
    public solicitud_remision saveSolicitud(solicitud_remision_DTO solicitud_remision_DTO) {
        tipo_remision tipo_remision = tipo_remision_servicio.findByIdTipoRemision(solicitud_remision_DTO.getIdTipoRemision());

        LocalDate fecha_solicitud_remision = LocalDate.now();

        solicitud_remision solicitud_remision = new solicitud_remision();

        solicitud_remision.setFechaSolicitudRemision(fecha_solicitud_remision);
        solicitud_remision.setEstado(false);
        solicitud_remision.setTipoRemision(tipo_remision);
        solicitud_remision.setUsuarioUnEstudiante(solicitud_remision_DTO.getUsuarioUnEstudiante());
        solicitud_remision.setProgramaCurricular(solicitud_remision_DTO.getProgramaCurricular());
        solicitud_remision.setUsuarioUnDocente(solicitud_remision_DTO.getUsuarioUnDocente());
        solicitud_remision.setJustificacion(solicitud_remision_DTO.getJustificacion());

        return solicitud_remision_repositorio.save(solicitud_remision);
    }

    @Override
    public solicitud_remision updateSolicitud(int solicitudRemisionId, solicitud_remision_DTO solicitud_remision_DTO) {
        solicitud_remision solicitud_remision = this.findByIdSolicitudRemision(solicitudRemisionId);

        solicitud_remision.setEstado(true);
        solicitud_remision.setJustificacion(solicitud_remision_DTO.getJustificacion());
        solicitud_remision.setUsuarioUnDocente(solicitud_remision_DTO.getUsuarioUnDocente());
        solicitud_remision.setUsuarioUnEstudiante(solicitud_remision_DTO.getUsuarioUnEstudiante());
        solicitud_remision.setProgramaCurricular(solicitud_remision_DTO.getProgramaCurricular());

        return solicitud_remision_repositorio.save(solicitud_remision);
    }

    @Override
    public void deleteByIdRequest(int id) {
        solicitud_remision solicitud_remision = this.findByIdSolicitudRemision(id);
        solicitud_remision_repositorio.delete(solicitud_remision);
    }

    @Override
    public solicitud_remision findByIdSolicitudRemision(int id) {
        solicitud_remision solicitud_remision = solicitud_remision_repositorio.findByIdSolicitudRemision(id);
        return solicitud_remision;
    }
    
    @Override
    public List<solicitud_remision_DTO> findAllSolicitudes() {
        List<solicitud_remision> listaSolicitudRemison = solicitud_remision_repositorio.findAll();
        List<solicitud_remision_DTO> solicitudes = new ArrayList<solicitud_remision_DTO>();

        for(int i=0;i<listaSolicitudRemison.size();i++){
            solicitud_remision_DTO solicitud_remision_DTO = new solicitud_remision_DTO();

            solicitud_remision_DTO.setIdSolicitudRemision(listaSolicitudRemison.get(i).getIdSolicitudRemision());
            solicitud_remision_DTO.setIdTipoRemision(listaSolicitudRemison.get(i).getTipoRemision().getIdTipoRemision());
            solicitud_remision_DTO.setTipoRemision(listaSolicitudRemison.get(i).getTipoRemision().getTipoRemision());
            solicitud_remision_DTO.setUsuarioUnEstudiante(listaSolicitudRemison.get(i).getUsuarioUnEstudiante());
            solicitud_remision_DTO.setProgramaCurricular(listaSolicitudRemison.get(i).getProgramaCurricular());
            solicitud_remision_DTO.setUsuarioUnDocente(listaSolicitudRemison.get(i).getUsuarioUnDocente());
            solicitud_remision_DTO.setFechaSolicitudRemision(listaSolicitudRemison.get(i).getFechaSolicitudRemision());
            solicitud_remision_DTO.setJustificacion(listaSolicitudRemison.get(i).getJustificacion());
            solicitud_remision_DTO.setEstado(listaSolicitudRemison.get(i).getEstado());

            solicitudes.add(solicitud_remision_DTO);
        }
        return solicitudes;
    }

    @Override
    public List<solicitud_remision> findAllSolicitudesByEstado(Boolean estado) {
        return solicitud_remision_repositorio.findByEstado(estado);
    }

    @Override
    public List<solicitud_remision> findAllSolicitudesByUsuarioUnEstudiante(String usuarionUnEstudiante) {
        return solicitud_remision_repositorio.findByUsuarioUnEstudiante(usuarionUnEstudiante);
    }

    @Override
    public List<solicitud_remision> findAllSolicitudesByUsuarioUnDocente(String usuarionUnDocente) {
        return solicitud_remision_repositorio.findByUsuarioUnEstudiante(usuarionUnDocente);
    }

    @Override
    public List<solicitud_remision> findAllSolicitudesByTipoRemision(String tipoRemision) {
        return solicitud_remision_repositorio.findByTipoRemision(tipoRemision);
    }
    
    
}

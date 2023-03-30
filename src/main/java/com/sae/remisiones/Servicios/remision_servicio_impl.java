package com.sae.remisiones.Servicios;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sae.remisiones.DTO.primera_escucha_DTO;
import com.sae.remisiones.DTO.remision_DTO;
import com.sae.remisiones.DTO.remision_DTO_reporte;
import com.sae.remisiones.Entidades.primera_escucha;
import com.sae.remisiones.Entidades.remision;
import com.sae.remisiones.Entidades.solicitud_remision;
import com.sae.remisiones.Repositorios.primera_escucha_repositorio;
import com.sae.remisiones.Repositorios.remision_repositorio;

@Service
public class remision_servicio_impl implements remision_servicio{

    @Autowired
    private primera_escucha_servicio primera_escucha_servicio;
    @Autowired
    private primera_escucha_repositorio primera_escucha_repositorio;
    @Autowired
    private solicitud_remision_servicio solicitud_remision_servicio;
    @Autowired
    private remision_repositorio remision_repositorio;

    @Override
    public remision saveRemision(remision_DTO remision_DTO) {
        
        solicitud_remision solicitud_remision = solicitud_remision_servicio.findByIdSolicitudRemision(remision_DTO.getIdSolicitudRemision());
        
        primera_escucha_DTO primera_escucha_DTO = new primera_escucha_DTO(remision_DTO.getFechaPrimeraEscucha());

        remision remision = new remision();

        remision.setSolicitudRemision(solicitud_remision);
        remision.getSolicitudRemision().setEstado(true);
        remision.setPrimeraEscucha(primera_escucha_servicio.findByIdPrimeraEscucha(primera_escucha_servicio.savePrimeraEscucha(primera_escucha_DTO).getIdPrimeraEscucha()));
        remision.setFechaEnvioRemision(LocalDate.now());
        remision.setRemisionEfectiva(remision_DTO.isRemisionEfectiva());

        return remision_repositorio.save(remision);
    }

    @Override
    public remision updateRemision(int idRemision, remision_DTO remision_DTO) {
        
        remision remision = this.findByIdRemision(idRemision);

        solicitud_remision solicitud_remision = solicitud_remision_servicio.findByIdSolicitudRemision(remision_DTO.getIdSolicitudRemision());

        remision.setSolicitudRemision(solicitud_remision);
        remision.getSolicitudRemision().setEstado(true);
        remision.getPrimeraEscucha().setFechaPrimeraEscucha(remision_DTO.getFechaPrimeraEscucha());
        remision.getPrimeraEscucha().setObservacion(remision_DTO.getObservacionPrimeraEscucha());
        remision.getPrimeraEscucha().setRealizada(remision_DTO.isRemisionEfectiva());
        remision.setFechaEnvioRemision(LocalDate.now());
        remision.setRemisionEfectiva(remision_DTO.isRemisionEfectiva());

        return remision_repositorio.save(remision);

    }

    @Override
    public remision findByIdRemision(int id) {
        remision remision = remision_repositorio.findByIdRemision(id);
        return remision;
    }

    @Override
    public List<remision_DTO_reporte> findAllRemisiones() {
        List<remision> listaRemisones = remision_repositorio.findAll();
        List<remision_DTO_reporte> remisiones = new ArrayList<remision_DTO_reporte>();

        for (int i = 0; i < listaRemisones.size(); i++) {
            remision_DTO_reporte remision_DTO_reporte = new remision_DTO_reporte();

            remision_DTO_reporte.setIdRemision(listaRemisones.get(i).getIdRemision());
            remision_DTO_reporte.setIdSolicitudRemision(listaRemisones.get(i).getSolicitudRemision().getIdSolicitudRemision());
            remision_DTO_reporte.setUsuarioUnEstudiante(listaRemisones.get(i).getSolicitudRemision().getUsuarioUnEstudiante());
            remision_DTO_reporte.setProgramaCurricular(listaRemisones.get(i).getSolicitudRemision().getProgramaCurricular());
            remision_DTO_reporte.setUsuarioUnDocente(listaRemisones.get(i).getSolicitudRemision().getUsuarioUnDocente());
            remision_DTO_reporte.setTipoRemision(listaRemisones.get(i).getSolicitudRemision().getTipoRemision().getTipoRemision());
            remision_DTO_reporte.setJustificacionSolicitud(listaRemisones.get(i).getSolicitudRemision().getJustificacion());
            remision_DTO_reporte.setIdPrimeraEscucha(listaRemisones.get(i).getPrimeraEscucha().getIdPrimeraEscucha());
            remision_DTO_reporte.setObservacionPrimeraEscucha(listaRemisones.get(i).getPrimeraEscucha().getObservacion());
            remision_DTO_reporte.setPrimeraEscuchaRealizada(listaRemisones.get(i).getPrimeraEscucha().isRealizada());
            remision_DTO_reporte.setFechaEnvioRemision(listaRemisones.get(i).getFechaEnvioRemision());
            remision_DTO_reporte.setRemisionEfectiva(listaRemisones.get(i).isRemisionEfectiva());

            remisiones.add(remision_DTO_reporte);
        }
        return remisiones;
    }

    @Override
    public List<remision_DTO_reporte> findAllRemisionesByRemisionEfectiva() {

        List<remision> listaRemisones = remision_repositorio.findAll();
        List<remision_DTO_reporte> remisiones = new ArrayList<remision_DTO_reporte>();

        for (int i = 0; i < listaRemisones.size(); i++) {
            remision_DTO_reporte remision_DTO_reporte = new remision_DTO_reporte();

            if(listaRemisones.get(i).isRemisionEfectiva()){

                remision_DTO_reporte.setIdRemision(listaRemisones.get(i).getIdRemision());
                remision_DTO_reporte.setIdSolicitudRemision(listaRemisones.get(i).getSolicitudRemision().getIdSolicitudRemision());
                remision_DTO_reporte.setUsuarioUnEstudiante(listaRemisones.get(i).getSolicitudRemision().getUsuarioUnEstudiante());
                remision_DTO_reporte.setProgramaCurricular(listaRemisones.get(i).getSolicitudRemision().getProgramaCurricular());
                remision_DTO_reporte.setUsuarioUnDocente(listaRemisones.get(i).getSolicitudRemision().getUsuarioUnDocente());
                remision_DTO_reporte.setTipoRemision(listaRemisones.get(i).getSolicitudRemision().getTipoRemision().getTipoRemision());
                remision_DTO_reporte.setJustificacionSolicitud(listaRemisones.get(i).getSolicitudRemision().getJustificacion());
                remision_DTO_reporte.setIdPrimeraEscucha(listaRemisones.get(i).getPrimeraEscucha().getIdPrimeraEscucha());
                remision_DTO_reporte.setObservacionPrimeraEscucha(listaRemisones.get(i).getPrimeraEscucha().getObservacion());
                remision_DTO_reporte.setPrimeraEscuchaRealizada(listaRemisones.get(i).getPrimeraEscucha().isRealizada());
                remision_DTO_reporte.setFechaEnvioRemision(listaRemisones.get(i).getFechaEnvioRemision());
                remision_DTO_reporte.setRemisionEfectiva(listaRemisones.get(i).isRemisionEfectiva());

                remisiones.add(remision_DTO_reporte);
            }
        }

        return remisiones;
    }

    @Override
    public List<remision_DTO_reporte> findAllRemisionesByUsuarioUn(String usuarioUn) {
        List<remision> listaRemisones = remision_repositorio.findAll();
        List<remision_DTO_reporte> remisiones = new ArrayList<remision_DTO_reporte>();

        for (int i = 0; i < listaRemisones.size(); i++) {
            remision_DTO_reporte remision_DTO_reporte = new remision_DTO_reporte();

            if(listaRemisones.get(i).getSolicitudRemision().getUsuarioUnEstudiante().equals(usuarioUn) || 
               listaRemisones.get(i).getSolicitudRemision().getUsuarioUnDocente().equals(usuarioUn)){

                remision_DTO_reporte.setIdRemision(listaRemisones.get(i).getIdRemision());
                remision_DTO_reporte.setIdSolicitudRemision(listaRemisones.get(i).getSolicitudRemision().getIdSolicitudRemision());
                remision_DTO_reporte.setUsuarioUnEstudiante(listaRemisones.get(i).getSolicitudRemision().getUsuarioUnEstudiante());
                remision_DTO_reporte.setProgramaCurricular(listaRemisones.get(i).getSolicitudRemision().getProgramaCurricular());
                remision_DTO_reporte.setUsuarioUnDocente(listaRemisones.get(i).getSolicitudRemision().getUsuarioUnDocente());
                remision_DTO_reporte.setTipoRemision(listaRemisones.get(i).getSolicitudRemision().getTipoRemision().getTipoRemision());
                remision_DTO_reporte.setJustificacionSolicitud(listaRemisones.get(i).getSolicitudRemision().getJustificacion());
                remision_DTO_reporte.setIdPrimeraEscucha(listaRemisones.get(i).getPrimeraEscucha().getIdPrimeraEscucha());
                remision_DTO_reporte.setObservacionPrimeraEscucha(listaRemisones.get(i).getPrimeraEscucha().getObservacion());
                remision_DTO_reporte.setPrimeraEscuchaRealizada(listaRemisones.get(i).getPrimeraEscucha().isRealizada());
                remision_DTO_reporte.setFechaEnvioRemision(listaRemisones.get(i).getFechaEnvioRemision());
                remision_DTO_reporte.setRemisionEfectiva(listaRemisones.get(i).isRemisionEfectiva());

                remisiones.add(remision_DTO_reporte);
            }
        }
        
        return remisiones;
    }
    
    @Override
    public void deleteByIdRemision(int id) {
        remision remision = this.findByIdRemision(id);
        primera_escucha primera_escucha = primera_escucha_servicio.findByIdPrimeraEscucha(remision.getPrimeraEscucha().getIdPrimeraEscucha());
        remision_repositorio.delete(remision);
        primera_escucha_repositorio.delete(primera_escucha);
    }

    @Override
    public remision updateRemisionEfectiva(int idRemision, primera_escucha_DTO primera_escucha_DTO) {

        remision remision = remision_repositorio.findByIdRemision(idRemision);
        primera_escucha primera_escucha = primera_escucha_servicio.findByIdPrimeraEscucha(remision.getPrimeraEscucha().getIdPrimeraEscucha());
        primera_escucha.setObservacion(primera_escucha_DTO.getObservacion());
        primera_escucha.setRealizada(primera_escucha_DTO.isRealizada());

        primera_escucha_repositorio.save(primera_escucha);

        remision.getPrimeraEscucha().setObservacion(primera_escucha_DTO.getObservacion());
        remision.setRemisionEfectiva(primera_escucha_DTO.isRealizada());

        return remision_repositorio.save(remision);

    }

    

}

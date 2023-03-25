package com.sae.remisiones.Entidades;
import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "solicitud_remision")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class solicitud_remision implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_solicitud_remision")
    private int idSolicitudRemision;

    @OneToOne
    @JoinColumn(name = "id_tipo_remision")
    private tipo_remision tipoRemision;

    @Column(name = "usuario_un_estudiante")
    private String usuarioUnEstudiante;

    @Column(name = "programa_curricular")
    private String programaCurricular;

    @Column(name = "usuario_un_docente")
    private String usuarioUnDocente;

    @Column(name = "fecha_solicitud_remision")
    private LocalDate fechaSolicitudRemision;

    @Column(name = "justificacion")
    private String justificacion;

    @Column(name = "estado")
    private Boolean estado;

}
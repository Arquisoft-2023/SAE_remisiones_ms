package com.sae.remisiones.DTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Data
public class tipo_remision_DTO {
    
    private int idTipoRemision;

    private String tipoRemision;

    public tipo_remision_DTO(String tipoRemision) {
        this.tipoRemision = tipoRemision;
    }

}
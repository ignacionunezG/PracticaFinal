package com.PracticaFinal.madPark.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("HISTORIAL")
public class Historial {
 
    private String email;
    private int idPark;
    private String parking;
    
    
}

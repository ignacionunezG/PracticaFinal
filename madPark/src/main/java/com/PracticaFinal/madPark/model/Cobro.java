package com.PracticaFinal.madPark.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("COBRO")
public class Cobro {
 
    @Id
    private String email;
    
    private int idPark;
    private String date;
    private String time;
    private float cost;
    
    public String getEmail() {
        return email;
    }
    
    
}

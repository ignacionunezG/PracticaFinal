package com.PracticaFinal.madPark.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("USER")
public class User {
    
    private String name;
    private String apellidos;
    @Id
    private String email;
    private String password;
    private long numTarjeta;
    private int cvv;
    private String caducidad;
    
    public String getEmail() {
        return this.email;
    }
    
}

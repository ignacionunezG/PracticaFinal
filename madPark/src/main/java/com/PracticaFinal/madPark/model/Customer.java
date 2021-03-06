package com.PracticaFinal.madPark.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("CUSTOMER")
public class Customer {
    @Id
    private Long id;
    private String name;
    private String apellidos;
    private String email;
    private String password;
    private Long numTarjeta;
    private int cvv;
    private String caducidad;

    public Customer(String name, String apellidos, String email, String password, Long numTarjeta, int cvv,
            String caducidad) {
        this.name = name;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.numTarjeta = numTarjeta;
        this.cvv = cvv;
        this.caducidad = caducidad;
    }

    public Customer() {
    }
    public void setName(String name) {
        this.name=name;
    }
    public void setApellidos(String apellidos) {
        this.apellidos=apellidos;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public void setPassword(String password) {
        this.password=password;
    }
    public void setNumTarjeta(Long numTarjeta) {
        this.numTarjeta=numTarjeta;
    }
    public void setCvv(int cvv) {
        this.cvv=cvv;
    }
    public void setCaducidad(String caducidad) {
        this.caducidad=caducidad;
    }

    public String getName(){
        return this.name;
    }

    public String getApellidos(){
        return this.apellidos;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPassword(){
        return this.password;
    }
    public Long getNumTarjeta(){
        return this.numTarjeta;
    }
    public int getCvv(){
        return this.cvv;
    }
    public String getCaducidad(){
        return this.caducidad;
    }
}

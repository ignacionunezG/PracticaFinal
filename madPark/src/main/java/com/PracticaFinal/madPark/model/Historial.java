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

    public String getEmail() {
        return this.email;
    }

    public int getIdPark() {
        return this.idPark;
    }

    public String getParking() {
        return this.parking;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdPark(int idPark) {
        this.idPark = idPark;
    }

    public void setParking(String parking) {
        this.parking = parking;
    }
}

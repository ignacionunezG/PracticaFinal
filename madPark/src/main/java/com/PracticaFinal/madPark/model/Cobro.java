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
        return this.email;
    }
    public int getIdPark() {
        return this.idPark;
    }
    public String getDate() {
        return this.date;
    }
    public String getTime() {
        return this.time;
    }
    public float getCost() {
        return this.cost;
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public void setIdPark(int idPark) {
        this.idPark=idPark;
    }
    public void setDate(String date) {
        this.date=date;
    }
    public void setTime(String time) {
        this.time=time;
    }
    public void setCost(float cost) {
        this.cost=cost;
    }
    
    
}

package com.PracticaFinal.madPark.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("MATRICULAS")
public class Matriculas {
    @Id
    private String email;
    private String matricula1;
    private String matricula2;
    private String matricula3;
    private String matricula4;
    private String matricula5;

    public Matriculas() {
    }
    public void setEmail(String email) {
        this.email=email;
    }
    public void setMatricula1(String matricula1) {
        this.matricula1=matricula1;
    }
    public void setMatricula2(String matricula2) {
        this.matricula2=matricula2;
    }
    public void setMatricula3(String matricula3) {
        this.matricula3=matricula3;
    }
    public void setMatricula4(String matricula4) {
        this.matricula4=matricula4;
    }
    public void setMatricula5(String matricula5) {
        this.matricula5=matricula5;
    }

    
    public String getEmail(){
        return this.email;
    }
    public String getMatricula1(){
        return this.matricula1;
    }
    public String getMatricula2(){
        return this.matricula2;
    }
    public String getMatricula3(){
        return this.matricula3;
    }
    public String getMatricula4(){
        return this.matricula4;
    }
    public String getMatricula5(){
        return this.matricula5;
    }
  
}

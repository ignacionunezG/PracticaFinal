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


    private ArrayList<String> matriculas = new ArrayList<String>();

    public ArrayList<String> getMatriculas() {
        matriculas.add(matricula1);
        matriculas.add(matricula2);
        matriculas.add(matricula3);
        matriculas.add(matricula4);
        matriculas.add(matricula5);
        return matriculas;
    }
}

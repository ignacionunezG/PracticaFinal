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
    
    private String email;
    private String matricula1;
    private String matricula2;
    private String matricula3;
    private String matricula4;
    private String matricula5;
  
}

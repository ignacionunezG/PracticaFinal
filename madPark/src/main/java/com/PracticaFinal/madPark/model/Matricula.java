package com.PracticaFinal.madPark.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Table("MATRICULA")
public class Matricula {
    @Id
    private String email;
    private String matricula;
}

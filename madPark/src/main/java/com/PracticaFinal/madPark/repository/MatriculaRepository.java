package com.PracticaFinal.madPark.repository;



import com.PracticaFinal.madPark.model.Matricula;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface MatriculaRepository extends CrudRepository<Matricula, String> {
    
}

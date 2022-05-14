package com.PracticaFinal.madPark.repository;



import com.PracticaFinal.madPark.model.Matriculas;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface MatriculasRepository extends CrudRepository<Matriculas, String> {
    @Query("SELECT * FROM MATRICULAS WHERE USER.EMAIL= :email")
    public Matriculas retrieveMatriculas(String email);

}

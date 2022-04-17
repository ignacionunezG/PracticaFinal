package com.PracticaFinal.madPark.repository;

import com.PracticaFinal.madPark.model.Cobro;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface CobroRepository extends CrudRepository<Cobro, String> {
    
}

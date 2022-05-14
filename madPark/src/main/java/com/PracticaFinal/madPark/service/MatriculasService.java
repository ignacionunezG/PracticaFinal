package com.PracticaFinal.madPark.service;
import java.util.ArrayList;

import com.PracticaFinal.madPark.model.Matriculas;

public interface MatriculasService {
    Matriculas retrieveMatriculas(String email);
    Iterable<Matriculas> retrieveAllMatriculas();
    Matriculas updateMatriculas(String email, Matriculas matriculas);


}

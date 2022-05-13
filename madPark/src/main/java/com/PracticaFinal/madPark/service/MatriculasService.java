package com.PracticaFinal.madPark.service;
import java.util.ArrayList;

import com.PracticaFinal.madPark.model.Matriculas;

public interface MatriculasService {
    ArrayList<String> retrieveMatriculas(String email);
    Iterable<Matriculas> retrieveAllMatriculas();
    Matriculas updateMatriculas(String email, Matriculas matriculas);


}

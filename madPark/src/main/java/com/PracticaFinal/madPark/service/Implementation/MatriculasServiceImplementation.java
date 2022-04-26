package com.PracticaFinal.madPark.service.Implementation;

import com.PracticaFinal.madPark.repository.MatriculasRepository;

import java.util.ArrayList;

import com.PracticaFinal.madPark.model.Matriculas;

import com.PracticaFinal.madPark.service.MatriculasService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service

public class MatriculasServiceImplementation implements MatriculasService{
    @Autowired
    private MatriculasRepository matriculasRepository;
    
    
    @Override
    public Iterable<Matriculas> retrieveAllMatriculas() {
        return matriculasRepository.findAll();
    }

    
    @Override
    public ArrayList<String> retrieveMatriculas(String email) {
        ArrayList<String> response = null;

        if (matriculasRepository.existsById(email)) {
            Matriculas matriculas = matriculasRepository.retrieveMatriculas(email);
            ArrayList<String> listaMatriculas = matriculas.getMatriculas();
            //for (Matriculas matricula : matriculas) {
            response = listaMatriculas;
            //}
            return response;
        }
        return response;
    }
}



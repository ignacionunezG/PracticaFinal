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
    public Matriculas retrieveMatriculas(String email) {
        Matriculas response = null;

        if (matriculasRepository.existsById(email)) {
            Matriculas matriculas = matriculasRepository.retrieveMatriculas(email);

            response= matriculas;
            return response;
        }
        return response;
    }

    
    @Override
    public Matriculas updateMatriculas(String email, Matriculas matriculas) {
        if (matriculasRepository.existsById(email)) {
            return matriculasRepository.save(matriculas);
        } else {
            return null;
        }
    }

}



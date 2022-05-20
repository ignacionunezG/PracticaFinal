package com.PracticaFinal.madPark.service.Implementation;

import com.PracticaFinal.madPark.repository.HistorialRepository;
import com.PracticaFinal.madPark.model.Historial;

import com.PracticaFinal.madPark.service.HistorialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class HistorialServiceImplementation implements HistorialService{

    @Autowired
    private HistorialRepository historialRepository;
    
    
    @Override
    public Iterable<Historial> retrieveAllHistorial() {
        return historialRepository.findAll();
    }

    
    @Override
    public Historial retrieveHistorial(String email) {
        Historial response = null;

        if (historialRepository.existsById(email)) {
            Historial historial = historialRepository.retrieveHistorial(email);

            response= historial;
            return response;
        }
        return response;
    }

    
    @Override
    public Historial updateHistorial(String email, Historial Historial) {
        if (historialRepository.existsById(email)) {
            return historialRepository.save(Historial);
        } else {
            return null;
        }
    }
}



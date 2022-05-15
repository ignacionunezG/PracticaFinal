package com.PracticaFinal.madPark.service.Implementation;

import com.PracticaFinal.madPark.repository.CobroRepository;
import com.PracticaFinal.madPark.model.Cobro;
import com.PracticaFinal.madPark.model.Customer;
import com.PracticaFinal.madPark.service.CobroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CobroServiceImplementation implements CobroService{

    @Autowired
    private CobroRepository cobroRepository;

    @Override
    public Cobro retrieveCobro(String email) {
        Cobro response = null;

        if(cobroRepository.existsById(email)){
            Iterable<Cobro> cobros = cobroRepository.retrieveCobro(email);
            for(Cobro cobro : cobros){
                response = cobro;
            }
            return response;
        }
        return response;
        
    }

    @Override
    public Iterable<Cobro> retrieveAllCobros() {
        return cobroRepository.findAll();
    }

    @Override
    public Cobro createCobro(Cobro cobro) {
        String email = cobro.getEmail();
        Cobro response = null;

        if(cobroRepository.existsById(email)){
            response = cobroRepository.save(cobro);
        }
        return response;
    }
    
}



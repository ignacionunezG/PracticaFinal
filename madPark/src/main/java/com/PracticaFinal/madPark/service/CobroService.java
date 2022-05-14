package com.PracticaFinal.madPark.service;
import com.PracticaFinal.madPark.model.Cobro;

public interface CobroService {
    Cobro retrieveCobro(String email);
    Iterable<Cobro> retrieveAllCobros();
    Cobro createCobro(Cobro cobro);
}

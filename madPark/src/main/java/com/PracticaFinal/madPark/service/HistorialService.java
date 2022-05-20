package com.PracticaFinal.madPark.service;
import com.PracticaFinal.madPark.model.Historial;

public interface HistorialService {
    Historial retrieveHistorial(String email);
    Iterable<Historial> retrieveAllHistorial();
    Historial updateHistorial(String email, Historial idParking);
    Historial createHistorial(Historial historial);
}

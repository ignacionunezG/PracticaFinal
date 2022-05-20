package com.PracticaFinal.madPark.repository;



import com.PracticaFinal.madPark.model.Historial;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface HistorialRepository extends CrudRepository<Historial, String> {
    @Query("SELECT * FROM HISTORIAL WHERE USER.EMAIL= :email")
    public Historial retrieveHistorial(String email);
}

package com.PracticaFinal.madPark.repository;



import com.PracticaFinal.madPark.model.User;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, String> {
    @Query("SELECT * FROM USER WHERE USER.EMAIL= :email")
    public Iterable<User> retrieveUser(String email);

}

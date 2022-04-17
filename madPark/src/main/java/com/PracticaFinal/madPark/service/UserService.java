package com.PracticaFinal.madPark.service;
import com.PracticaFinal.madPark.model.User;

public interface UserService {
    User retrieveUser(String email);
    User createUser(User user);
    Iterable<User> retrieveAllUsers();


}

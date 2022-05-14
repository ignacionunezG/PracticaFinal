package com.PracticaFinal.madPark.service.Implementation;
import com.PracticaFinal.madPark.repository.UserRepository;
import com.PracticaFinal.madPark.model.User;
import com.PracticaFinal.madPark.service.UserService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImplementation implements UserService{
    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User retrieveUser(String email) {
        User response = null;

        if (userRepository.existsById(email)) {
            Iterable<User> users = userRepository.retrieveUser(email);
            for (User user : users) {
                response = user;
            }
            return response;
        }
        return response;
    }
    
    @Override
    public Iterable<User> retrieveAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

}




package com.PracticaFinal.madPark.service.Implementation;
import com.PracticaFinal.madPark.repository.CustomerRepository;

import java.util.ArrayList;
import java.util.List;

import com.PracticaFinal.madPark.model.Customer;
import com.PracticaFinal.madPark.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
@Service
public class CustomerServiceImplementation implements CustomerService{
    @Autowired
    private CustomerRepository customerRepository;
    
    @Override
    public Customer retrieveCustomer(String email) {
        Customer response = null;

        if (customerRepository.existsById(email)) {
            Iterable<Customer> customers = customerRepository.retrieveCustomer(email);
            for (Customer customer : customers) {
                response = customer;
            }
            return response;
        }
        return response;
    }
    
    @Override
    public Iterable<Customer> retrieveAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
        //jdbcTemplate.execute("INSERT INTO PEDIDOS (PEDIDO_ID, PRECIO, ESTADO) VALUES ("+id+","+0+","+0+")")
    }

    @Override
    public UserDetails loadUserByUsername(String email){
        Customer user = customerRepository.findByEmail(email);
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails newUser = new User(user.getEmail(), user.getPassword(), authorities);
        return newUser;
    }

}




package com.PracticaFinal.madPark.service;
import com.PracticaFinal.madPark.model.Customer;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface CustomerService extends UserDetailsService {
    Customer retrieveCustomer(String email);
    Customer createCustomer(Customer customer);
    Iterable<Customer> retrieveAllCustomers();

    


}

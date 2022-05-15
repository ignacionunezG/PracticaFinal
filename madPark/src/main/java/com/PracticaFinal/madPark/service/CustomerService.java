package com.PracticaFinal.madPark.service;
import com.PracticaFinal.madPark.model.Customer;

public interface CustomerService {
    Customer retrieveCustomer(String email);
    Customer createCustomer(Customer customer);
    Iterable<Customer> retrieveAllCustomers();


}

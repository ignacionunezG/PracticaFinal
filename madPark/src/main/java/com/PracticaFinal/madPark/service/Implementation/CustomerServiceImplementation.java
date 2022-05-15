package com.PracticaFinal.madPark.service.Implementation;
import com.PracticaFinal.madPark.repository.CustomerRepository;
import com.PracticaFinal.madPark.model.Customer;
import com.PracticaFinal.madPark.service.CustomerService;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.beans.factory.annotation.Autowired;
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
    }

}




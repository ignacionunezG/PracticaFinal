package com.PracticaFinal.madPark.repository;



import com.PracticaFinal.madPark.model.Customer;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, String> {
    @Query("SELECT * FROM CUSTOMER WHERE CUSTOMER.EMAIL= :email")
    public Iterable<Customer> retrieveCustomer(String email);
    public Customer findByEmail(String email);

}
